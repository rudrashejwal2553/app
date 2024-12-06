package com.example.medreminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medreminder.model.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder,Long>{

}
