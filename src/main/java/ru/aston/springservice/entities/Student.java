package ru.aston.springservice.entities;

import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "student"),
            inverseJoinColumns = @JoinColumn(name = "learningClass")
    )
    private Set<LearningClass> learningClasses = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = id;
    }

    public void setStudentId(String id) {
        this.studentId = Long.parseLong(id);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<LearningClass> getLearningClasses() {
        return learningClasses;
    }

    public void setLearningClasses(Set<LearningClass> learningClasses) {
        this.learningClasses = learningClasses;
    }

    public void addLearningClass(LearningClass learningClass) {
        this.learningClasses.add(learningClass);
        learningClass.getAttendingStudents().add(this);
    }

    public void removeLearningClass(String learningClassId) {
        LearningClass learningClass = this.learningClasses.stream().filter(t -> Objects.equals(t.getLearningClassId(), learningClassId)).findFirst().orElse(null);
        if (learningClass != null) {
            this.learningClasses.remove(learningClass);
            learningClass.getAttendingStudents().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(learningClasses, student.learningClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, learningClasses);
    }
}
