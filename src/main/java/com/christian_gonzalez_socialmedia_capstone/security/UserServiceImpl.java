package com.christian_gonzalez_socialmedia_capstone.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.christian_gonzalez_socialmedia_capstone.models.Role;
import com.christian_gonzalez_socialmedia_capstone.models.User;
import com.christian_gonzalez_socialmedia_capstone.repository.UserRepository;


// implementation of UserService that also implements UserDetailsService from Spring Security
@Service
@Lazy
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   // uses repository to get username from DB
   public User findByUsername(String username){
       return userRepository.findByUsername(username);
   }

   // any registration thru the page makes the role as "ROLE_USER"
   public User save(UserRegistrationDto registration){
       User user = new User();
       user.setUsername(registration.getUsername());
       user.setPassword(passwordEncoder.encode(registration.getPassword()));
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
   }

   // check the login information
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);
       if (user == null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getUsername(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
   }

   
   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
   }
}
