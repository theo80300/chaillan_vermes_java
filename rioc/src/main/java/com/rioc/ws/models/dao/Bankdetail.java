package com.rioc.ws.models.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Bankdetail")
@JsonIgnoreProperties({"hibernateLazyInitialize","handler"})
public class Bankdetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_ID",unique = true, nullable = false)
	private int bankId;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account_id;
	@Column(name = "IBAN")
	private String iban;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public Account getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	

}
