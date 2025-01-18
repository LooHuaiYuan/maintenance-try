
package LMS;

import java.util.concurrent.atomic.AtomicInteger;

public class Clerk extends Staff {
  
    int deskNo;     //Desk Number of the Clerk
    
    private static final AtomicInteger currentdeskNumber = new AtomicInteger(0);

    public Clerk(int id, String n, String a, int ph, double s, int dk) {
        super(id, n, a, ph, s);

        if (dk == -1) {
            deskNo = currentdeskNumber.getAndIncrement();
        } else {
        deskNo = dk;
        }
    }
    
    // Printing Clerk's Info
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Desk Number: " + deskNo);
    }
    
}   // Clerk's Class Closed