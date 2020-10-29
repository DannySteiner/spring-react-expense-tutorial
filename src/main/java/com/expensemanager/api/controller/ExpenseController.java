package com.expensemanager.api.controller;

import com.expensemanager.api.domain.Expense;
import com.expensemanager.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@GetMapping
	public ResponseEntity<List<Expense>> getAll() {
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/{year}/{month}")
	public ResponseEntity<List<Expense>> findByMonthYear(@PathVariable("month") String month, @PathVariable("year") int year) {
		List<Expense> expenses;

		if("All".equalsIgnoreCase(month)) {
			expenses = expenseService.findByYear(year);
		} else {
			expenses = expenseService.findByMonthAndYear(month, year);
		}

		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addorUpdateExpense(@RequestBody Expense expense) {
		expenseService.saveOrUpdateExpense(expense);
		return new ResponseEntity<>("Expense added succcessfully", HttpStatus.OK);
	}

	@DeleteMapping
	public void deleteExpense(@RequestParam("id") String id) {
		expenseService.deleteExpense(id);
	}
}
