package ru.online.gallery.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Document(collection = "passwordResetToken")
public class PasswordResetToken {
    @Id
    private String id;
    private String email;
    private LocalDateTime expiredAt = LocalDateTime.now().plusMinutes(15);

    public PasswordResetToken(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
