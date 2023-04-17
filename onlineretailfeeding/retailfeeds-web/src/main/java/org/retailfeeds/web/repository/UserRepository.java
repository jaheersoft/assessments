package org.retailfeeds.web.repository;

import java.util.Optional;

import org.retailfeeds.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
