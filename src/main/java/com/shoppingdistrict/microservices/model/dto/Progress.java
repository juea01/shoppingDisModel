package com.shoppingdistrict.microservices.model.dto;

import java.math.BigDecimal;

public class Progress {

  private int enrolledCourses;
  private int completedCourses;
  private int completedExercises;
  private int totalExercises;
  private int allTimeXP;
  private double averageScore;
  private BigDecimal totalCompletionPercentage;
  
	public Progress() {
	}

	public Progress(int enrolledCourses, int completedCourses, int completedExercises, int totalExercises,
			int allTimeXP, double averageScore, BigDecimal totalCompletionPercentage) {
		super();
		this.enrolledCourses = enrolledCourses;
		this.completedCourses = completedCourses;
		this.completedExercises = completedExercises;
		this.totalExercises = totalExercises;
		this.allTimeXP = allTimeXP;
		this.averageScore = averageScore;
		this.totalCompletionPercentage = totalCompletionPercentage;
	}

	public int getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(int enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public int getCompletedCourses() {
		return completedCourses;
	}

	public void setCompletedCourses(int completedCourses) {
		this.completedCourses = completedCourses;
	}

	public int getCompletedExercises() {
		return completedExercises;
	}

	public void setCompletedExercises(int completedExercises) {
		this.completedExercises = completedExercises;
	}

	public int getTotalExercises() {
		return totalExercises;
	}

	public void setTotalExercises(int totalExercises) {
		this.totalExercises = totalExercises;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public BigDecimal getTotalCompletionPercentage() {
		return totalCompletionPercentage;
	}

	public void setTotalCompletionPercentage(BigDecimal totalCompletionPercentage) {
		this.totalCompletionPercentage = totalCompletionPercentage;
	}

	public int getAllTimeXP() {
		return allTimeXP;
	}

	public void setAllTimeXP(int allTimeXP) {
		this.allTimeXP = allTimeXP;
	}
	
}
