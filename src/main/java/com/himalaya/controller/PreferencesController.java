package com.himalaya.controller;

import com.himalaya.entity.notification.Greeting;
import com.himalaya.entity.shared.io.UserPreferenceDto;
import com.himalaya.service.NotificationService;
import com.himalaya.service.UserPreferenceService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutionException;

@Controller
public class PreferencesController {

    /*This controller is used to receive preference values from user, and persist them
    to database and cache layer for condition check.
    * */

    private final NotificationService notificationService;

    private final UserPreferenceService userPreferenceService;

    public PreferencesController(UserPreferenceService userPreferenceService, NotificationService notificationService) {
        this.userPreferenceService = userPreferenceService;
        this.notificationService = notificationService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(UserPreferenceDto preference) {

        userPreferenceService.savePreferences(preference);

        System.out.println(preference.getName() + ", " + preference.getValue());

        try{
            if (notificationService.checkForConditionFulfilment(preference)) {
                System.out.println(preference.getName() + "  " + preference.getValue());
                return new Greeting("Temperature Changed.");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Number format exception: " +e);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
