package com.himalaya.pref;

import com.himalaya.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

@Service
public class UserPreferences {

    @Autowired
    private WeatherService weatherService;

    public void setPreferences() throws IOException, BackingStoreException {

        Double temperature = weatherService.getLatestData().temperature();

        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        String ID_MIN = "Pune_MIN";
        String ID_MAX = "Pune_MAX";

        preferences.putDouble(ID_MIN, 12);
        preferences.putDouble(ID_MAX, 35.53);
        preferences.exportNode(new FileOutputStream("pref.xml"));

        preferences.get("Pune", String.valueOf(temperature));
    }

    public static void main(String[] args) throws BackingStoreException, IOException {
            UserPreferences preferences = new UserPreferences();
            preferences.setPreferences();

    }
}
