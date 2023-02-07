package com.qnfzksla.qnfzkslaprojectboard.repository;

import com.qnfzksla.qnfzkslaprojectboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,String> {

}
