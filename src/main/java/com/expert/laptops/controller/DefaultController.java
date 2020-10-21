package com.expert.laptops.controller;

import com.expert.laptops.dto.Laptop;
import com.expert.laptops.service.LaptopEverydayServiceImpl;
import com.expert.laptops.service.LaptopHomeServiceImpl;
import com.expert.laptops.service.LaptopService;
import com.expert.laptops.service.LaptopWorkServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    private static final Logger log = Logger.getLogger(DefaultController.class);

    private final LaptopService lpEveryday;
    private final LaptopService lpHome;
    private final LaptopService lpWork;

    @Autowired
    public DefaultController(LaptopEverydayServiceImpl lp1, LaptopHomeServiceImpl lp2, LaptopWorkServiceImpl lp3) {
        this.lpEveryday = lp1;
        this.lpHome = lp2;
        this.lpWork = lp3;
    }

    @GetMapping(value = "")
    public String produceMainPage(Model model, HttpServletRequest request) {
        log.info("Requested URI " + request.getRequestURI());

        model.addAttribute("laptops", lpEveryday.findAll());

        return "index";
    }

    @GetMapping(value = "", params = {"purpose"})
    public @ResponseBody List<Laptop> produceMainPageWithParam(@RequestParam final Integer purpose) {
        return switch (purpose) {
            case 2 -> lpHome.sortBetter(lpHome.makeMatching());
            case 3 -> lpWork.sortBetter(lpWork.makeMatching());
            case 4 -> lpEveryday.sortBetter(lpEveryday.makeMatching());
            default -> lpHome.sortBetter(lpEveryday.findAll());
        };
    }

    @GetMapping(value = "", params = {"purpose", "params"})
    public @ResponseBody List<Laptop> produceMainPageWithParam(@RequestParam final Integer purpose,
                                                               @RequestParam final Integer[] params) {
        return switch (purpose) {
            case 2 -> lpHome.sortBetter(lpHome.makeMatching(), params);
            case 3 -> lpWork.sortBetter(lpWork.makeMatching(), params);
            case 4 -> lpEveryday.sortBetter(lpEveryday.makeMatching(), params);
            default -> lpHome.sortBetter(lpEveryday.findAll(), params);
        };
    }

}
