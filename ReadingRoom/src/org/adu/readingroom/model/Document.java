package org.adu.readingroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENTS")
public class Document {
	
	@Column(name="ID")
	@Id
	@GeneratedValue
	int id;	
	
	@Column(name="TITLE", nullable=false)
	String title;
	
	@Column(name="FILE_NAME", nullable=false)
	String fileName;
	
	@Lob
	@Column(name="FILE_DATA")
	byte[] fileData;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}



	public String toString() {
		return "Id:" + this.getId() + ", Title:" + this.getTitle() + ", FileName:" + this.getFileName() + ", data:";
	}
}
