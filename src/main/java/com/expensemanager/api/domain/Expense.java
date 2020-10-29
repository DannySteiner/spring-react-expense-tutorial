package com.expensemanager.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotEmpty
	String description;
	@NotEmpty
	Integer amount;
	@NotEmpty
	String month;
	@NotEmpty
	int year;

	public Expense(@NotEmpty int id, @NotEmpty String description, @NotEmpty Integer amount, @NotEmpty String month, @NotEmpty int year) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.month = month;
		this.year = year;
	}

	public Expense() {
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
