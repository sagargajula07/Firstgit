package com.example.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "FILEDB")

public class FileModel {

	@Id
	@GeneratedValue
	private int fileId;
	
    private String name;


	@Lob
	private byte[] data;

	public FileModel(int fileId, String name, byte[] data) {
		super();
		this.fileId = fileId;
		
		this.data = data;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileModel() {
		// TODO Auto-generated constructor stub
	}

	

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
}
