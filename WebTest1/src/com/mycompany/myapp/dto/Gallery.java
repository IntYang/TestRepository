package com.mycompany.myapp.dto;



import org.springframework.web.multipart.MultipartFile;

public class Gallery {
	 private int gno;
	 private String title;
	
	 private String originalfilename;
	 private String savedfilename;
	 private String filecontent;
	 private String filepath;
	 private MultipartFile attach;
	 
	 
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getSavedfilename() {
		return savedfilename;
	}
	public void setSavedfilename(String savedfilename) {
		this.savedfilename = savedfilename;
	}
	public String getFilecontent() {
		return filecontent;
	}
	public void setFilecontent(String filecontent) {
		this.filecontent = filecontent;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public MultipartFile getattach() {
		return attach;
	}
	public void setMattach(MultipartFile mattach) {
		this.attach = mattach;
	}









}

