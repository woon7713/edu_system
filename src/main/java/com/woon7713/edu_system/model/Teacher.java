package com.woon7713.edu_system.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    private Integer id; // id에서 method를 스기 위해 Integer로
    private String name;

}
