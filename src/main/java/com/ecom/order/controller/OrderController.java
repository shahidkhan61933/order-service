package com.ecom.order.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.entity.OrderEntity;
import com.ecom.order.exception.OrderListIsEmptyException;
import com.ecom.order.exception.OrderNotFoundException;
import com.ecom.order.exception.OrderUpdateIsFailed;
import com.ecom.order.exception.OrderUploadFailedException;
import com.ecom.order.repository.OrderRepository;


@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/orders/{id}")
	public Optional<OrderEntity> getOrderById(@PathVariable("id") long id) {
		Optional<OrderEntity> order = orderRepo.findById(id);
		if (order != null) {
			return order;

		}
		throw new OrderNotFoundException("Order Not Found With Geiven Id" + id);
	}

	@GetMapping("/orders")
	public List<OrderEntity> getOrders() {
		List<OrderEntity> list = orderRepo.findAll();
		if (list.isEmpty()) {
			throw new OrderListIsEmptyException("Order list is empty ");
		}
		return list;
	}

	@PostMapping("/orders")
	public OrderEntity addorder(@RequestBody OrderEntity order) {
		OrderEntity orders = orderRepo.save(order);
		if (order != null) {
			return orders;
		}
		throw new OrderUploadFailedException("Order Update Failed du to invalid Field !");
	}

	@PutMapping("/orders")
	public String updateOrders(@RequestBody OrderEntity order) {
		OrderEntity orders = orderRepo.save(order);
		if (orders != null) {
			return "Orders  status has been updated successfully!";
		}
		throw new OrderUpdateIsFailed("Order Update Failed du to invalid Field !");
	}

	@DeleteMapping("/order/{id}")
	public String deleteOrderById(@PathVariable("id") long id) {
		orderRepo.deleteById(id);

		return "Order Delete Succesfully ";

	}
}
