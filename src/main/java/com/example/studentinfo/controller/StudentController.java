package com.example.studentinfo.controller;

import com.example.studentinfo.entity.Student;
import com.example.studentinfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student saved = studentRepository.save(student);
        return ResponseEntity.ok(saved);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student details) {
        return studentRepository.findById(id).map(student -> {
            student.setIndexNo(details.getIndexNo());
            student.setName(details.getName());
            student.setDob(details.getDob());
            student.setGpa(details.getGpa());
            Student updated = studentRepository.save(student);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchStudent(@PathVariable int id, @RequestBody Student partial) {
        return studentRepository.findById(id).map(student -> {
            if (partial.getIndexNo() != null) {
                student.setIndexNo(partial.getIndexNo());
            }
            if (partial.getName() != null) {
                student.setName(partial.getName());
            }
            if (partial.getDob() != null) {
                student.setDob(partial.getDob());
            }
            // For double, be mindful if partial.gpa is zero or a default
            student.setGpa(partial.getGpa());
            Student updated = studentRepository.save(student);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
