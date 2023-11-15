package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface ICheckSchoolMatch {
    public boolean checkSchoolMatch(Student student, String CampName);
}