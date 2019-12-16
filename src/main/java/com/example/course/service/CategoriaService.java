package com.example.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entity.Categoria;
import com.example.course.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository CategoriaRepository;
		
	public List<Categoria> findAll(){
		return CategoriaRepository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = CategoriaRepository.findById(id);
		return obj.get();
	}
}
