package com.expensemanager.api.repositories;

import com.expensemanager.api.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, String>  {
	List<Expense> findByMonthAndYear(String month, int year);

	List<Expense> findByYear(int year);
}
