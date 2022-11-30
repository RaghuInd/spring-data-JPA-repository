package com.employee.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.app.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
