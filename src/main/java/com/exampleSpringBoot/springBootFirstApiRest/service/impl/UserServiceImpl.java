package com.exampleSpringBoot.springBootFirstApiRest.service.impl;

import com.exampleSpringBoot.springBootFirstApiRest.exception.ResourceNotFoundException;
import com.exampleSpringBoot.springBootFirstApiRest.model.User;
import com.exampleSpringBoot.springBootFirstApiRest.repository.UserRepository;
import com.exampleSpringBoot.springBootFirstApiRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

	@Override
	public User updateUser(User user, long id) {
		
		User userExisting = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userExisting.setFirstName(user.getFirstName());
		userExisting.setLastName(user.getLastName());
		userExisting.setEmail(user.getEmail());
		userRepository.save(userExisting);
		
		return userExisting;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
		
	}
}
