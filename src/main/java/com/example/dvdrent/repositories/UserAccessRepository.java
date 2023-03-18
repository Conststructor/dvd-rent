package com.example.dvdrent.repositories;

import com.example.dvdrent.entities.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    List<UserAccess> findByUserLogin(String login);
}
