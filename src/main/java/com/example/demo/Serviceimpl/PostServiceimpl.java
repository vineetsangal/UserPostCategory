package com.example.demo.Serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.Dto.PostDto;

import com.example.demo.Repository.CategoryRepo;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.PostService;
import com.example.demo.entites.Category;
import com.example.demo.entites.Post;
import com.example.demo.entites.User;
@Service
public class PostServiceimpl implements PostService{
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
    private PostRepository postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
	User user = 	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId", "Userid" , "UserId"));
		Category Cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryId", "Categoryid" , "CategoryId"));
		 Post post =   this.modelMapper.map(postDto, Post.class);
			 post.setAddedDate(new Date());
		 post.setCategory(Cat);
		 post.setUser(user);
	Post newpost = this.postRepo.save(post);
		return this.modelMapper.map(newpost, PostDto.class);
		 
		 }
	

	@Override
	public PostDto UpdatePost(PostDto postDto, Integer postId) {
	Post post =	this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post id" , "PostId"));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto getPostByID(Integer postId) {
	Post post =	this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post id" , "PostId"));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public void deletePost(Integer PostId) {
	Post post = 	this.postRepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post", "Post id" , "PostId"));
		this.postRepo.deleteById(PostId);
	}

	@Override
	public List<PostDto> getAllPost() {
	List<Post>post = 	this.postRepo.findAll();
	return post.stream().map(posts->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		
		
	}

	@Override
	public List<PostDto> getPostBycategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryId", "Categoryid" , "CategoryId"));
	List<Post>list = 	 this.postRepo.getByCategory(cat);
		return list.stream().map(lists->this.modelMapper.map(list, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByuserId(Integer userId) {
	User user = 	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId", "Userid" , "UserId"));
	List<Post>list = 	this.postRepo.getByUser(user);
		return list.stream().map(lists->this.modelMapper.map(list, PostDto.class)).collect(Collectors.toList());
	
	}

}
