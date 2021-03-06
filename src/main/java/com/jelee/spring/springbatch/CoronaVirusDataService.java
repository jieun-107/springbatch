package com.jelee.spring.springbatch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {
    private static String KOREA_COVID_DATAS_URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13";

    @PostConstruct
    public List<KoreaStats> getKoreaCovidDatas() throws IOException {
        Document doc = Jsoup.connect(KOREA_COVID_DATAS_URL).get();
        Elements contents = doc.select("table tbody tr");

        List<KoreaStats> statsList = new ArrayList<KoreaStats>();
        for(Element content : contents){
            Elements tdContents = content.select("td");

            KoreaStats stats = KoreaStats.builder()
                    .country(content.select("th").text())
                    .diffFromPrevDay(Integer.parseInt(tdContents.get(0).text()))
                    .total(Integer.parseInt(tdContents.get(1).text().replace(",", "")))
                    .death(Integer.parseInt(tdContents.get(2).text().replace(",", "")))
                    .incidence(Integer.parseInt(tdContents.get(3).text().replace(",", "")))
                    .inspection(Integer.parseInt(tdContents.get(4).text().replace(",", "")))
                    .build();

            statsList.add(stats);
        }

        return statsList;
    }


}
