package com.WebSocket.service;

import com.WebSocket.model.User;
import com.WebSocket.model.documentElastic.LoginTrace;
import com.WebSocket.model.documentElastic.UserElastic;
import com.WebSocket.repository.ElasticsearchLoginRepository;
import com.WebSocket.repository.ElasticsearchUserRepository;
import com.WebSocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class UserService {


    private  UserRepository userRepository;


    private  ElasticsearchUserRepository elasticsearchUserRepository;

    private ElasticsearchLoginRepository elasticsearchLoginRepository;


    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        UserElastic userElastic = new UserElastic(savedUser);
        elasticsearchUserRepository.save(userElastic);
        return savedUser;
    }
    public User loginUser(String email, String password) {
        User existUser = userRepository.findByEmailAndPassword(email,password);
        if(existUser != null) {
            LoginTrace newLoginTrace = new LoginTrace();
            newLoginTrace.setUserId(existUser.getId());
            newLoginTrace.setLoginTime(new Date());
            elasticsearchLoginRepository.save(newLoginTrace);
        }
        // excepcion null
        return existUser;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByNumberPhone(String numberPhone) {
        return userRepository.findByPhoneNumber(numberPhone);
    }

    public boolean userExists(User user) {
        return userRepository.existsByEmail(user.getEmail()) || userRepository.existsByPhoneNumber(user.getPhoneNumber());
    }
}