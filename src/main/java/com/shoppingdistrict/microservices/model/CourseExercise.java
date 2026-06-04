package com.shoppingdistrict.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(
    name = "course_exercise",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = {"course_id", "exercise_id"}
        )
    }
)
public class CourseExercise {
 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

    @Column(name = "course_id", nullable = false)
    private int courseId;

    @Column(name = "exercise_id", nullable = false)
    private int exerciseId;
    
    @Column(name = "exercise_title")
	@Size(min = 3, max = 30, message = "Exercise title should have at least 3 characters and no more than 30 characters")
	private String exerciseTitle;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "active")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;
    
    public CourseExercise() {
    	
    }
    
	public CourseExercise(int id, int courseId, int exerciseId, 
			@Size(min = 3, max = 30, message = "Exercise title should have at least 3 characters and no more than 30 characters") String exerciseTitle, 
			Integer displayOrder, boolean active) {
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

	public String getExerciseTitle() {
		return exerciseTitle;
	}

	public void setExerciseTitle(String exerciseTitle) {
		this.exerciseTitle = exerciseTitle;
	}
	
}