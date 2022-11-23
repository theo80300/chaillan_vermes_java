package com.rioc.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rioc.ws.models.dao.Address;

import java.util.List;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByCityAndCountry (@Param(value = "city") String city,@Param(value="country") String country);
}