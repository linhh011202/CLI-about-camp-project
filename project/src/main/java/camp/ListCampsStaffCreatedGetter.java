package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

public class ListCampsStaffCreatedGetter implements IGetCampsCreated {
    private CampDataBase campDataBase;

    public ListCampsStaffCreatedGetter(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public ArrayList<String> getListCampStaffCreated(String staffName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();
        ArrayList<String> campsStaffCreated = new ArrayList<String>(0);

        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getStaffInCharge().equals(staffName)) {
                campsStaffCreated.add(allCamps.get(i).getCampName());
            }
        }
        return campsStaffCreated;
    }

}
