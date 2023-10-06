package org.springRetry.mappers;

import org.springRetry.entities.LearningClass;
import org.springRetry.entities.LearningClassDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearningClassMapperTest {

    private LearningClassMapper learningClassMapper = LearningClassMapper.INSTANCE;

    @Test
    void learningClassToLearningClassDTO() {
        LearningClass expected = new LearningClass();
        expected.setDescription("Test");
        expected.setTitle("Title");
        LearningClassDTO actual = learningClassMapper.learningClassToLearningClassDTO(expected);
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Test
    void learningClassDTOToLearningClass() {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setDescription("Test");
        expected.setTitle("Title");
        LearningClass actual = learningClassMapper.learningClassDTOToLearningClass(expected);
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDescription(), actual.getDescription());
    }
}