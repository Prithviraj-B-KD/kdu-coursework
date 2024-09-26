package com.kdu.smartHome.dao;

import com.kdu.smartHome.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
   Users findUserByUsername(String username);
}
