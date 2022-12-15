package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);
	PostDto UpdatePost(PostDto postDto , Integer postId);
	PostDto getPostByID(Integer postId);
	void deletePost(Integer PostId);
	List<PostDto>getAllPost();
	List<PostDto>getPostBycategory(Integer categoryId);
	List<PostDto>getPostByuserId(Integer userId);

}
