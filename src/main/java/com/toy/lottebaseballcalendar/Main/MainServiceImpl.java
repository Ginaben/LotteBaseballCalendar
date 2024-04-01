package com.toy.lottebaseballcalendar.Main;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class MainServiceImpl implements MainService {

    @Override
    public List teamMatch() throws Exception {
        List matchStatus = new ArrayList();

        try {
            Document doc = Jsoup.connect("https://sports.news.naver.com/kbaseball/record/index?category=kbo&year=2024")
                    .get();
            Elements match = doc.select("#regularTeamRecordList_table > tr");

            log.info(String.valueOf(match));

            for (Element baseball : match) {

                Map gameMap = new HashMap<>();

                Element rank = baseball.selectFirst("th");
                Element team = baseball.selectFirst("span:nth-child(2)");
                Element game = baseball.selectFirst("td:nth-child(3)"); // 경기 수
                Element win = baseball.selectFirst("td:nth-child(4)"); // 승
                Element defeat = baseball.selectFirst("td:nth-child(5)"); // 패
                Element draw = baseball.selectFirst("td:nth-child(6)"); // 무
                Element rate = baseball.selectFirst("td:nth-child(7)"); // 승률
                Element winning = baseball.selectFirst("td:nth-child(9)"); // 연승
                Element recent = baseball.selectFirst("td:nth-child(12)");

                gameMap.put("rank", rank.text());
                gameMap.put("team", team.text());
                gameMap.put("game", game.text());
                gameMap.put("win", win.text());
                gameMap.put("defeat", defeat.text());
                gameMap.put("draw", draw.text());
                gameMap.put("rate", rate.text());
                gameMap.put("winning", winning.text());
                gameMap.put("recent", recent.text());

                matchStatus.add(gameMap);
            }
            log.info("matchStatus");
            log.info(matchStatus.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchStatus;
    }
}
