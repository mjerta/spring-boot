package com.example.spring_boot.repository;

import com.example.spring_boot.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface   PhotosRepository extends CrudRepository<Photo, Integer> {

}
