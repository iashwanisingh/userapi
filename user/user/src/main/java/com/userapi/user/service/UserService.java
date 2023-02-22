package com.userapi.user.service;

import com.userapi.user.entity.User;

import java.util.List;

public interface UserService {

  public List<User> getUser();
  public User getUserById(int userId);
  public User addUser(User user);
  public User updateUser(User user);

  public void deleteUser(int userId);


}
