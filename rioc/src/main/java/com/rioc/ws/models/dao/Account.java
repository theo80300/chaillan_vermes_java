package com.rioc.ws.models.dao;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACCOUNT")
@JsonIgnoreProperties({"hibernateLazyInitialize","handler"})
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID",unique = true, nullable = false)
	private int accountId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	private Address  address;

	@OneToMany(mappedBy="account_id",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Bankdetail> bankdetail;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	public Account() {
		// TODO Auto-Generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	
}
