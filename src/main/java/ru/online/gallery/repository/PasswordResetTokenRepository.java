package ru.online.gallery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.online.gallery.entity.PasswordResetToken;

import java.util.Optional;

public interface PasswordResetTokenRepository extends MongoRepository<PasswordResetToken, String> {
    Optional<PasswordResetToken> findByEmail(String email);
}
