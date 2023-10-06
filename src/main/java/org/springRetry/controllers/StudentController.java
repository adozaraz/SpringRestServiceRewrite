package org.springRetry.controllers;

import org.springRetry.entities.StudentDTO;
import org.springframework.web.bind.annotation.*;
import org.springRetry.services.StudentService;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) { return this.studentService.create(studentDTO); }

    @GetMapping("/get/{uuid}")
    public StudentDTO readStudent(@PathVariable UUID uuid) { return this.studentService.read(uuid); }

    @PostMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) { return this.studentService.update(studentDTO); }

    @PostMapping("/delete")
    public void deleteStudent(@RequestBody StudentDTO studentDTO) { this.studentService.delete(studentDTO); }
}
