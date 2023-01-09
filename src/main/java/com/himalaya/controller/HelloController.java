package com.himalaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String showPage(){
        //whenever this page is called, it should call the LiveService to get data from stub.
        return "main-menu";
    }

    //phase 1
    //todo setup UI part - sorted - not done
    //todo persist data to db and get latest data as well - sorted - not done
    //todo integrate graphql - sorted - not done

    //phase 2
    //todo implement notification service - sorted - not done
    //todo implement notification channels - sorted - not done

    //phase 3
    //todo save user preferences.  - sorted - not done
    //todo write tests - sorted - not done
    //BINGO



}
