package ru.online.gallery.entity;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection = "images")
public class Image implements Serializable {
    @Id
    @Hidden
    private String id;
    @Schema(name = "name", example = "name", defaultValue = "name", minLength = 2, maxLength = 20)
    @NotNull(message = "name is empty")
    @Length(min = 2, max = 20, message = "name of image must contain more than 2 characters and less than 20 characters")
    private String name;
    @Hidden
    private String uri;
    @Hidden
    private String userId;
}
