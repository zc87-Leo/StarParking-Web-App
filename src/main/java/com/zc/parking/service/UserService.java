package com.zc.parking.service;

import com.zc.parking.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
