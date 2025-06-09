package com.shoppingdistrict.microservices.model.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	@Size(min = 3, max = 250, message = "Content should have at least 3 characters and no more than 250 characters")
	private String content;
	
	@Column(name = "experience_point")
	private int experiencePoint;

	// this way "mappedBy" only create relationship column in Question-Option, not
	// here, CascadeType.ALL mean also save child object (option)
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL) 
	private List<QuestionOption> options;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling question and articles
										// indefinitely
	@JoinColumn(name = "article_id")
	private Articles article;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling question and Subject
	// indefinitely
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@OneToMany(mappedBy = "question") // this way "mappedBy" only create relationship column in Question, not
	// here
	@JsonIgnore
	private List<CompletedQuestion> completedQuestions;
	
	@Column(name = "question_type")
	@Size(min = 2, max = 30, message = "Question type should have at least 2 characters and no more than 30 characters")
	private String questionType;
	
	@Column(name = "allocated_time")
	private int allocatedTime;

	public Question() {

	}

	public Question(int id,
			@Size(min = 3, max = 250, message = "Content should have at least 3 characters and no more than 250 characters") String content,
			int experiencePoint,
			List<QuestionOption> options, Articles article, Subject subject, List<CompletedQuestion> completedQuestions, String questionType, int allocatedTime) {
		super();
		this.id = id;
		this.content = content;
		this.experiencePoint = experiencePoint;
		this.options = options;
		this.article = article;
		this.subject = subject;
		this.completedQuestions = completedQuestions;
		this.questionType = questionType;
		this.allocatedTime = allocatedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<QuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(int experiencePoint) {
		this.experiencePoint = experiencePoint;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<CompletedQuestion> getCompletedQuestions() {
		return completedQuestions;
	}

	public void setCompletedQuestions(List<CompletedQuestion> completedQuestions) {
		this.completedQuestions = completedQuestions;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public int getAllocatedTime() {
		return allocatedTime;
	}

	public void setAllocatedTime(int allocatedTime) {
		this.allocatedTime = allocatedTime;
	}
	

}
