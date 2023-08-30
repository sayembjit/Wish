package com.mottakin.birthdayReminder.service;

import com.mottakin.birthdayReminder.model.Birthday;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BirthdayService {
    List<Birthday> birthdayList = new ArrayList<>();
    @PostConstruct
    public void init()
    {
        birthdayList.add(new Birthday(1, "Sayem","November 28th"));
        birthdayList.add(new Birthday(2, "Ifran","November 23th"));
        birthdayList.add(new Birthday(3, "Maruf","November 25th"));
        birthdayList.add(new Birthday(4, "Tazwar","November 20th"));
        birthdayList.add(new Birthday(5, "Khalid","February 28th"));

    }

    public Birthday searchById(Integer id) {
        for (Birthday b : birthdayList) {
            if (Objects.equals(b.getId(), id))
                return b;
        }
        return null;
    }
    public List<Birthday> getAllBirthday() {
        return birthdayList;
    }
    public void addBirthday(Birthday birthday) {
        birthdayList.add(birthday);
    }
    public void deleteExpense(Integer id) {
        Birthday birthdayToRemove = null;
        for (Birthday birthday : birthdayList) {
            if (Objects.equals(birthday.getId(), id)) {
                birthdayToRemove = birthday;
                break;
            }
        }

        if (birthdayToRemove != null) {
            birthdayList.remove(birthdayToRemove);
        }
    }
}
