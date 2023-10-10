package ru.aston.springservice.controllers;

import ru.aston.springservice.entities.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.springservice.services.StudentService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {
    private StudentController studentController;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = mock(StudentService.class);
        studentController = new StudentController(studentService);
    }

    @Test
    void createStudent() throws Exception {
        StudentDTO expected = new StudentDTO();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        when(studentService.create(expected)).thenReturn(expected);

        StudentDTO actual = studentController.createStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void readStudent() throws Exception {
        StudentDTO expected = new StudentDTO();
        expected.setStudentId(Long.valueOf(1l).toString());
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        when(studentService.read(Long.parseLong(expected.getStudentId()))).thenReturn(expected);

        StudentDTO actual = studentController.readStudent(Long.parseLong(expected.getStudentId()));
        assertEquals(expected, actual);
    }

    @Test
    void updateStudent() throws Exception {
        StudentDTO expected = new StudentDTO();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        when(studentService.update(expected)).thenReturn(expected);

        StudentDTO actual = studentController.updateStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deleteStudent() throws Exception {
        StudentDTO expected = new StudentDTO();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");

        studentController.deleteStudent(expected);

        verify(studentService, atLeastOnce()).delete(any(StudentDTO.class));
    }
}