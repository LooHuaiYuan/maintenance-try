
package LMS;

import static LMS.Library.librarian;
import static LMS.Library.persons;
import java.util.concurrent.atomic.AtomicInteger;

public class Librarian extends Staff {

    int officeNo;     //Office Number of the Librarian
    
    // Use AtomicInteger for thread-safe increment
    private static final AtomicInteger currentOfficeNumber = 
        new AtomicInteger(0);

    public Librarian(int id, String n, String a, int p, double s, int of) {
        super(id, n, a, p, s);

        if (of == -1)
            officeNo = currentOfficeNumber.getAndIncrement();
        else
            officeNo = of;
    }


    // Printing Librarian's Info
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Office Number: " + officeNo);
    }

    public static boolean addLibrarian(Librarian lib) {
        //One Library can have only one Librarian
        if (librarian == null) {
            librarian = lib;
            persons.add(librarian);
            return true;
        } else
            System.out.println("\nSorry, the library already has one librarian. New Librarian can't be created.");
        return false;
    }
}