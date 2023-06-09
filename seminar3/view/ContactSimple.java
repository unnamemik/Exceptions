package seminar3.view;
import seminar3.data.Contact;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ContactSimple implements ContactData
{
    private final List<Contact> contacts = new ArrayList<Contact>();
    
    @Override
    public int addContact(Contact contact) {
        int id = generateContactId();
        contact.setContactId(id);
        contacts.add(contact);
        return id;
    }

    @Override
    public void updateContact(int contactId, Contact updateContact) {
        Contact oldContact = getContact(contactId);
        if(oldContact != null) {
            oldContact.setFirstName(updateContact.getFirstName());
            oldContact.setLastName(updateContact.getLastName());
            oldContact.setFatherName(updateContact.getFatherName());
            oldContact.setDate(updateContact.getDate());
            oldContact.setPhone(updateContact.getPhone());
            oldContact.setSex(updateContact.getSex());
        }
    }

    @Override
    public void deleteContact(int contactId) {
        for(Iterator<Contact> it = contacts.iterator(); it.hasNext();) {
            Contact cnt = it.next();
            if(cnt.getContactId() == contactId) {
                it.remove();
            }
        }
    }

    @Override
    public Contact getContact(int contactId) {
        for(Contact contact : contacts) {
            if(contact.getContactId() == contactId) {
                return contact;
            }
        }
        return null;
    }
    
    @Override
    public List<Contact> findContacts() {
        return contacts;
    }

    @Override
    public void writeContacts(int contactId) {
        Contact contact = getContact(contactId);
        if (contact != null) {
            if (!isFileExists(contact)) {
                try (FileWriter writer = new FileWriter(contact.getFirstName(), false)) {
                    writer.write("");
                    writer.write(String.valueOf(contact));
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println("Ошибка! " + Arrays.toString(ex.getStackTrace()));
                }
            } else {
                try (FileWriter writer = new FileWriter(contact.getFirstName(), true)) {
                    writer.write(String.valueOf(contact));
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println("Ошибка! " + Arrays.toString(ex.getStackTrace()));
                }
            }
        }else {
            System.out.println("Ошибка! Контакт с ID " + contactId +" не найден!");
        }
    }

    public static boolean isFileExists(Contact contact) {
        File file = new File(contact.getFirstName());
        return file.exists();
    }

    private int generateContactId() {
        return (int) Math.round(Math.random()*10000);
    }
}
