package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @PostMapping(value = "/get")
    public ContactDto queryContact(@RequestBody ContactDto contact){
        return contactService.queryContact(contact);
    }

    @PostMapping(value = "/getAll")
    public List<ContactDto> queryAllContacts(){
        return contactService.queryAllContact();
    }

    @PostMapping(value = "/add")
    public int addContact(@RequestBody ContactDto contact){
        return contactService.insertContact(contact);
    }

    @PutMapping(value = "/update")
    public int updateContact(@RequestBody ContactDto contact){
        return contactService.updateContact(contact);
    }

    //Hace un update solo de aquellos campos no vacíos
    @PutMapping(value = "/secureupdate")
    public int secureUpdateContact(@RequestBody ContactDto contact){
        return contactService.updateSecureContact(contact);
    }

    @DeleteMapping(value = "/delete")
    public int deleteContact(@RequestBody ContactDto contact){
        return contactService.deleteContact(contact);
    }
}