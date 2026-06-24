// Nick Williams
// Southern New Hampshire University
// CS 320

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a contact with a unique ID
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact is null or ID already exists");
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by contact ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact ID not found");
        contacts.remove(contactId);
    }

    // Update firstName by contact ID
    public void updateFirstName(String contactId, String firstName) {
        getContactOrThrow(contactId).setFirstName(firstName);
    }

    // Update lastName by contact ID
    public void updateLastName(String contactId, String lastName) {
        getContactOrThrow(contactId).setLastName(lastName);
    }

    // Update phone by contact ID
    public void updatePhone(String contactId, String phone) {
        getContactOrThrow(contactId).setPhone(phone);
    }

    // Update address by contact ID
    public void updateAddress(String contactId, String address) {
        getContactOrThrow(contactId).setAddress(address);
    }

    // Get a contact by contact ID
    public Contact getContact(String contactId) {
        return getContactOrThrow(contactId);
    }

    // Helper method to retrieve contact or throw if not found
    private Contact getContactOrThrow(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null)
            throw new IllegalArgumentException("Contact ID not found");
        return c;
    }
}