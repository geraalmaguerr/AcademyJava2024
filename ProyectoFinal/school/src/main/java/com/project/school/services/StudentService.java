package com.project.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.dto.StudentDTO;
import com.project.school.entity.Students;
import com.project.school.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Students> consultStudents(){
        return (List<Students>) studentRepository.findAll();
    }

    /**
     * @param student
     * @return
     */
    @SuppressWarnings("null")
    public Students registStudents(Students student){
        return studentRepository.save(student);
    }

    // Update student by ID
    public Students updateStudent(Long id, StudentDTO studentJson) {
        return studentRepository.findById(id).map(student -> {
            student.setNameStudent(studentJson.getNameStudent());
            student.setEmail(studentJson.getEmail());
            student.setAge(studentJson.getAge());
            student.setPhone(studentJson.getPhone());
            return studentRepository.save(student);
        }).orElse(null);  // Return null if the student is not found
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;  // Student not found
        }
    }
}
