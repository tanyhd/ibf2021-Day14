package nus.edu.workshop14.service;
import nus.edu.workshop14.model.Contacts;

public interface ContactsRepo {
    public void save(final Contacts contact);
    public Contacts findById(final String contactId);
}
