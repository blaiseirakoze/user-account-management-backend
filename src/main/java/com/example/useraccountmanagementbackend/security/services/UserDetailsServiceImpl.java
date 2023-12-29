package com.example.useraccountmanagementbackend.security.services;

import com.example.useraccountmanagementbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.useraccountmanagementbackend.dao.IUserDao;
/**
 * @author blaise
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  IUserDao userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    return UserDetailsImpl.build(user);
  }

}
