package com.microservice.Orderms.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Orderms.model.Order;
import com.microservice.Orderms.model.Product;
import com.microservice.Orderms.repository.OrderRepository;
import com.microservice.Orderms.service.OrderService;

@RestController
public class OrderController {
	OrderService orderService;
	CartServiceProxy cartServiceProxy;
	OrderPayService orderPayService;
	OrderShipProxy orderShipProxy;
	OrderRepository orderRepository;
	long currOrder=0; 
	
	@GetMapping(value="/add")
	public void addOrder(Order order) {
		orderService.addNew(order);
	}
	
	@GetMapping(value="/delete")
	public void clear(Order order) {
		orderService.delete(order);
	}

	@GetMapping(path="/sendCart/{cartid}")
	public void getSearchResults(@PathParam(value = "cartid") long cartid) {
		List<Product> oList = null;
		try {
			oList =cartServiceProxy.sendCart(cartid);
        }catch(Exception ex){ex.printStackTrace();}
		Order o = new Order();
		o.setProducts(oList);
		orderService.addNew(o);
		currOrder=o.getOrderId();
	}
	
	@GetMapping(path="/getPayment")
	public void newPayment(){
		long payment=0;
		try {
			payment =orderPayService.newPayment();
        }catch(Exception ex){ex.printStackTrace();}
		Optional<Order> o = orderService.get(currOrder);
		o.get().setPay_id(payment);
		orderService.update(o.get());
	}
	
	@GetMapping(path="/getShipping")
	public void newShipment() {
		long oList;
		try {
			oList =orderShipProxy.newShipment();
        }catch(Exception ex){ex.printStackTrace();}
		long payment =orderPayService.newPayment();
		Optional<Order> o = orderService.get(currOrder);
		o.get().setPay_id(payment);
		orderService.update(o.get());
	}
}
