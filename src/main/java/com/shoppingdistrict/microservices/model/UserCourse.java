package com.shoppingdistrict.microservices.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and user-course indefinitely
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling course and user-course indefinitely
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(name = "completed ")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean completed;
	
	@Column(name = "show_on_profile")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean showOnProfile;
	
	@Column(name = "first_completed_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp firstCompletedAt;
	
	@Column(name = "last_completed_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp lastCompletedAt;
	
	@Column(name = "enrollment_date", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp enrollmentDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private EnrollmentStatus status;
	
	@Column(name = "completion_percentage", precision = 10, scale = 2)
	private BigDecimal completionPercentage;
	
	@Column(name = "completed_items")
	private int completedItems;
	
	@Column(name = "total_items")
	private int totalItems;
	
	@Column(name = "last_progress_update", columnDefinition = "TIMESTAMP DEFAULT NULL")
	private Timestamp lastProgressUpdate;
	
	/**
	 * This way "mappedBy" only create relationship column in CompletedLecture, not here,
	 * CascadeType.ALL mean also save child objects 
	 */
	@OneToMany(mappedBy = "userCourse", cascade = CascadeType.ALL) 
	@JsonIgnore
	private List<CompletedLecture> completedLectures;

	public UserCourse() {

	}
	
	public UserCourse(int id, Users user, Course course, boolean completed, boolean showOnProfile, 
			Timestamp firstCompletedAt, Timestamp lastCompletedAt, Timestamp enrollmentDate, EnrollmentStatus status,
			 BigDecimal completionPercentage,  int completedItems, int totalItems, Timestamp lastProgressUpdate,
			List<CompletedLecture> completedLectures) {
		super();
		this.id = id;
		this.user = user;
		this.course = course;
		this.completed = completed;
		this.showOnProfile = showOnProfile;
		this.firstCompletedAt = firstCompletedAt;
		this.lastCompletedAt = lastCompletedAt;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
		this.completionPercentage = completionPercentage;
		this.completedItems = completedItems;
		this.totalItems = totalItems;
		this.lastProgressUpdate = lastProgressUpdate;
		this.completedLectures = completedLectures;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public boolean isShowOnProfile() {
		return showOnProfile;
	}


	public void setShowOnProfile(boolean showOnProfile) {
		this.showOnProfile = showOnProfile;
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


	public Timestamp getEnrollmentDate() {
		return enrollmentDate;
	}


	public void setEnrollmentDate(Timestamp enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}


	public List<CompletedLecture> getCompletedLectures() {
		return completedLectures;
	}


	public void setCompletedLectures(List<CompletedLecture> completedLectures) {
		this.completedLectures = completedLectures;
	}

	public EnrollmentStatus getStatus() {
		return status;
	}

	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}

	public BigDecimal getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(BigDecimal completionPercentage) {
		this.completionPercentage = completionPercentage;
	}

	public int getCompletedItems() {
		return completedItems;
	}

	public void setCompletedItems(int completedItems) {
		this.completedItems = completedItems;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public Timestamp getLastProgressUpdate() {
		return lastProgressUpdate;
	}

	public void setLastProgressUpdate(Timestamp lastProgressUpdate) {
		this.lastProgressUpdate = lastProgressUpdate;
	}
	
}
