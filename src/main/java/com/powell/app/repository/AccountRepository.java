package com.powell.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powell.app.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
