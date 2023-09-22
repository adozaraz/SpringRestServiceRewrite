package controllers;

import entities.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import services.StudentService;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setFirstName("Nikita");
        student.setLastName("Boradulin");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createStudent() {
    }

    @Test
    void readStudent() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }
}