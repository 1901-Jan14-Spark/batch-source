package com.revature.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spark.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
