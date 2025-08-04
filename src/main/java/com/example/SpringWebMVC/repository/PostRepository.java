package com.example.SpringWebMVC.repository;



import com.example.SpringWebMVC.exception.NotFoundException;
import com.example.SpringWebMVC.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

// Stub
@Repository
public class PostRepository {
    private static List<Post> list = new CopyOnWriteArrayList<>();
    private static long sequence = 0;

    public List<Post> all() {
        return list;
    }

    public Optional<Post> getById(long id) {
        Optional<Post> item = list.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
        return item;
    }

    public Post save(Post post) throws NotFoundException {
        if (post.getId() != 0) {
            Optional<Post> item = getById(post.getId());
            if (item.isEmpty()) {
                throw new NotFoundException();
            }
            Post updatePost = item.get();
            updatePost.setContent(post.getContent());
        }
        sequence = sequence + 1;
        post.setId(sequence);
        list.add(post);
        return post;
    }

    public void removeById(long id) {
        list.remove(id);
    }


}
