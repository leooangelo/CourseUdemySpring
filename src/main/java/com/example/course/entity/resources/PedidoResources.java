package com.example.course.entity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Pedido;
import com.example.course.service.PedidoService;

@RestController
@RequestMapping(value="/users")
public class PedidoResources {
	
	@Autowired
	private PedidoService userService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido>list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	
		}
	}
