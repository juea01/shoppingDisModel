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
public class Testcase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	@Size(min = 3, max = 30, message = "Description should have at least 3 characters and no more than 30 characters")
	private String description;
	
	@Column(name = "expected_output")
	@Size( max = 10, message = "Expected output should have no more than 10 characters")
	private String expectedOutput;
	
	@Column(name = "expected_output_type")
	@Size(max = 10, message = "Expected output type should have no more than 10 characters")
	private String expectedOutputType;

	

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling test case and question-option
										// indefinitely
	@JoinColumn(name = "question_option_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private QuestionOption questionOption;
	
	// this way "mappedBy" only create relationship column in parameter, not
	// here, CascadeType.ALL mean also save child object 
	@OneToMany(mappedBy = "testcase", cascade = CascadeType.ALL) 
	private List<Parameter> parameters;


	

	public Testcase() {

	}

	public Testcase(int id,
			@Size(min = 3, max = 30, message = "Description should have at least 3 characters and no more than 30 characters") String description,
			@Size( max = 10, message = "Expected output should have no more than 10 characters") String expectedOutput,
	        @Size(max = 10, message = "Expected output type should have no more than 10 characters") String expectedOutputType,
			QuestionOption questionOption, List<Parameter> parameters ) {
		super();
		this.id = id;
		this.description = description;
		this.questionOption = questionOption;
		this.expectedOutput = expectedOutput;
		this.expectedOutputType = expectedOutputType;
		this.parameters = parameters;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	public String getExpectedOutputType() {
		return expectedOutputType;
	}

	public void setExpectedOutputType(String expectedOutputType) {
		this.expectedOutputType = expectedOutputType;
	}

	public QuestionOption getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(QuestionOption questionOption) {
		this.questionOption = questionOption;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}


}
