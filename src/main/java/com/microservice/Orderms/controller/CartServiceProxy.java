package com.microservice.Orderms.controller;
import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.Orderms.model.Product;

//@FeignClient(name="cart-service")
@RibbonClient("cart-service")
public interface CartServiceProxy {
	@GetMapping("/sendCart/{cartid}")
	public List<Product> sendCart(@PathVariable("cartid") long cartid);
}
