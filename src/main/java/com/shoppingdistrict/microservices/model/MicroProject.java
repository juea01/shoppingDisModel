package com.shoppingdistrict.microservices.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class MicroProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@Size(min = 2, max = 100, message = "Title should have at least two characters and no more than 100 characters")
	private String title;

	@Column(name = "short_description")
	@Size(max = 255, message = "Short description should have no more than 255 characters")
	private String shortDescription;

	@Column(name = "full_description", columnDefinition = "TEXT")
	private String fullDescription;

	@Column(name = "skill_level")
	private String skillLevel;

	@Column(name = "status")
	private String status;

	@Column(name = "category")
	private String category;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "micro_project_skill", joinColumns = @JoinColumn(name = "micro_project_id"))
	@Column(name = "skill")
	private List<String> skills;

	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "team_size")
	private int teamSize;
	
	@Column(name = "experience_point")
	private int experiencePoint;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "micro_project_open_role", joinColumns = @JoinColumn(name = "micro_project_id"))
	@Column(name = "open_role")
	private List<String> openRoles;
	
	// here, CascadeType.ALL mean also save child object (option)
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL) 
	private List<UserMicroProject> contributors;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and project indefinitely
	@JoinColumn(name = "user_id")
	private Users owner;

	@Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdDate;

	@Column(name = "last_edit_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastEditDate;

	public MicroProject() {

	}
	
	public MicroProject(int id,
			@Size(min = 2, max = 100, message = "Title should have at least two characters and no more than 100 characters") String title,
			@Size(max = 255, message = "Short description should have no more than 255 characters") String shortDescription,
			String fullDescription, String skillLevel, String status, String category, List<String> skills,
			String githubLink, int teamSize, int experiencePoint, List<String> openRoles,  List<UserMicroProject> contributors, Users owner,
			Timestamp createdDate, Timestamp lastEditDate) {
		super();
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.skillLevel = skillLevel;
		this.status = status;
		this.category = category;
		this.skills = skills;
		this.githubLink = githubLink;
		this.teamSize = teamSize;
		this.experiencePoint = experiencePoint;
		this.openRoles = openRoles;
		this.contributors = contributors;
		this.owner = owner;
		this.createdDate = createdDate;
		this.lastEditDate = lastEditDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	
	public int getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(int experiencePoint) {
		this.experiencePoint = experiencePoint;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}
	
	public List<UserMicroProject> getContributors() {
		return contributors;
	}

	public void setContributors(List<UserMicroProject> contributors) {
		this.contributors = contributors;
	}

	public List<String> getOpenRoles() {
		return openRoles;
	}

	public void setOpenRoles(List<String> openRoles) {
		this.openRoles = openRoles;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	@Override
	public String toString() {
		return "MicroProject [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status + "]";
	}

}
