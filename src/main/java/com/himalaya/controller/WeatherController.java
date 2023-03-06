package com.himalaya.controller;

import com.himalaya.condition.NotificationCondition;
import com.himalaya.model.notification.Greeting;
import com.himalaya.model.notification.HelloMessage;
import com.himalaya.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/")
    public String showPage(Model model){
        // Whenever this page is called, it should call the LiveService to get data from stub.
         //WeatherDto latestWeather = weatherService.getLatestData();
          model.addAttribute("LatestTemperature", 25.52/* weatherService.getLatestData().temperature()*/);
          model.addAttribute("cityName", "Pune");
        return "main-menu";
    }
}
