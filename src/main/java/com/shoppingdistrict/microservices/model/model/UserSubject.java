package com.shoppingdistrict.microservices.model.model;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UserSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "num_correctly_completed_question")
	private int numCompletedQue;

	@Column(name = "enabled")
	private int enabled;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and user-subject
										// indefinitely
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling subject and user-subject
	// indefinitely
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Column(name = "completed ")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean completed;

	@OneToMany(mappedBy = "userSubject") // this way "mappedBy" only create relationship column in Question-Option, not
	// here
	private List<CompletedQuestion> completedQuestions;

	public UserSubject() {

	}

	public UserSubject(int id, int numCompletedQue, int enabled, Users user, Subject subject, boolean completed, List<CompletedQuestion> completedQuestions) {
		super();
		this.id = id;
		this.numCompletedQue = numCompletedQue;
		this.enabled = enabled;
		this.user = user;
		this.subject = subject;
		this.completed = completed;
		this.completedQuestions = completedQuestions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumCompletedQue() {
		return numCompletedQue;
	}

	public void setNumCompletedQue(int numCompletedQue) {
		this.numCompletedQue = numCompletedQue;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public List<CompletedQuestion> getCompletedQuestions() {
		return completedQuestions;
	}

	public void setCompletedQuestions(List<CompletedQuestion> completedQuestions) {
		this.completedQuestions = completedQuestions;
	}
	
	

}
