package com.example.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entity.Pedido;
import com.example.course.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository PedidoRepository;
		
	public List<Pedido> findAll(){
		return PedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = PedidoRepository.findById(id);
		return obj.get();
	}
}
