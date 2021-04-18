package com.sivtcev.exchange.repository;

import com.sivtcev.exchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
