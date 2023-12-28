package com.example.useraccountmanagementbackend.service;

import com.example.useraccountmanagementbackend.dao.IUserDao;
import com.example.useraccountmanagementbackend.domain.User;
import com.example.useraccountmanagementbackend.enumerator.EStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author blaise
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * signup
     * @param user
     * @return
     */
    @Override
    public User signup(User user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setStatus(EStatus.UNVERIFIED);
            return userDao.save(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * update user
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        try {
            return userDao.save(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findUsers() {
        try{
            return userDao.findAll();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User fetchUser(User user) {
        try{
            return userDao.findById(user.getId()).orElseThrow();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User changeStatus(User user) {
        try{
            User userr = userDao.save(user);
            return userr;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User fetchUser(String username) {
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

}
