package com.collectiveDunes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UsersRepository userRepository;

  public boolean registerUser(User user) {
    if (userRepository.existsByUsername(user.getUsername())) {
      return false;
    }
    userRepository.save(user);
    return true; 
  }

  public User loginUser(String username, String password) {
    User user = userRepository.findByUsername(username);
    if (user != null && user.getPassword().equals(password)) {
      return user;
    }
    return null; 
  }
}

