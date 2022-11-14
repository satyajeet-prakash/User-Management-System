package org.personal.project.usermanagementsystem.repository;

import org.personal.project.usermanagementsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
