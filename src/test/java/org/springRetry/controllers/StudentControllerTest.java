package org.springRetry.controllers;

import org.springRetry.entities.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springRetry.services.StudentService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
        expected.setStudentId(UUID.randomUUID().toString());
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        when(studentService.read(UUID.fromString(expected.getStudentId()))).thenReturn(expected);

        StudentDTO actual = studentController.readStudent(UUID.fromString(expected.getStudentId()));
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