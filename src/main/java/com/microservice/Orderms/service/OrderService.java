package com.microservice.Orderms.service;

import java.util.List;
import java.util.Optional;

import com.microservice.Orderms.model.Order;

public interface OrderService {
	void addNew(Order order);
	void delete(Order order);
	List<Order> getOrders();
	void update(Order order);
	Optional<Order> get(long order_id);
}
