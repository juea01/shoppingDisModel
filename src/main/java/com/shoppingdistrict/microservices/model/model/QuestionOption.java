package com.shoppingdistrict.microservices.model.model;

import java.util.List;

import javax.persistence.CascadeType;
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
public class QuestionOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	@Size(min = 3, max = 900, message = "Content should have at least 3 characters and no more than 250 characters")
	private String content;

	@Column(name = "explanation")
	@Size(max = 900, message = "Explanation  should be no more than 250 characters")
	private String explanation;
	
	@Column(name = "method_name")
	@Size( max = 20, message = "Method name should be no more than 20 characters")
	private String methodName;
	
	@Column(name = "class_name")
	@Size( max = 20, message = "Class name should be no more than 20 characters")
	private String className;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling question and question-option
										// indefinitely
	@JoinColumn(name = "question_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Question question;

	@Column(name = "correct_option")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean correctOption;
	
	// this way "mappedBy" only create relationship column in testcase, not
	// here, CascadeType.ALL mean also save child object 
	@OneToMany(mappedBy = "questionOption", cascade = CascadeType.ALL) 
	private List<Testcase> testcases;

	public QuestionOption() {

	}

	public QuestionOption(int id,
			@Size(min = 3, max = 900, message = "Content should have at least 3 characters and no more than 250 characters") String content,
			@Size(max = 900, message = "Explaination should be no more than 250 characters") String explanation,
			@Size(max = 20, message = "Method name should be no more than 20 characters") String methodName,
			@Size(max = 20, message = "Class name should be no more than 20 characters") String className,
			Question question, boolean correctOption, List<Testcase> testcases) {
		super();
		this.id = id;
		this.content = content;
		this.explanation = explanation;
		this.question = question;
		this.correctOption = correctOption;
		this.methodName = methodName;
		this.className = className;
		this.testcases = testcases;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(boolean correctOption) {
		this.correctOption = correctOption;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Testcase> getTestcases() {
		return testcases;
	}

	public void setTestcases(List<Testcase> testcases) {
		this.testcases = testcases;
	}
	
	

}
