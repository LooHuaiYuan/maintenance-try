package LMS;

import java.util.ArrayList;

public class HoldRequestOperations {

    static ArrayList<HoldRequest> holdRequests;

    public HoldRequestOperations() {
        initializeHoldRequests();
    }
    
    // Thread-safe lazy initialization in a static method
    private static synchronized void initializeHoldRequests() {
        if (holdRequests == null) {
            holdRequests = new ArrayList<>();
        }
    }

    // adding a hold req.
    public void addHoldRequest(HoldRequest hr)
    {
        holdRequests.add(hr);
    }

    // removing a hold req.
    public void removeHoldRequest()
    {
        if(!holdRequests.isEmpty())
        {
            holdRequests.remove(0);
        }
    }
}
