package com.example.adoption.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "new_info")
public class NewInfo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "serial_no")
	private int serialNo;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "category")
	private String category;

	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private byte[] image;

	@Column(name = "type")
	private String type;

	public NewInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewInfo(int serialNo, String title, String content, LocalDate date, String category, byte[] image,
			String type) {
		super();
		this.serialNo = serialNo;
		this.title = title;
		this.content = content;
		this.date = date;
		this.category = category;
		this.image = image;
		this.type = type;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
