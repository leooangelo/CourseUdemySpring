package com.example.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entity.Produto;
import com.example.course.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository userRepository;
		
	public List<Produto> findAll(){
		return userRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = userRepository.findById(id);
		return obj.get();
	}
}
