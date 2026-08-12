package com.shoppingdistrict.microservices.model.dto;

import java.math.BigDecimal;

public class CourseHubSnapshot {

    private int courseId;
    private int userId;
    private int userCourseId;
    
    private int learningActivitiesCompleted;
    private int learningActivitiesTotal;
    private int exercisesCompleted;
    private int exercisesTotal;
    
    private int xpEarned;
    private int xpAvailable;
    
    private BigDecimal courseCompletionPercentage;
    private BigDecimal completionPercentage;
    
	public CourseHubSnapshot() {
		
	}

	public CourseHubSnapshot(int courseId, int userId, int userCourseId, int learningActivitiesCompleted,
			int learningActivitiesTotal, int exercisesCompleted, int exercisesTotal, int xpEarned, int xpAvailable,
			BigDecimal courseCompletionPercentage, BigDecimal completionPercentage) {
		super();
		this.courseId = courseId;
		this.userId = userId;
		this.userCourseId = userCourseId;
		this.learningActivitiesCompleted = learningActivitiesCompleted;
		this.learningActivitiesTotal = learningActivitiesTotal;
		this.exercisesCompleted = exercisesCompleted;
		this.exercisesTotal = exercisesTotal;
		this.xpEarned = xpEarned;
		this.xpAvailable = xpAvailable;
		this.courseCompletionPercentage = courseCompletionPercentage;
		this.completionPercentage = completionPercentage;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserCourseId() {
		return userCourseId;
	}

	public void setUserCourseId(int userCourseId) {
		this.userCourseId = userCourseId;
	}

	public int getLearningActivitiesCompleted() {
		return learningActivitiesCompleted;
	}

	public void setLearningActivitiesCompleted(int learningActivitiesCompleted) {
		this.learningActivitiesCompleted = learningActivitiesCompleted;
	}

	public int getLearningActivitiesTotal() {
		return learningActivitiesTotal;
	}

	public void setLearningActivitiesTotal(int learningActivitiesTotal) {
		this.learningActivitiesTotal = learningActivitiesTotal;
	}

	public int getExercisesCompleted() {
		return exercisesCompleted;
	}

	public void setExercisesCompleted(int exercisesCompleted) {
		this.exercisesCompleted = exercisesCompleted;
	}

	public int getExercisesTotal() {
		return exercisesTotal;
	}

	public void setExercisesTotal(int exercisesTotal) {
		this.exercisesTotal = exercisesTotal;
	}

	public int getXpEarned() {
		return xpEarned;
	}

	public void setXpEarned(int xpEarned) {
		this.xpEarned = xpEarned;
	}

	public int getXpAvailable() {
		return xpAvailable;
	}

	public void setXpAvailable(int xpAvailable) {
		this.xpAvailable = xpAvailable;
	}

	public BigDecimal getCourseCompletionPercentage() {
		return courseCompletionPercentage;
	}

	public void setCourseCompletionPercentage(BigDecimal courseCompletionPercentage) {
		this.courseCompletionPercentage = courseCompletionPercentage;
	}

	public BigDecimal getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(BigDecimal completionPercentage) {
		this.completionPercentage = completionPercentage;
	}
	
}