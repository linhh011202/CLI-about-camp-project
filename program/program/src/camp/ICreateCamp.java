package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface ICreateCamp {
    public void createCamp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, User user, Faculty openTo);
}
