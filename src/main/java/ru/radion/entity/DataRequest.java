package ru.radion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DataRequest {

    private Long id;
    private String name;
    private Integer age;
}
