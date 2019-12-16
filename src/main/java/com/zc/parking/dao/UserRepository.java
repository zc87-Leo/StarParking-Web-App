package com.zc.parking.dao;

import com.zc.parking.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
 User findByUsernameAndPassword(String username,String password);

}
