package com.example.demo.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.Userdto;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.entites.User;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public Userdto createUser(Userdto userdto) {
	
		
	User user = this .modelMapper.map(userdto, User.class);
	      User saveduser   = this.userRepo.save(user) ;  
		return this.modelMapper.map(saveduser, Userdto.class);
	}

	@Override
	public Userdto UpdateUser(Userdto userdto, Integer userId) {
	User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId","Id","userId"));
	user.setName(userdto.getName());
	user.setPassword(userdto.getPassword());
	User updateduser = this.userRepo.save(user);
		return this.modelMapper.map(updateduser, Userdto.class);
	}
	

	@Override
	public Userdto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId","Id","userId"));
		User getuser = this.userRepo.save(user);
		return this.modelMapper.map(getuser,Userdto.class);
	}

	@Override
	public List<Userdto> getAllUsers() {
	List<User>users = 	this.userRepo.findAll();
		return users.stream().map(user->this.modelMapper.map(user, Userdto.class)).collect(Collectors.toList());
	}

	@Override
	public void DeleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId","Id","userId"));
		this.userRepo.delete(user);
		
	}
}
	