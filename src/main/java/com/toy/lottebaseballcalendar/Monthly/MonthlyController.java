package com.toy.lottebaseballcalendar.Monthly;


import ch.qos.logback.core.model.Model;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class MonthlyController {


    @GetMapping("/monthly")
    public String getMatchCalendar(Model model) throws Exception {


        return "/monthly";
    }
}
