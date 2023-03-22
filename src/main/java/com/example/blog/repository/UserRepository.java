package com.example.blog.repository;

import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO 와 같은 역할
// @자동으로 빈 등록이 됨(@Repository 생략 가능)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
