package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.Pedido;


public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

}
