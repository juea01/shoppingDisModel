package com.shoppingdistrict.microservices.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Parameter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	@Size(max = 15, message = "Type should be no more than 15 characters")
	private String type;
	
	@Column(name = "input_value")
	@Size( max = 30, message = "Input value should be no more than 30 characters")
	private String inputValue;
	
	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling test case and question-option
										// indefinitely
	@JoinColumn(name = "testcase_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Testcase testcase;

	

	public Parameter() {

	}

	public Parameter(int id,
			@Size(max = 15, message = "Type should be no more than 15 characters") String type,
			@Size( max = 30, message = "Input value should be no more than 30 characters") String inputValue,
			Testcase testcase) {
		super();
		this.id = id;
		this.testcase = testcase;
		this.type = type;
		this.inputValue = inputValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public Testcase getTestcase() {
		return testcase;
	}

	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}
	

}
