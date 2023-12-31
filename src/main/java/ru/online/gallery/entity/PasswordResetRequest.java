package ru.online.gallery.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetRequest {
    @Email(message = "invalid email address")
    @NotNull(message = "email is empty")
    @Schema(name = "email", example = "email@example.org", defaultValue = "email", minLength = 2, maxLength = 320)
    private String email;
}
