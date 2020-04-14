package com.microservice.Orderms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.Orderms.model.Order;
import com.microservice.Orderms.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public void addNew(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public void delete(Order order) {
		orderRepository.delete(order);
	}
	
	@Override
	public Optional<Order> get(long order_id) {
		return orderRepository.findById(order_id);
	}
	
	@Override
	public void update(Order o) {
		orderRepository.deleteById(o.getOrderId());
		orderRepository.save(o);
	}

	@Override
	public List<Order> getOrders() {
		List<Order> oList = orderRepository.findAll();
		return oList;
	}

}
