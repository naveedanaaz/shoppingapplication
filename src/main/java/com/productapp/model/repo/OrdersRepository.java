package com.productapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{

	
}
