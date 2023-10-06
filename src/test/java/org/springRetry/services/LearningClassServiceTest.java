package org.springRetry.services;

import org.springRetry.entities.LearningClass;
import org.springRetry.entities.LearningClassDTO;
import org.springRetry.mappers.LearningClassMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springRetry.repositories.LearningClassRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LearningClassServiceTest {

    private LearningClassService learningClassService;

    private LearningClassRepository learningClassRepository;

    private final LearningClassMapper learningClassMapper = LearningClassMapper.INSTANCE;

    @BeforeEach
    void setUp() {
        learningClassRepository = mock(LearningClassRepository.class);
        learningClassService = new LearningClassService(learningClassRepository, learningClassMapper);
    }


    @Test
    void create() {
        LearningClass expectedToCreate = new LearningClass();
        expectedToCreate.setDescription("Test");
        expectedToCreate.setTitle("Leisure");
        LearningClassDTO expectedDTO = learningClassMapper.learningClassToLearningClassDTO(expectedToCreate);

        when(learningClassRepository.save(any(LearningClass.class))).thenReturn(expectedToCreate);

        LearningClassDTO actual = learningClassService.create(expectedDTO);
        assertEquals(expectedDTO, actual);
    }

    @Test
    void read() {
        LearningClass expectedToFind = new LearningClass();
        expectedToFind.setTitle("Test");
        expectedToFind.setDescription("Desc");
        LearningClassDTO expected = learningClassMapper.learningClassToLearningClassDTO(expectedToFind);
        when(learningClassRepository.findById(expectedToFind.getLearningClassId())).thenReturn(Optional.of(expectedToFind));
        LearningClassDTO actual = learningClassService.read(expectedToFind.getLearningClassId());
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        LearningClass expectedToUpdate = new LearningClass();
        expectedToUpdate.setDescription("Test");
        expectedToUpdate.setTitle("Leisure");
        LearningClassDTO expectedDTO = learningClassMapper.learningClassToLearningClassDTO(expectedToUpdate);

        when(learningClassRepository.save(expectedToUpdate)).thenReturn(expectedToUpdate);

        LearningClassDTO actual = learningClassService.create(expectedDTO);
        assertEquals(expectedDTO, actual);
    }

    @Test
    void delete() {
        LearningClass expectedToDelete = new LearningClass();
        expectedToDelete.setDescription("Test");
        expectedToDelete.setTitle("Leisure");
        LearningClassDTO expected = learningClassMapper.learningClassToLearningClassDTO(expectedToDelete);

        learningClassService.delete(expected);
        verify(learningClassRepository, atLeastOnce()).delete(expectedToDelete);
    }
}