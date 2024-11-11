package edu.fra.uas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.service.MessageService;

@Component
public class BeanController {
    
    @Autowired
    private MessageService messageService;
    private ArrayList<Double> noten = new ArrayList<>();  // Liste für Noten

    public String putMessage(String message) {
        messageService.setMessage("Put message: " + message);
        return messageService.getMessage();
    }

    public String addNote(double note){
        noten.add(note);  // Note zur Liste hinzufügen
        return putMessage(note + " wurde hinzugefuegt");
    }

    public double getSchnitt(){
        if (noten.isEmpty()) {  // Überprüfen, ob die Liste leer ist
            return 0.0;  // Verhindern einer Division durch 0
        }
        double summe = 0;
        for (double note : noten) {
            summe += note;  // Summe der Noten berechnen
        }
        return summe / noten.size();  // Durchschnitt berechnen
    }
}
