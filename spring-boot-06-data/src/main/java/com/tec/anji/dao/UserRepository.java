package com.tec.anji.dao;

import com.tec.anji.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
