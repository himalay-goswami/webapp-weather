package com.himalaya.dao;

import com.himalaya.entity.UserPref;

public interface UserPreferenceDao {

    void saveUserPreference(UserPref userPreferenceDto);

    UserPref getPreferences();
}
