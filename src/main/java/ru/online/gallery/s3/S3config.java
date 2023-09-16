package ru.online.gallery.s3;

import software.amazon.awssdk.services.s3.S3Client;

public interface S3config {
    S3Client s3Client();
}
