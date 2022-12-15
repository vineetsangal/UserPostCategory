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

import com.example.demo.Dto.PostDto;
import com.example.demo.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	@PostMapping("/user{userId}/category{categoryId}/post")
	public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto ,@PathVariable Integer userId , @PathVariable Integer categoryId){
		PostDto createpost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createpost,HttpStatus.CREATED);
	}
	@GetMapping("/user{userId}/post")
	public ResponseEntity<List<PostDto>>getPostByUser(@RequestBody PostDto postDto , @PathVariable Integer userId){
	List<PostDto>list = 	this.postService.getPostByuserId(userId);
	return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/postId")
	public ResponseEntity<?>deletePost(@PathVariable Integer postId){
		 this.postService.deletePost(postId); 
		return ResponseEntity.ok(null);
	
	}
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>>getAllPost(){
		List<PostDto>list = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
	@GetMapping("/post{postId}")
	public ResponseEntity<PostDto>getPostById(@RequestBody PostDto postDto , @PathVariable Integer postId){
	PostDto post = 	this.postService.getPostByID(postId);
	return new ResponseEntity<PostDto>(post , HttpStatus.OK);
		
	}
	@PutMapping("/post{postId}")
	public ResponseEntity<PostDto>updatepost(@RequestBody PostDto postDto , @PathVariable Integer postId){
	PostDto post = 	this.postService.UpdatePost(postDto, postId);
	return new ResponseEntity<PostDto>(post , HttpStatus.OK);
	}
}
