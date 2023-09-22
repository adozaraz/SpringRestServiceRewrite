package mappers;

import entities.Student;
import entities.StudentDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void studentToStudentDTO() {
        Student expected = new Student();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");

        StudentDTO actual = studentMapper.studentToStudentDTO(expected);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
    }

    @Test
    void studentDTOToStudent() {
        StudentDTO expected = new StudentDTO();
        expected.setFirstName("Nikita");
        expected.setLastName("Boradulin");

        Student actual = studentMapper.studentDTOToStudent(expected);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
    }
}