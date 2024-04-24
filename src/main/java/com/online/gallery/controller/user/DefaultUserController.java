package com.online.gallery.controller.user;

import com.online.gallery.dto.request.PasswordUpdateRequest;
import com.online.gallery.dto.response.MessageResponse;
import com.online.gallery.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "api/v1/users")
public class DefaultUserController implements UserController {
    private final UserService userService;

    public DefaultUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/profileImage", produces = {
            MediaType.IMAGE_JPEG_VALUE,
            MediaType.IMAGE_GIF_VALUE,
            MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getProfileImage(Authentication authentication) {
        return ResponseEntity
                .ok()
                .body(userService.getProfileImage(userService.getUser(authentication)));
    }

    @PostMapping(value = "/profileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> saveProfileImage(
            @RequestPart MultipartFile profileImageFile,
            Authentication authentication) throws IOException {
        return ResponseEntity
                .ok(new MessageResponse(
                        userService.saveProfileImage(
                                profileImageFile,
                                userService.getUser(authentication))));
    }

    @PatchMapping(value = "/profileImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> updateProfileImage(
            @RequestPart MultipartFile profileImageFile,
            Authentication authentication) throws IOException {
        return ResponseEntity
                .ok(new MessageResponse(
                        userService.updateProfileImage(
                                profileImageFile,
                                userService.getUser(authentication))));
    }

    @PatchMapping(value = "/password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> updatePassword(
            @RequestBody @Valid PasswordUpdateRequest request,
            Authentication authentication) {
        return ResponseEntity
                .ok(new MessageResponse(userService.updateUserPassword(
                        request.getOldPassword(),
                        request.getNewPassword(),
                        userService.getUser(authentication))));
    }
}