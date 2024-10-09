package com.example.base.controller;

import com.example.base.dto.UserDto;
import com.example.base.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.example.base.factory.UserFactory.getUserDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserServiceImpl userService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSave() throws Exception {
        UserDto userDto = getUserDto();
        when(userService.save(any())).thenReturn(userDto);

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
        UserDto result = objectMapper.readValue(contentAsString, UserDto.class);

        assertThat(result).usingRecursiveComparison().isEqualTo(userDto);
    }

    @Test
    void testSaveFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(objectMapper.writeValueAsString(null))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));

        UserDto userDto = getUserDto();
        userDto.setName(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    void findByName() throws Exception {
        when(userService.findByName(any())).thenReturn(List.of(getUserDto()));

        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                        .param("name", "Ivan"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$[0].name").value("Ivan"))
                .andExpect(jsonPath("$[0].address").value("New York"));
    }

    @Test
    void updateAddress() throws Exception {
        when(userService.updateAddress(any(), any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                        .param("newAddress", "London"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$").value("true"));
    }
}