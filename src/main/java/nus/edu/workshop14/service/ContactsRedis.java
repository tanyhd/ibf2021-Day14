package nus.edu.workshop14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import nus.edu.workshop14.model.Contacts;

@Service
public class ContactsRedis implements ContactsRepo{

    @Autowired
    private RedisTemplate<String, Object> template;

    @Override
    public void save(Contacts contact) {
        template.opsForValue().set(contact.getId(), contact);
    }

    @Override
    public Contacts findById(String contactId) {
        return (Contacts) template.opsForValue().get(contactId);
    }
    
}
