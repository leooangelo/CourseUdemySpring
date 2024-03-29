package com.example.course.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.course.entity.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//FORMATA O JSON CONFORME A ISO8601
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone= "GMT")
	private Instant moment;
	
	private Integer pedidoStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_Id")
	private User client;
	
	@OneToMany(mappedBy =" id.order")	
	private Set<PedidoItem> items = new HashSet<>();
	
	//Pedido id =1, pagamento tem que ter o mesmo id do pedido por isso utiliza cascade;
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	
	private Payment payment;
	
	
	
		public Pedido() {
			
		}

		public Pedido(Long id, Instant moment,PedidoStatus pedidoStatus, User client) {
			super();
			this.id = id;
			this.moment = moment;
			setPedidoStatus(pedidoStatus);
			this.client = client;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Instant getMoment() {
			return moment;
		}

		public void setMoment(Instant moment) {
			this.moment = moment;
		}
		public PedidoStatus getPedidoStatus() {
			return PedidoStatus.valueOf(pedidoStatus);
		}
		
		public void setPedidoStatus(PedidoStatus pedidoStatus) {
			if(pedidoStatus != null) this.pedidoStatus = pedidoStatus.getCode();
		}

		public User getClient() {
			return client;
		}

		public void setClient(User client) {
			client = client;
		}
		
		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public Set<PedidoItem> getItems(){
			return items;
		}
		public Double getTotal() {
			double sum = 0.0;
			for(PedidoItem x : items) {
				sum += x.getSubTotal();
			}
			return  sum;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pedido other = (Pedido) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		
}
