package com.example.demo.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Habit;
import com.example.demo.exception.HabitNotFoundException;
import com.example.demo.repository.HabitRepository;

import org.springframework.mail.SimpleMailMessage;

@Service
@EnableScheduling
public class HabitService {
    
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SimpleMailMessage template;

    public Habit addHabit(Habit habit){
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id, Habit habit) {
        Habit existingHabit = getHabit(id);
        existingHabit.setName(habit.getName());
        existingHabit.setFrequency(habit.getFrequency());
        existingHabit.setUnit(habit.getUnit());
        existingHabit.setRecurring(habit.getRecurring());
        return habitRepository.save(existingHabit);
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }

    public List<Habit> getHabitsByUser(Long id) {
        
        return habitRepository.findByUser_Id(id);
    }

    public Habit getHabit(Long id) {
        Optional<Habit> optionalHabit = habitRepository.findById(id);
        if(optionalHabit.isPresent()){
            return optionalHabit.get();
        }
        throw new HabitNotFoundException("Habit not found");
    }


    @Scheduled(cron = "0 * * * * *") //0 * * * * *    vsqka minuta
                                     //0 0 0 * * *    vseki chas
    public void scheduledReservationExpirationReminder() {
        List<Habit> Habits = habitRepository.findAll();

        for (Habit hab : Habits) {
            String email = hab.getUser().getEmail();
            String text = String.format(template.getText(), hab.getName(), hab.getFrequency(), hab.getUnit(), hab.getRecurring());
            emailService.sendSimpleMessage(email, "subject", text);
        }
    }
}
