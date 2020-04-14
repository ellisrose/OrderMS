package com.microservice.Orderms.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="payment-service")
@RibbonClient("payment-service")
public interface OrderPayService {
	@GetMapping("/getPayment")
	public long newPayment();
}