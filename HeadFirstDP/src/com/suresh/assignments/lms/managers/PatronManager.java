package com.suresh.assignments.lms.managers;

import com.suresh.assignments.lms.entities.Patron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatronManager {
    private List<Patron> patrons;

    public PatronManager() {
        this.patrons = new ArrayList<>();
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void updatePatron(String patronId, String newName) {
        for (Patron patron : patrons) {
            if (patron.getPatronId().equals(patronId)) {
                patron = new Patron(newName, patronId);
                break;
            }
        }
    }

    public Patron findPatron(String patronId) {
        return patrons.stream().filter(p -> p.getPatronId().equals(patronId)).findFirst().orElse(null);
    }

    public List<Patron> getAllPatrons() {
        return Collections.unmodifiableList(patrons);
    }
}
