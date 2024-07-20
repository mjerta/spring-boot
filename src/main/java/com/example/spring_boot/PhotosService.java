package com.example.spring_boot;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class PhotosService {

  private Map<String, Photo> photos = new HashMap<>() {{
    put("1", new Photo( "1", "hello.jpg"));
  }};

  public Collection<Photo> get() {
    return photos.values();
  }

  public Photo get(String id) {
    return photos.get(id);
  }

  public Photo remove(String id) {
    return photos.remove(id);
  }

  public void put(String id, Photo photo) {
    photos.put(id, photo);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setContentType(contentType);
    photo.setId(UUID.randomUUID().toString());
    photo.setFileName(fileName);
    photo.setData(data);
    photos.put(photo.getId(), photo);
    return photo;
  }
}
