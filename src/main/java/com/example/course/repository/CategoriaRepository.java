package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.Categoria;


public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
