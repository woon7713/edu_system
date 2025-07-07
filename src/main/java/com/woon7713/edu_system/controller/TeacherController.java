package com.woon7713.edu_system.controller;

import com.woon7713.edu_system.model.Teacher;
import com.woon7713.edu_system.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());

        return "teacher-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("teacher", new Teacher());

        return "teacher-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);

        return "redirect:/teachers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        model.addAttribute("teacher", teacherRepository.findById(id));
        return "teacher-form";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Teacher teacher){
        teacherRepository.update(teacher);

        return "redirect:/teachers";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        try{
            int affected = teacherRepository.deleteById(id);
            if (affected == 0) {
                System.out.println("해당 교사를 찾을 수 없습니다.");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        return "redirect:/teachers";
    }


}