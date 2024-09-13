package com.project.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.dto.StudentDTO;
import com.project.school.entity.Students;
import com.project.school.services.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin("http://127.0.0.1:3002")
    @GetMapping("/listStudents")
    public List<Students> consultStudents(){
        return studentService.consultStudents();
    }

    @CrossOrigin("http://127.0.0.1:3002")
    @PostMapping("/registStudents")
    public Students registStudents(@RequestBody StudentDTO studentJson){

        Students student = new Students();

        student.setNameStudent(studentJson.getNameStudent());
        student.setEmail(studentJson.getEmail());
        student.setAge(studentJson.getAge());
        student.setPhone(studentJson.getPhone());
        

        return studentService.registStudents(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentJson) {
        Students updatedStudent = studentService.updateStudent(id, studentJson);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://127.0.0.1:3002")
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
