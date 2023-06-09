package seminar3.controller;
import seminar3.view.ContactData;
import seminar3.data.Contact;
import java.util.List;
import static seminar3.view.ContactDataMaker.getContactData;

public class ContactManager 
{
    private ContactData contactData;
    
    public ContactManager() {
        contactData = getContactData();
    }
    
    // Добавление контакта - возвращает ID добавленного контакта
    public int addContact(Contact contact) {
        return (contactData.addContact(contact));
    }
    
    // Редактирование контакта
    public void updateContact(int contactId, Contact updateContact) {
        contactData.updateContact(contactId, updateContact);
    }

    // Удаление контакта по его ID
    public void deleteContact(int contactId) {
        contactData.deleteContact(contactId);
    }

    // Получение одного контакта
    public Contact getContact(int contactId) {
        return contactData.getContact(contactId);
    }
    
    // Получение списка контактов
    public List<Contact> findContacts() {
        return contactData.findContacts();
    }

    public void writeContact(int contactId) {
        contactData.writeContacts(contactId);
    }
}
