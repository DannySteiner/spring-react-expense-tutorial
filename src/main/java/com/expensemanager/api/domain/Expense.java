package com.expensemanager.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Expense {

	@Id
	@NotEmpty
	String id;
	@NotEmpty
	String description;
	@NotEmpty
	Integer amount;
	@NotEmpty
	String month;
	@NotEmpty
	int year;

	public Expense(@NotEmpty String id, @NotEmpty String description, @NotEmpty Integer amount, @NotEmpty String month, @NotEmpty int year) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.month = month;
		this.year = year;
	}

	public Expense() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
