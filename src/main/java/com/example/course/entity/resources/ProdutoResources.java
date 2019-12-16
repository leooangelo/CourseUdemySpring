package com.example.course.entity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Produto;
import com.example.course.service.ProdutoService;

@RestController
@RequestMapping(value="/product")
public class ProdutoResources {
	
	@Autowired
	private ProdutoService userService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto>list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	
		}
	}
