package com.himalaya.condition;

import org.springframework.stereotype.Service;

@Service
public class NotificationCondition {

    //now, make this method make a call to weatherService everytime weatherServices saves data.
    public static boolean getCondition(String name, String value){
        return Integer.parseInt(name)>=5 || Integer.parseInt(value)>5;
    }

    public double getLatestData(double temperature){
        return temperature;
    }


}
