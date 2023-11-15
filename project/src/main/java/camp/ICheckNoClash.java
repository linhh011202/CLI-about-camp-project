package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public interface ICheckNoClash {
    public boolean checkNoClash(ArrayList<String> campsRegistered, String campToRegister);
}