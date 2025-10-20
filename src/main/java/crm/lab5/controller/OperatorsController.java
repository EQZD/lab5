package crm.lab5.controller;

import crm.lab5.entity.Operators;
import crm.lab5.service.OperatorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operators")
public class OperatorsController {

    private final OperatorsService operatorsService;

    public OperatorsController(OperatorsService operatorsService) {
        this.operatorsService = operatorsService;
    }

    @GetMapping
    public String listOperators(Model model) {
        model.addAttribute("operators", operatorsService.getAll());
        return "operators/list";
    }

    @GetMapping("/add")
    public String addOperatorForm(Model model) {
        model.addAttribute("operator", new Operators());
        return "operators/add";
    }

    @PostMapping("/add")
    public String addOperator(@ModelAttribute("operator") Operators operator) {
        operatorsService.save(operator);
        return "redirect:/operators";
    }

    @GetMapping("/delete/{id}")
    public String deleteOperator(@PathVariable Long id) {
        operatorsService.delete(id);
        return "redirect:/operators";
    }
}
