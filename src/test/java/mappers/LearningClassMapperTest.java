package mappers;

import entities.LearningClass;
import entities.LearningClassDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
class LearningClassMapperTest {

    @Autowired
    private LearningClassMapper learningClassMapper;

    @Test
    void learningClassToLearningClassDTO() {
        LearningClass expected = new LearningClass();
        expected.setTitle("Test");
        expected.setDescription("Description");

        LearningClassDTO actual = learningClassMapper.learningClassToLearningClassDTO(expected);
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Test
    void learningClassDTOToLearningClass() {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setTitle("Test");
        expected.setDescription("Description");

        LearningClass actual = learningClassMapper.learningClassDTOToLearningClass(expected);
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
    }
}