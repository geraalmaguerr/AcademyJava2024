package com.project.school.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private int age;
    private String nameStudent;
    private String email;
    private String phone;

    // Constructor (optional)
    public StudentDTO(int age, String nameStudent, String email, String phone) {
        this.age = age;
        this.nameStudent = nameStudent;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getAge() {
        return age;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
