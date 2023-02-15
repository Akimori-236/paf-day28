package nus.iss.tfip.pafday28.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.iss.tfip.pafday28.service.AppService;

@Controller
@RequestMapping
public class PlaystoreController {

    @Autowired AppService appSvc;

    @GetMapping(path="/category")
    public String sortAppsByCategory(Model model) {
        List<Category> catList = appSvc.sortAppsByCategory();
        model.addAttribute("catList", catList);
    }
}
