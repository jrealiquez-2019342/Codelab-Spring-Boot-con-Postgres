package com.realiquez.postgres.data.respository;

import com.realiquez.postgres.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
