package com.himalaya.controller;

import com.himalaya.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/")
    public String showPage(Model model){

          model.addAttribute("LatestTemperature", weatherService.getLatestCachedData().getTemperature());
          model.addAttribute("cityName", "Pune");
        return "main-menu";
    }
}
