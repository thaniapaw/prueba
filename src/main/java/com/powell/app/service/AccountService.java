package com.powell.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.powell.app.entity.Account;

public interface AccountService {

	public Iterable<Account> findAll();
	
	public Page<Account> finAll(Pageable pageable);
	
	public Optional<Account> findById(Long id);
	
	public Account save(Account account);
	
	public void deleteById(Long id);
	
}
