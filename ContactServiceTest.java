// Nick Williams
// Southern New Hampshire University
// CS 320

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    // Set up a new instance of ContactService and add a test contact before each test

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("001", "John", "Doe", "5551234567", "123 Elm St");
        service.addContact(contact);
    }

    // Test adding a contact and verifying it can be retrieved by ID

    @Test
    public void testAddContact() {
        Contact c2 = new Contact("002", "Jane", "Doe", "5559876543", "456 Elm St");
        service.addContact(c2);
        assertEquals("Jane", service.getContact("002").getFirstName());
    }

    // Test if an exception is thrown if a contact ID is a duplicate

    @Test
    public void testAddDuplicateIdThrows() {
        Contact dup = new Contact("001", "Jane", "Smith", "5559876543", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(dup));
    }

    // Test if an exception is thrown for a null contact

    @Test
    public void testAddNullContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // Test that a contact is successfully removed from the service by contact ID

    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("001"));
    }

    // Test if an exception is thrown when trying to delete a contact ID that does not exist

    @Test
    public void testDeleteNonExistentThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    // Test that first name is successfully updated for an existing contact

    @Test
    public void testUpdateFirstName() {
        service.updateFirstName("001", "Jane");
        assertEquals("Jane", service.getContact("001").getFirstName());
    }

    // Test if an exception is thrown if updated first name is null

    @Test
    public void testUpdateFirstNameInvalidThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("001", null));
    }

    // Test that last name is successfully updated for an existing contact

    @Test
    public void testUpdateLastName() {
        service.updateLastName("001", "Smith");
        assertEquals("Smith", service.getContact("001").getLastName());
    }

    // Test if an exception is thrown if updated last name is too long

    @Test
    public void testUpdateLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("001", "SmithSmithSmith"));
    }

    // Test that phone number is successfully updated for an existing contact

    @Test
    public void testUpdatePhone() {
        service.updatePhone("001", "9998887777");
        assertEquals("9998887777", service.getContact("001").getPhone());
    }

    // Test if an exception is thrown if updated phone number is invalid

    @Test
    public void testUpdatePhoneInvalidThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("001", "123"));
    }

    // Test that address is successfully updated for an existing contact

    @Test
    public void testUpdateAddress() {
        service.updateAddress("001", "789 Oak Ave");
        assertEquals("789 Oak Ave", service.getContact("001").getAddress());
    }

    // Test if an exception is thrown if updated address is too long

    @Test
    public void testUpdateAddressTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("001", "1234567890123456789012345678901"));
    }

    // Test if an exception is thrown when trying to update a contact that does not exist

    @Test
    public void testUpdateNonExistentContactThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("999", "Ghost"));
    }
}