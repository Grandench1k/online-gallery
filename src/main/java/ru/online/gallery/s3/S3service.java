package ru.online.gallery.s3;

public interface S3service {

    void putObject(String bucketName, String key, byte[] file);

    byte[] getObject(String bucketName, String key);

    void deleteObject(String bucketName, String key);
}
