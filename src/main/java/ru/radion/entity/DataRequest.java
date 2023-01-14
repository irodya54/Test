package ru.radion.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor

public class DataRequest {

    private Long id;
    private String name;
    private Integer age;
}
