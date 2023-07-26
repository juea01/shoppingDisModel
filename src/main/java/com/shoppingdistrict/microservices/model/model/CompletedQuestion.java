package com.shoppingdistrict.microservices.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CompletedQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling question and completed-question
										// indefinitely
	@JoinColumn(name = "question_id")
	private Question question;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user_subject and completed_question
	// indefinitely
	@JoinColumn(name = "user_subject_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private UserSubject userSubject;

	public CompletedQuestion() {

	}

	public CompletedQuestion(int id, Question question, UserSubject userSubject) {
		super();
		this.id = id;
		this.question = question;
		this.userSubject = userSubject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public UserSubject getUserSubject() {
		return userSubject;
	}

	public void setUserSubject(UserSubject userSubject) {
		this.userSubject = userSubject;
	}
	
	

}
