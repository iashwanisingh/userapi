package com.userapi.user.service;

import com.userapi.user.dao.UserRepo;
import com.userapi.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

  @Autowired
  private UserRepo userRepo;

  @Override
  public List<User> getUser() {
    return userRepo.findAll();
  }

  @Override
  public User getUserById(int userId) {
    return userRepo.findById(userId);
  }

  @Override
  public User addUser(User user) {
    return userRepo.save(user);
  }

  @Override
  public User updateUser(User user) {
    return userRepo.save(user);
  }

  @Override
  public void deleteUser(int userId) {
    User user = userRepo.findById(userId);
    userRepo.delete(user);
  }
}
