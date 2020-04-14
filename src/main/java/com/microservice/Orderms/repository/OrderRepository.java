package com.microservice.Orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.Orderms.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}


/*we don't need to create the Service/ resources  here because we are using
Spring Data Rest which is going scan the repository and create the resource for it.
This is the powerful feature of Spring '*/