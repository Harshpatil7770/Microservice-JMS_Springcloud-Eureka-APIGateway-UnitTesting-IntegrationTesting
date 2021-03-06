package com.xoriant.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.delivery.model.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {

}
