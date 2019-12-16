package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.Produto;


public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
