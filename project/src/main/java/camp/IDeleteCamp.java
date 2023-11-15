package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface IDeleteCamp {
    public boolean deleteCamp(User user, String campName);
}
