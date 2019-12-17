package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.PedidoItem;


public interface PedidoItemRepository  extends JpaRepository<PedidoItem, Long>{

}
