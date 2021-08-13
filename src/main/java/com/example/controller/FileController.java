package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.FileModel;
import com.example.payload.UploadFileResponse;
import com.example.service.FileStorageService;


@RestController
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		FileModel fileModel = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.port(fileModel.getFileId()).toUriString();
		UploadFileResponse uploadFileResponse = new UploadFileResponse();
		uploadFileResponse.setFileId(fileModel.getFileId());
		uploadFileResponse.setFileName(fileModel.getName());
		uploadFileResponse.setFileDownloadUri(fileDownloadUri);
		return uploadFileResponse;
	}

	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMulitpleFiles(@RequestParam("file") MultipartFile[] files) {

		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) {

		FileModel fileModel = fileStorageService.getFile(fileId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileModel.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getFileName() + "\"")
				.body(new ByteArrayResource(fileModel.getData()));
	}
}
