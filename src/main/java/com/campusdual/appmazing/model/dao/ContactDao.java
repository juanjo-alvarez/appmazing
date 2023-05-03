package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
}
