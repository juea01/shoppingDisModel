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
public class QuestionOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	@Size(min = 3, max = 250, message = "Content should have at least 3 characters and no more than 250 characters")
	private String content;

	@Column(name = "explanation")
	@Size(max = 250, message = "Explanation  should be no more than 250 characters")
	private String explanation;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling question and question-option
										// indefinitely
	@JoinColumn(name = "question_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Question question;

	@Column(name = "correct_option")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean correctOption;

	public QuestionOption() {

	}

	public QuestionOption(int id,
			@Size(min = 3, max = 250, message = "Content should have at least 3 characters and no more than 250 characters") String content,
			@Size(max = 250, message = "Explaination should be no more than 250 characters") String explanation,
			Question question, boolean correctOption) {
		super();
		this.id = id;
		this.content = content;
		this.explanation = explanation;
		this.question = question;
		this.correctOption = correctOption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(boolean correctOption) {
		this.correctOption = correctOption;
	}

}
