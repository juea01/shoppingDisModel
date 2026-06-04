package com.shoppingdistrict.microservices.model.dto;


public class CourseExercise {

		private int id;
	    private int courseId;
	    private int exerciseId;
		private String exerciseTitle;
	    private Integer displayOrder;
		private boolean active;
		
		public CourseExercise() {
			
		}
		
		public CourseExercise(int id, int courseId, int exerciseId, String exerciseTitle, Integer displayOrder,
				boolean active) {
			super();
			this.id = id;
			this.courseId = courseId;
			this.exerciseId = exerciseId;
			this.exerciseTitle = exerciseTitle;
			this.displayOrder = displayOrder;
			this.active = active;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		public int getExerciseId() {
			return exerciseId;
		}

		public void setExerciseId(int exerciseId) {
			this.exerciseId = exerciseId;
		}

		public String getExerciseTitle() {
			return exerciseTitle;
		}

		public void setExerciseTitle(String exerciseTitle) {
			this.exerciseTitle = exerciseTitle;
		}

		public Integer getDisplayOrder() {
			return displayOrder;
		}

		public void setDisplayOrder(Integer displayOrder) {
			this.displayOrder = displayOrder;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
	
}
