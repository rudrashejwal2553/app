package com.example.medreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.medreminder.model.Reminder;
import com.example.medreminder.service.ReminderService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public String getAllReminders(Model model) {
        model.addAttribute("reminders", reminderService.getAllReminders());
        return "reminders/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reminder", new Reminder());
        return "reminders/add";
    }

    @PostMapping("/add")
    public String addReminder(@ModelAttribute Reminder reminder) {
        reminderService.saveReminder(reminder);
        return "redirect:/reminders";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("reminder", reminderService.getReminderById(id).orElse(null));
        return "reminders/edit";
    }

    @PostMapping("/edit/{id}")
    public String editReminder(@PathVariable Long id, @ModelAttribute Reminder reminder) {
        reminder.setId(id);
        reminderService.saveReminder(reminder);
        return "redirect:/reminders";
    }

    @GetMapping("/delete/{id}")
    public String deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return "redirect:/reminders";
    }
    @PostMapping("/addReminder")
    public String addReminder1(@ModelAttribute Reminder reminder) {
        System.out.println("Saving Reminder: " + reminder); // Log the reminder object
        reminderService.saveReminder(reminder);
        return "redirect:/reminders";
    }
}