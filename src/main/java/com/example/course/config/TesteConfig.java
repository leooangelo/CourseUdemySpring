package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entity.Categoria;
import com.example.course.entity.Pedido;
import com.example.course.entity.PedidoItem;
import com.example.course.entity.Produto;
import com.example.course.entity.User;
import com.example.course.entity.enums.PedidoStatus;
import com.example.course.repository.CategoriaRepository;
import com.example.course.repository.PedidoItemRepository;
import com.example.course.repository.PedidoRepository;
import com.example.course.repository.ProdutoRepository;
import com.example.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.WAITING_PAYMENT, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.CANCELED, u1); 
		
		PedidoItem oi1 = new PedidoItem(o1, p1, 2, p1.getPrice());
		PedidoItem oi2 = new PedidoItem(o1, p3, 1, p3.getPrice());
		PedidoItem oi3 = new PedidoItem(o2, p3, 2, p3.getPrice());
		PedidoItem oi4 = new PedidoItem(o3, p5, 2, p5.getPrice()); 

		
		userRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		pedidoItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
	}
	
	
	
}
