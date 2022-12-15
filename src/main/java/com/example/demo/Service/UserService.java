package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.Userdto;

public interface UserService {
	public Userdto createUser(Userdto userdto);
	public Userdto UpdateUser(Userdto userdto , Integer userId);
	public Userdto getUserById(Integer userId);
	public List<Userdto>getAllUsers();
	public void DeleteUser(Integer userId);
	

}
