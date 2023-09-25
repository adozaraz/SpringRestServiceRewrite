package services;

import entities.Student;
import entities.StudentDTO;
import mappers.StudentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import repositories.StudentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentService(studentRepository, studentMapper);
    }

    @Test
    void create() {
        Student toCreate = new Student();
        toCreate.setFirstName("Nikita");
        toCreate.setLastName("Boradulin");
        StudentDTO expected = studentMapper.studentToStudentDTO(toCreate);

        when(studentRepository.save(any(Student.class))).thenReturn(toCreate);
        StudentDTO actual = studentService.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    void read() {
        Student toCreate = new Student();
        toCreate.setFirstName("Nikita");
        toCreate.setLastName("Boradulin");
        StudentDTO expected = studentMapper.studentToStudentDTO(toCreate);

        when(studentRepository.findById(toCreate.getStudentId())).thenReturn(Optional.of(toCreate));
        StudentDTO actual = studentService.read(toCreate.getStudentId());
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        Student toCreate = new Student();
        toCreate.setFirstName("Nikita");
        toCreate.setLastName("Boradulin");
        StudentDTO expected = studentMapper.studentToStudentDTO(toCreate);

        when(studentRepository.save(toCreate)).thenReturn(toCreate);
        StudentDTO actual = studentService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        Student toCreate = new Student();
        toCreate.setFirstName("Nikita");
        toCreate.setLastName("Boradulin");
        StudentDTO expected = studentMapper.studentToStudentDTO(toCreate);

        studentService.delete(expected);
        verify(studentRepository, atLeastOnce()).delete(toCreate);
    }
}