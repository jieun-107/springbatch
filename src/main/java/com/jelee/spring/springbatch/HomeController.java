package com.jelee.spring.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String getKoreaCovidDatas(Model model) throws IOException {
        List<KoreaStats> list = coronaVirusDataService.getKoreaCovidDatas();
        model.addAttribute("list", list);
        return "hello";
    }
}
