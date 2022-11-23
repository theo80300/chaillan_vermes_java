package com.rioc.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rioc.ws.models.dao.Account;

import java.util.List;
@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{
	List<Account> findByFirstNameAndLastName (@Param(value = "firstName") String firstName,@Param(value="LastName") String lastName);
}
