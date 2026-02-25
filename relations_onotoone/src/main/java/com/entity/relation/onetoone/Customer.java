package com.entity.relation.onetoone;

import jakarta.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer( String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
}
