package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Category;

public interface CategoryRepo extends JpaRepository <Category,Integer>{

}
