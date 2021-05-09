package com.powell.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powell.app.entity.Account;
import com.powell.app.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	//Read all accounts
	@GetMapping
	public List<Account> readAll(){
		List<Account> users = StreamSupport
				.stream(accountService.findAll().spliterator() ,false)
				.collect(Collectors.toList());
		return users;
	}
	
	
	// Read an account
		@GetMapping("/{id}")
		public ResponseEntity<?> read (@PathVariable (value = "id") Long accountId ){
			Optional<Account> oAccount = accountService.findById(accountId);
			
			if(!oAccount.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(oAccount);
		}
		
		
	//  Create a new account
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Account account){
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));
	}
	
	
	// Update an account
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Account accountDetails, @PathVariable(value="id")Long accountId){
		Optional<Account> account = accountService.findById(accountId);
		
		if(!account.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		account.get().setName(accountDetails.getName());
		account.get().setBalance(accountDetails.getBalance());
		account.get().setStatus(accountDetails.getStatus());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account.get()));
	}
	
	
	// Delete(disable) an account 
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id") Long userId) {
		Optional<Account> user = accountService.findById(userId);
		if (!accountService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		
		user.get().setStatus(false);

		
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(user.get()));

	}
	

	
	
}
