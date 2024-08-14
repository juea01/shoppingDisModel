package com.shoppingdistrict.microservices.model.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Prompt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Size(max = 45, message = "Name should not have more than 45 characters")
	private String name;

	@Column(name = "prompt")
	@Size(max = 4000, message = "Prompt should not have more than 4000 characters")
	private String prompt;

	@Column(name = "content")
	@Size(max = 4000, message = "Content should not have more than 4000 characters")
	private String content;

	@Column(name = "creationdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDate;

	@Column(name = "lasteditdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastEditDate;

	public Prompt() {

	}

	public Prompt(int id, @Size(max = 45, message = "Name should not have more than 45 characters") String name,
			@Size(max = 4000, message = "Prompt should not have more than 4000 characters") String prompt,
			@Size(max = 4000, message = "Content should not have more than 4000 characters") String content,
			Timestamp creationDate, Timestamp lastEditDate) {
		super();
		this.id = id;
		this.name = name;
		this.prompt = prompt;
		this.content = content;
		this.lastEditDate = lastEditDate;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

}
