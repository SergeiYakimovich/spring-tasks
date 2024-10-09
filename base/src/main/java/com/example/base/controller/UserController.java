package com.example.base.controller;

import com.example.base.service.UserService;
import com.example.base.dto.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto save(@RequestBody @Valid @NotNull UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping
    public List<UserDto> findByName(@RequestParam @NotNull String name) {
        return userService.findByName(name);
    }

    @PutMapping("/{id}")
    public boolean updateAddress(@PathVariable @NotNull Long id, @RequestParam @NotNull String newAddress) {
        return userService.updateAddress(id, newAddress);
    }

}
