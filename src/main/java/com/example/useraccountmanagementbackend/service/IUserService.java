package com.example.useraccountmanagementbackend.service;

import com.example.useraccountmanagementbackend.domain.User;

import java.util.List;

/**
 * @author blaise
 */
public interface IUserService {
    /**
     * signup
     * @param user
     * @return
     */
    User signup(User user);

    /**
     * update
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * find users
     * @return
     */
    List<User> findUsers();

    /**
     * fetch user
     * @return
     */
    User fetchUser(User user);

    /**
     * change status
     * @param user
     * @return
     */
    User changeStatus(User user);

    User fetchUser(String username);
}
