package ru.online.gallery.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.online.gallery.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends MongoRepository<Video, String> {
    List<Video> findAllByUserId(String userId);

    Optional<Video> findByNameAndUserId(String name, String userId);

    Optional<Video> findByIdAndUserId(String id, String userId);
}
