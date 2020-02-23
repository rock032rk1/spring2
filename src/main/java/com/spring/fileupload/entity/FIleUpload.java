package com.spring.fileupload.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_upload")
public class FIleUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String filename;
	private String savepath;
	
     public FIleUpload() {
		// TODO Auto-generated constructor stub
	}

	public FIleUpload(String filename, String savepath) {
		super();
		this.filename = filename;
		this.savepath = savepath;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
     
     
}
