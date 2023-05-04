package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("ContractService")
@Lazy
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto queryContact(ContactDto contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        return ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contact.getId()));
    }

    @Override
    public List<ContactDto> queryAllContact() {
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    @Override
    public int insertContact(ContactDto contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDto contactDTO) {
        return insertContact(contactDTO);
    }

    @Override
    public int deleteContact(ContactDto contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDao.delete(contact);
        return contact.getId();
    }

    @Override
    public int updateSecureContact(ContactDto newContact) {
        try{
            ContactDto oldContact = ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(newContact.getId()));
            if(newContact.getName()!=null){
                oldContact.setName(newContact.getName());
            }
            if(newContact.getSurname()!=null){
                oldContact.setSurname(newContact.getSurname());
            }
            if(newContact.getSurname2()!=null){
                oldContact.setSurname2(newContact.getSurname2());
            }
            if(newContact.getEmail()!=null){
                oldContact.setEmail(newContact.getEmail());
            }
            if(newContact.getTelephone()!=null){
                oldContact.setTelephone(newContact.getTelephone());
            }
            return updateContact(oldContact);
        }catch (EntityNotFoundException e){
            return -1;
        }
    }
}
