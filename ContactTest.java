// Nick Williams
// Southern New Hampshire University
// CS 320

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test that a valid contact is created with correct field values

    @Test
    public void testValidContact() {
        Contact c = new Contact("1234567890", "John", "Doe", "5551234567", "123 Elm St");
        assertEquals("1234567890", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("5551234567", c.getPhone());
        assertEquals("123 Elm St", c.getAddress());
    }

    // Test if exception is thrown on null contact ID input

    @Test
    public void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "John", "Doe", "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown on too long contact ID

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown on null first name input

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", null, "Doe", "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown if first name is too long

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "Jooooooooooooooohn", "Doe", "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown on null last name input

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", null, "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown if last name is too long

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doooooooooooe", "5551234567", "123 Elm St"));
    }

    // Test if exception is thrown if phone number is null

    @Test
    public void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", null, "123 Elm St"));
    }

    // Test if exception is thrown if phone number is too short

    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", "123", "123 Elm St"));
    }

    // Test if exception is thrown if phone number contains non-digit characters

    @Test
    public void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", "55512345ab", "123 Elm St"));
    }

    // Test if exception is thrown if address is null

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", "5551234567", null));
    }

    // Test if exception is thrown if address is too long

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", "5551234567", "1234567890123456789012345678901"));
    }

    // Test that contact ID remains unchanged after creation (field is final, no setter exists)

    @Test
    public void testContactIdUnchanged() {
        Contact c = new Contact("ABC", "John", "Doe", "5551234567", "123 Elm St");
        assertEquals("ABC", c.getContactId());
    }

    // Test that first name can be updated to a valid value via setter

    @Test
    public void testSetFirstName() {
        Contact c = new Contact("123", "John", "Doe", "5551234567", "123 Elm St");
        c.setFirstName("Jane");
        assertEquals("Jane", c.getFirstName());
    }

    // Test if exception is thrown if last name setter receives null

    @Test
    public void testSetLastNameNull() {
        Contact c = new Contact("123", "John", "Doe", "5551234567", "123 Elm St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
    }

    // Test if exception is thrown if phone setter receives an invalid value

    @Test
    public void testSetPhoneInvalid() {
        Contact c = new Contact("123", "John", "Doe", "5551234567", "123 Elm St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("badphone"));
    }

    // Test if exception is thrown if address setter receives a value that is too long

    @Test
    public void testSetAddressTooLong() {
        Contact c = new Contact("123", "John", "Doe", "5551234567", "123 Elm St");
        assertThrows(IllegalArgumentException.class, () ->
            c.setAddress("1234567890123456789012345678901"));
    }
}