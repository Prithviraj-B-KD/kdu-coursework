package com.example.assesment2.dao;

import com.example.assesment2.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Modifying
    @Transactional
    @Query("update User u set u.fullName = ?1, u.email = ?2 ,u.password = ?3 where u.id = ?4")
    void setUserInfoById(String fullName, String email,String password, UUID userId);
}
