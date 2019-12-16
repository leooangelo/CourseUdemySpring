package com.example.course.entity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Categoria;
import com.example.course.service.CategoriaService;

@RestController
@RequestMapping(value="/categories")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService userService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria>list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	
		}
	}
