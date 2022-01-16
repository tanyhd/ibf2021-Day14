package nus.edu.workshop14.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import nus.edu.workshop14.model.Contacts;
import nus.edu.workshop14.service.ContactsRedis;

@Controller
public class AddressbookController {

    @Autowired
    private ContactsRedis contactRedis;
   
    
    @GetMapping("/form")
    public String showForm(Model model) {
        Contacts personContact = new Contacts();
        model.addAttribute("contacts", personContact);
        return "form";
    }

    @GetMapping("/contact/{id}")
    public String getContactFromId(@PathVariable String id, Model model) throws IOException{
        Contacts returnedPersonInfo = new Contacts();
        returnedPersonInfo = contactRedis.findById(id);
        model.addAttribute("returnedPersonInfo", returnedPersonInfo);
        return "personContact";
    }

    @PostMapping("/contact")
    public String submitForm(@ModelAttribute Contacts contact, Model model) throws IOException {
        model.addAttribute("contactInfo", contact);
        contactRedis.save(contact);
        return "contact";
    }
}