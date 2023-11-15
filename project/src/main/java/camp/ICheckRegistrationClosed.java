package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public interface ICheckRegistrationClosed {
    public boolean isRegistrationClosed(String campName);
}