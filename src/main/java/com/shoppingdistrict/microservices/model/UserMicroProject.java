package com.shoppingdistrict.microservices.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

import org.hibernate.annotations.Type;

@Entity
public class UserMicroProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and project indefinitely
	@JoinColumn(name = "user_id")
	private Users contributor;
	
	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and project indefinitely
	@JoinColumn(name = "micro_project_id")
	private MicroProject project;
	
	@Column(name = "experience_point")
	private int experiencePoint;
	
	@Column(name = "show_on_profile")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean showOnProfile;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "contribution_percentage", precision = 10, scale = 2)
	private BigDecimal contributionPercentage;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private MicroProjectJoinedStatus status;

	@Column(name = "joined_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp joinedDate;

	@Column(name = "lastactive_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastactiveDate;

	public UserMicroProject() {

	}

	public UserMicroProject(int id, Users contributor, MicroProject project, int experiencePoint, boolean showOnProfile,
			String role, BigDecimal contributionPercentage, MicroProjectJoinedStatus status, Timestamp joinedDate,
			Timestamp lastactiveDate) {
		super();
		this.id = id;
		this.contributor = contributor;
		this.project = project;
		this.experiencePoint = experiencePoint;
		this.showOnProfile = showOnProfile;
		this.role = role;
		this.contributionPercentage = contributionPercentage;
		this.status = status;
		this.joinedDate = joinedDate;
		this.lastactiveDate = lastactiveDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getContributor() {
		return contributor;
	}

	public void setContributor(Users contributor) {
		this.contributor = contributor;
	}

	public MicroProject getProject() {
		return project;
	}

	public void setProject(MicroProject project) {
		this.project = project;
	}

	public int getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(int experiencePoint) {
		this.experiencePoint = experiencePoint;
	}

	public boolean isShowOnProfile() {
		return showOnProfile;
	}

	public void setShowOnProfile(boolean showOnProfile) {
		this.showOnProfile = showOnProfile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getContributionPercentage() {
		return contributionPercentage;
	}

	public void setContributionPercentage(BigDecimal contributionPercentage) {
		this.contributionPercentage = contributionPercentage;
	}

	public MicroProjectJoinedStatus getStatus() {
		return status;
	}

	public void setStatus(MicroProjectJoinedStatus status) {
		this.status = status;
	}

	public Timestamp getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Timestamp joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Timestamp getLastactiveDate() {
		return lastactiveDate;
	}

	public void setLastactiveDate(Timestamp lastactiveDate) {
		this.lastactiveDate = lastactiveDate;
	}
	
}
