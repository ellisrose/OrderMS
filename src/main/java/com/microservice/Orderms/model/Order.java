package com.microservice.Orderms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_data")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "order_name")
	private String orderName;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "user_id")
	private Long userId;
	
	@JoinColumn(name = "products")
	private List<Product> products;
	
	@JoinColumn(name = "ship_id")
	private long ship_id;
	
	@JoinColumn(name = "pay_id")
	private long pay_id;
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getShip_id() {
		return ship_id;
	}

	public void setShip_id(long ship_id) {
		this.ship_id = ship_id;
	}

	public long getPay_id() {
		return pay_id;
	}

	public void setPay_id(long pay_id) {
		this.pay_id = pay_id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
