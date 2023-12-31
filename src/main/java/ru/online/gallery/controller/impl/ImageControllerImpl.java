package ru.online.gallery.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.online.gallery.controller.ImageController;
import ru.online.gallery.entity.Image;
import ru.online.gallery.service.ImageService;
import ru.online.gallery.service.UserService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/image")
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Image>> findAllImages(Authentication authentication) {
        return ResponseEntity.ok().body(imageService.findAllImages(userService.createUserAndReturnUserId(authentication)));
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.IMAGE_JPEG_VALUE,
            MediaType.IMAGE_GIF_VALUE,
            MediaType.IMAGE_PNG_VALUE,
            "image/tiff",
            "image/bmp",
            "image/jpg",
            "image/webp"})
    public ResponseEntity<byte[]> findImageById(
            @PathVariable String id,
            Authentication authentication) {
        return ResponseEntity.ok().body(imageService.findImageById(id, userService.createUserAndReturnUserId(authentication)));
    }

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Image> saveImage(
            @RequestPart @Validated Image image,
            @RequestPart MultipartFile imageFile,
            Authentication authentication) throws IOException {
        return ResponseEntity.ok().body(imageService.saveImage(imageFile, image, userService.createUserAndReturnUserId(authentication)));
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<Image> updateImageById(
            @PathVariable String id,
            @RequestBody @Validated Image image,
            Authentication authentication) {
        return ResponseEntity.ok().body(imageService.updateImageById(id, image, userService.createUserAndReturnUserId(authentication)));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Image> deleteImageById(
            @PathVariable String id,
            Authentication authentication) {
        return ResponseEntity.ok().body(imageService.deleteImageById(id, userService.createUserAndReturnUserId(authentication)));
    }
}
