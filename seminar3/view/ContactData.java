package seminar3.view;
import seminar3.data.Contact;
import java.util.List;

public interface ContactData
{
    public int addContact(Contact contact);
    public void updateContact(int contactId, Contact updateContact);
    public void deleteContact(int contactId);
    public Contact getContact(int contactId);
    public List<Contact> findContacts();
    public void writeContacts(int contactId);
}
