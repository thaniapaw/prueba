package com.powell.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.powell.app.entity.Account;
import com.powell.app.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService{

	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Account> finAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Account> findById(Long id) {
	
		return accountRepository.findById(id);
	}

	@Override
	@Transactional
	public Account save(Account account) {
	
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
		
	}

}
