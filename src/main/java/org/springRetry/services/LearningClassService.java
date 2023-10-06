package org.springRetry.services;

import org.springRetry.entities.LearningClass;
import org.springRetry.entities.LearningClassDTO;
import org.springRetry.mappers.LearningClassMapper;
import org.springframework.stereotype.Service;
import org.springRetry.repositories.LearningClassRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LearningClassService {
    private LearningClassRepository learningClassRepository;

    private LearningClassMapper learningClassMapper;

    public LearningClassService(LearningClassRepository learningClassRepository, LearningClassMapper learningClassMapper) {
        this.learningClassRepository = learningClassRepository;
        this.learningClassMapper = learningClassMapper;
    }

    public LearningClassDTO create(LearningClassDTO learningClassDTO) {
        LearningClass learningClass = learningClassMapper.learningClassDTOToLearningClass(learningClassDTO);
        return learningClassMapper.learningClassToLearningClassDTO(learningClassRepository.save(learningClass));
    }

    public LearningClassDTO read(UUID uuid) {
        Optional<LearningClass> learningClass = learningClassRepository.findById(uuid);
        return learningClass.map(aClass -> learningClassMapper.learningClassToLearningClassDTO(aClass)).orElse(null);
    }

    public LearningClassDTO update(LearningClassDTO learningClassDTO) {
        LearningClass learningClass = learningClassMapper.learningClassDTOToLearningClass(learningClassDTO);
        return learningClassMapper.learningClassToLearningClassDTO(learningClassRepository.save(learningClass));
    }

    public void delete(LearningClassDTO learningClass) {
        LearningClass toDelete = learningClassMapper.learningClassDTOToLearningClass(learningClass);
        this.learningClassRepository.delete(toDelete);
    }

}
