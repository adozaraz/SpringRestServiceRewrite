package repositories;

import entities.Student;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class StudentRepositoryTest {
    private StudentRepository studentRepository;
    @Test
    void create() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");

        Student actual = studentRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void read() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        Optional<Student> actual = studentRepository.findById(expected.getStudentId());
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void update() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        expected.setFirstName("Lamia");
        Student actual = studentRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        studentRepository.delete(expected);
        Optional<Student> actual = studentRepository.findById(expected.getStudentId());
        assertFalse(actual.isPresent());
    }

}