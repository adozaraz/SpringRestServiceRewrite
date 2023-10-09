package ru.aston.springservice.controllers;

import ru.aston.springservice.entities.LearningClassDTO;
import org.springframework.web.bind.annotation.*;
import ru.aston.springservice.services.LearningClassService;

import java.util.UUID;

@RestController
@RequestMapping("/learningClass")
public class LearningClassController {

    private LearningClassService learningClassService;

    public LearningClassController(LearningClassService learningClassService) {
        this.learningClassService = learningClassService;
    }

    @PostMapping("/create")
    public LearningClassDTO createLearningClass(@RequestBody LearningClassDTO learningClassDTO) {
        return this.learningClassService.create(learningClassDTO);
    }

    @GetMapping("/get/{uuid}")
    public LearningClassDTO readLearningClass(@PathVariable Long uuid) {
        return this.learningClassService.read(uuid);
    }

    @PostMapping("/update")
    public LearningClassDTO updateLearningClass(@RequestBody LearningClassDTO learningClassDTO) {
        return this.learningClassService.update(learningClassDTO);
    }

    @DeleteMapping("/delete")
    public void deleteLearningClass(@RequestBody LearningClassDTO learningClassDTO) {
        this.learningClassService.delete(learningClassDTO);
    }
}
