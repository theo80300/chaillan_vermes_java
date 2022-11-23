package com.rioc.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.rioc.ws.models.dao.Bankdetail;

public interface IBankdetailRepository extends JpaRepository<Bankdetail, Integer>{
	//List<Bankdetail> findByBankIdAndAccount_AccountId(@Param(value = "bankId") int bankId,@Param(value="accountId") int accountId);
}
