package com.toy.lottebaseballcalendar.Main;

import org.springframework.ui.Model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@NoArgsConstructor
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String getMatchList(Model model) throws Exception {

        List matchList = mainService.teamMatch();
        model.addAttribute("matchList", matchList);

        return "index";
    }
}
