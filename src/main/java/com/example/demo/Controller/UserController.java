package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Userdto;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity <Userdto> createUser(@RequestBody Userdto userDto){
	Userdto Dto= 	this.userService.createUser(userDto);
	return new ResponseEntity<>(Dto,HttpStatus.CREATED);
	}
	@PutMapping("/{UserId}")
	public ResponseEntity<Userdto>UpdateUser(@RequestBody Userdto userDto ,@PathVariable Integer UserId){
		Userdto updateduser = this.userService.UpdateUser(userDto, UserId);
		return ResponseEntity.ok(updateduser);
	}
	@GetMapping("/")
	public ResponseEntity<List<Userdto>>getAllUsers(){
		List<Userdto>list = this.userService.getAllUsers();
		return ResponseEntity.ok(list);
		
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity <?>deleteUser(@PathVariable Integer userId){
		this.userService.DeleteUser(userId);
		return ResponseEntity.ok(null);
	}
	
	

}
