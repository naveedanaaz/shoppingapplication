package com.productapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}
