package com.example.spring_boot.web;

import com.example.spring_boot.model.Photo;
import com.example.spring_boot.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class HelloController {

  private final PhotosService photosService;

  public HelloController(@Autowired PhotosService photosService) {
    this.photosService = photosService;
  }

  @GetMapping("/")
  public String index() {
    return "Greetings from Spring eot!";
  }

  @GetMapping("/photos")
  public Iterable<Photo> getPhotos() {
    return photosService.get();
  }

  @GetMapping("/photos/{id}")
  public Photo getPhoto(@PathVariable Integer id) {
    Photo photo = photosService.get(id);
    if(photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return photo;
  }

  @DeleteMapping("/photos/{id}")
  public void delete(@PathVariable Integer id) {
    photosService.remove(id);
  }

  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    Photo photo = photosService.save(file.getOriginalFilename(), file.getContentType(),  file.getBytes());
    return photo;
  }



}