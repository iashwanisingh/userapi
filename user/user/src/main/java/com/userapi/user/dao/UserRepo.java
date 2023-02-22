package com.userapi.user.dao;

import com.userapi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
  public User findById(int userId);
}
