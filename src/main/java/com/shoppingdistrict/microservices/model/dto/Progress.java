package com.shoppingdistrict.microservices.model.dto;

public class Progress {

  private int enrolledCourses;
  private int completedCourses;
  private int completedExercises;
  private int totalExercises;
  private double averageScore;
  
	public Progress() {
	}

	public Progress(int enrolledCourses, int completedCourses, int completedExercises, int totalExercises,
			double averageScore) {
		super();
		this.enrolledCourses = enrolledCourses;
		this.completedCourses = completedCourses;
		this.completedExercises = completedExercises;
		this.totalExercises = totalExercises;
		this.averageScore = averageScore;
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
	
}
