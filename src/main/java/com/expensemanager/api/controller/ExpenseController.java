package com.expensemanager.api.controller;

import com.expensemanager.api.domain.Expense;
import com.expensemanager.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/{year}/{month}")
	public ResponseEntity<?> findByMonthYear(@PathVariable("month") String month, @PathVariable("year") int year) {
		List<Expense> expenses;

		if("All".equals(month)) {
			expenses = expenseService.findByYear(year);
		} else {
			expenses = expenseService.findByMonthAndYear(month, year);
		}

		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
}
