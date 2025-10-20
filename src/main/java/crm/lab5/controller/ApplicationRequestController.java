package crm.lab5.controller;

import crm.lab5.entity.*;
import crm.lab5.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class ApplicationRequestController {
    private final ApplicationRequestService requestService;
    private final CoursesService coursesService;
    private final OperatorsService operatorsService;

    public ApplicationRequestController(ApplicationRequestService requestService,
                                        CoursesService coursesService,
                                        OperatorsService operatorsService) {
        this.requestService = requestService;
        this.coursesService = coursesService;
        this.operatorsService = operatorsService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("requests", requestService.getAll());
        return "requests/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("request", new ApplicationRequest());
        model.addAttribute("courses", coursesService.getAll());
        return "requests/add";
    }

    @PostMapping("/add")
    public String add(ApplicationRequest request) {
        requestService.save(request);
        return "redirect:/requests";
    }

    @GetMapping("/{id}/assign")
    public String assignForm(@PathVariable Long id, Model model) {
        model.addAttribute("request", requestService.getById(id));
        model.addAttribute("operators", operatorsService.getAll());
        return "requests/assign";
    }

    @PostMapping("/{id}/assign")
    public String assign(@PathVariable Long id, @RequestParam List<Long> operatorIds) {
        ApplicationRequest req = requestService.getById(id);
        List<Operators> selected = operatorsService.getAllByIds(operatorIds);
        req.getOperators().addAll(selected);
        req.setHandled(true);
        requestService.save(req);
        return "redirect:/requests";
    }
}
