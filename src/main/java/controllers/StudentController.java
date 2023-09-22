package controllers;

import entities.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.StudentService;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) { return this.studentService.create(studentDTO); }

    @GetMapping("/get/{uuid}")
    public StudentDTO readStudent(@PathVariable UUID uuid) { return this.studentService.read(uuid); }

    @PostMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) { return this.studentService.update(studentDTO); }

    @PostMapping("/delete")
    public void deleteStudent(@RequestBody StudentDTO studentDTO) { this.studentService.delete(studentDTO); }
}
