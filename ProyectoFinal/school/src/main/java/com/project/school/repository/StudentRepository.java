package com.project.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.school.entity.Students;;

public interface StudentRepository extends CrudRepository<Students, Long>{

    
}
