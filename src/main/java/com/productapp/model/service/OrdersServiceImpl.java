package com.productapp.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.AppUser;
import com.productapp.model.entities.Orders;
import com.productapp.model.entities.Product;
import com.productapp.model.repo.AppUserRepository;
import com.productapp.model.repo.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
public OrdersRepository myOrdersRepository;
	@Autowired
	private AppUserRepository appUserRepository ;
	@Override
	public List<Orders> saveOrder(Product product,User user,Long storeId) {
		Orders orders=new Orders(product.getName(), product.getPrice(),LocalDateTime.now(),storeId);
		AppUser appUser=appUserRepository.findByuserEmail(user.getUsername());
		appUser.addMyOrders(orders);
		appUserRepository.save(appUser);
		List<Orders> myOrders=myOrdersRepository.findAll();
			return myOrders;
	}
	

}
