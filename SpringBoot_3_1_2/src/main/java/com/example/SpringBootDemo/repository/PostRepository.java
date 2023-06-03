package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
