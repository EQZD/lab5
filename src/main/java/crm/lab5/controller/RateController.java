package crm.lab5.controller;

import crm.lab5.entity.Rate;
import crm.lab5.service.CoursesService;
import crm.lab5.service.RateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rates")
public class RateController {
    private final RateService rateService;
    private final CoursesService coursesService;

    public RateController(RateService rateService, CoursesService coursesService) {
        this.rateService = rateService;
        this.coursesService = coursesService;
    }

    @GetMapping
    public String listRates(Model model) {
        model.addAttribute("rates", rateService.findAll());
        return "rates/list";
    }

    @GetMapping("/add")
    public String addRateForm(Model model) {
        model.addAttribute("rate", new Rate());
        model.addAttribute("courses", coursesService.getAll());
        return "rates/add";
    }

    @PostMapping("/add")
    public String saveRate(@ModelAttribute Rate rate) {
        rateService.save(rate);
        return "redirect:/rates";
    }

    @GetMapping("/delete/{id}")
    public String deleteRate(@PathVariable Long id) {
        rateService.delete(id);
        return "redirect:/rates";
    }
}

