package com.example.demo.borisov2.врачи;

import borisov.Лечение;
import com.example.demo.borisov2.config.InjectList;
import com.example.demo.borisov2.методы.Аспирин;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Доктор implements Целитель {
    @InjectList({Аспирин.class})
    private List<Лечение> лекарства;
    @Override
    public void лечить() {
        лекарства.forEach(Лечение::применить);
        throw new ClassCastException("Доктор не может лечить");
    }

    @Override
    public String getType() {
        return "Доктор";
    }
}
