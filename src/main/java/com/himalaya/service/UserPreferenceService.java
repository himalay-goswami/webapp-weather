package com.himalaya.service;

import com.himalaya.dao.UserPreferenceDao;
import com.himalaya.entity.UserPref;
import com.himalaya.entity.shared.io.UserPreferenceDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceService {

    /*
    * this class manages both the cache and dao operations for user preference values. */

    private final CachedService cachedService;

    private final UserPreferenceDao userPreferenceDao;


    public UserPreferenceService(CachedService cachedService, UserPreferenceDao userPreferenceDaoImpl) {
        this.cachedService = cachedService;
        this.userPreferenceDao = userPreferenceDaoImpl;
    }

    public void savePreferences(UserPreferenceDto preference) {

        UserPref userPref = new UserPref();
        BeanUtils.copyProperties(preference, userPref);

        cachedService.savePreferences(userPref);
        userPreferenceDao.saveUserPreference(userPref);
    }

    public UserPreferenceDto getUserPreferenceEntity(String city) {
        UserPreferenceDto userDto = new UserPreferenceDto();
        if(cachedService.getUserPreferenceEntity(city)==null){
            UserPref userPref = userPreferenceDao.getPreferences ();
            BeanUtils.copyProperties(userPref, userDto);
            return userDto;
        }else{
            UserPref userPref = cachedService.getUserPreferenceEntity(city);
            BeanUtils.copyProperties(userPref, userDto);
        }
        return userDto;

    }

}

