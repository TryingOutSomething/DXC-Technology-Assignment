package com.tryingoutsomething.loginapp.repositories;

import com.tryingoutsomething.loginapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User searchUserByUserName(String username);
}
