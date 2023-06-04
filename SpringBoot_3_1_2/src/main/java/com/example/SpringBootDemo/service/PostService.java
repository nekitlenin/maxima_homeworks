package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Project: SpringBoot_3_1_2
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 03.06.2023 17:59 |
 * Created with IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getUserPosts(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    public Post get(Long id) {
        return postRepository.findById(id).get();
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
