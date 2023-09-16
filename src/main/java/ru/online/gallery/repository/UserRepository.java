package ru.online.gallery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.online.gallery.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(Object email);

    boolean existsByEmail(String email);
}
