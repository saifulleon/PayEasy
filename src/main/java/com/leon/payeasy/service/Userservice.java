package com.leon.payeasy.service;

import com.leon.payeasy.model.User;
import com.leon.payeasy.model.UserRole;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface Userservice {
    public String acceptUser(User u);

    public String insertUser(User u);

    public String updateUser(User u);

    public String deleteUser(User u);

    public String viewUsers(User u);

    public User viewUser(String s);
}
