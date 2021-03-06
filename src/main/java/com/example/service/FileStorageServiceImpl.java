package com.example.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.FileStorageException;
import com.example.exception.MyFileNotFoundException;
import com.example.model.FileModel;
import com.example.repository.DBFileRepository;



@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Autowired
	private DBFileRepository dbFileRepository;

	@Override
	public FileModel storeFile(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! your file contails invalid characters...");
			}

			FileModel fileModel = new FileModel();
			fileModel.setFileName(fileName);
			fileModel.setFileType(file.getContentType());
			fileModel.setData(file.getBytes());

			return dbFileRepository.save(fileModel);

		} catch (IOException ioe) {
			throw new FileStorageException("could not store file " + fileName + " Please try again, " + ioe);
		}
		sagar

	}



}
