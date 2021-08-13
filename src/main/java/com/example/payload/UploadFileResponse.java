package com.example.payload;



public class UploadFileResponse {

	private int fileId;
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
	public UploadFileResponse(int fileId, String fileName, String fileDownloadUri, String fileType, long size) {
		super();
		this.fileId=fileId;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}
	public UploadFileResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	
}
