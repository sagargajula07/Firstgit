package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.FileModel;



public interface FileStorageService {

	public FileModel storeFile(MultipartFile file);

	public FileModel getFile(int fileId);

}
