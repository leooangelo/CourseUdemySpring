package com.example.course.entity.enums;

public enum PedidoStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPERD(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for(PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) return value;
		}
		throw new IllegalArgumentException("Code invalido") ;
	}
}
