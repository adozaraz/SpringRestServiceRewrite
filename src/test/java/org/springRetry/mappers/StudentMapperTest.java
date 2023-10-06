package org.springRetry.mappers;

import org.springRetry.entities.Student;
import org.springRetry.entities.StudentDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Test
    void studentToStudentDTO() {
        Student expected = new Student();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        StudentDTO actual = studentMapper.studentToStudentDTO(expected);
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getFirstName(), actual.getFirstName());
    }

    @Test
    void studentDTOToStudent() {
        StudentDTO expected = new StudentDTO();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");
        Student actual = studentMapper.studentDTOToStudent(expected);
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getFirstName(), actual.getFirstName());
    }
}