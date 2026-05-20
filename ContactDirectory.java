import java.util.Scanner;

// Contact Class
class Contact {
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Directory Class
class Directory {
    private Contact[] contacts;
    private int count;

    // Constructor
    public Directory(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    // Add Contact
    public void addContact(String name, String phone) {
        if (count < contacts.length) {
            contacts[count++] = new Contact(name, phone);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Directory is full!");
        }
    }

    // Search Contact
    public void searchContact(String name) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found:");
                System.out.println("Name: " + contacts[i].getName());
                System.out.println("Phone: " + contacts[i].getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Delete Contact
    public void deleteContact(String name) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                count--;
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Display Contacts
    public void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Contact List:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " +
                contacts[i].getName() + " - " +
                contacts[i].getPhoneNumber());
        }
    }
}

// Main Class
public class ContactDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directory directory = new Directory(100);

        int choice;

        do {
            System.out.println("\n--- Contact Directory ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    directory.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();
                    directory.searchContact(searchName);
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();
                    directory.deleteContact(deleteName);
                    break;

                case 4:
                    directory.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}