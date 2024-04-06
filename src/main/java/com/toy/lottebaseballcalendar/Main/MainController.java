package com.toy.lottebaseballcalendar.Main;

import org.springframework.ui.Model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@NoArgsConstructor
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String getMatchList(Model model) throws Exception {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String today = currentDate.format(formatter);
        model.addAttribute("today", today);

        List matchList = mainService.teamMatch();
        model.addAttribute("matchList", matchList);

        return "index";
    }
}
