package com.himalaya.controller;

import com.himalaya.condition.NotificationCondition;
import com.himalaya.model.notification.Greeting;
import com.himalaya.model.notification.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class PreferencesController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {

        try{
            if (NotificationCondition.getCondition(message.getName(), message.getValue())) {
                System.out.println(Integer.parseInt(message.getName()) + "  " + message.getValue());
                return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName() + "," + message.getValue()));
            }
        }
        catch (NumberFormatException e){
            System.out.println("Number format exception: " +e);
        }
        return null;
    }
}
