package com.woon7713.edu_system.repository;

import com.woon7713.edu_system.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeacherRepository {
    private final JdbcTemplate jdbcTemplate;


    public int save(Teacher teacher) {
        return jdbcTemplate.update(
                "INSERT INTO teacher (name) VALUES (?)", teacher.getName()
        );
    }



}
