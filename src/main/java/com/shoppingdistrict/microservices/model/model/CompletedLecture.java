package com.shoppingdistrict.microservices.model.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CompletedLecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling Completed-lecture and user-course indefinitely
	@JoinColumn(name = "user_course_id")
	private UserCourse userCourse;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling course and user-course indefinitely
	@JoinColumn(name = "article_id")
	private Articles course;

	@Column(name = "completion_count")
	private int completionCount;
	
	@Column(name = "first_completed_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp firstCompletedAt;
	
	@Column(name = "last_completed_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp lastCompletedAt;
	
	
	public CompletedLecture() {

	}

	public CompletedLecture(int id, UserCourse userCourse, Articles course, int completionCount,
			Timestamp firstCompletedAt, Timestamp lastCompletedAt) {
		super();
		this.id = id;
		this.userCourse = userCourse;
		this.course = course;
		this.completionCount = completionCount;
		this.firstCompletedAt = firstCompletedAt;
		this.lastCompletedAt = lastCompletedAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserCourse getUserCourse() {
		return userCourse;
	}


	public void setUserCourse(UserCourse userCourse) {
		this.userCourse = userCourse;
	}


	public Articles getCourse() {
		return course;
	}


	public void setCourse(Articles course) {
		this.course = course;
	}


	public int getCompletionCount() {
		return completionCount;
	}


	public void setCompletionCount(int completionCount) {
		this.completionCount = completionCount;
	}


	public Timestamp getFirstCompletedAt() {
		return firstCompletedAt;
	}


	public void setFirstCompletedAt(Timestamp firstCompletedAt) {
		this.firstCompletedAt = firstCompletedAt;
	}


	public Timestamp getLastCompletedAt() {
		return lastCompletedAt;
	}


	public void setLastCompletedAt(Timestamp lastCompletedAt) {
		this.lastCompletedAt = lastCompletedAt;
	}
	
	
}
