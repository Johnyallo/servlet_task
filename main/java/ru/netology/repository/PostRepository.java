package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
  private final ConcurrentMap<Long, Post> allPosts;
  private final AtomicLong idCount = new AtomicLong();

  public PostRepository() {
    this.allPosts = new ConcurrentHashMap<>();
  }

  public Collection<Post> all() {
    return allPosts.values();
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(allPosts.get(id));
  }

  public Post save(Post post) {

    if (post.getId() == 0) {
      long id = idCount.incrementAndGet();
      post.setId(id);
      allPosts.put(id, post);
    } else {
      getById(post.getId()).orElseThrow(NotFoundException::new);
      allPosts.put(post.getId(), post);
    }
    return post;
  }

  public void removeById(long id) {
    allPosts.remove(id);
  }
}
