package com.project.Christian_Gonzalez_SocialMedia_Capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Christian_Gonzalez_SocialMedia_Capstone.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
