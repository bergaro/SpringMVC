package ru.netology.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
  public List<Post> all() {
    List<Post> validPostList = new ArrayList<>();
    for(Post post : service.all()) {
      if (!post.getRemoved()) {
        validPostList.add(post);
      }
    }
    return validPostList;
  }

  @GetMapping("/{id}")
  public Post getById(@PathVariable long id) {
    Post post = service.getById(id);
    if(!post.getRemoved()) {
      return post;
    } else {
      throw new NotFoundException();
    }
  }

  @PostMapping
  public Post save(@RequestBody Post post) {
    if(!post.getRemoved()) {
      return service.save(post);
    } else {
      throw new NotFoundException();
    }
  }

  @DeleteMapping("/{id}")
  public void removeById(@PathVariable long id) {
    service.removeById(id);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post NOT found!")
  @ExceptionHandler(NotFoundException.class)
  public String notFoundHandleEx(NotFoundException ex) {
    return ex.getMessage();
  }
}
