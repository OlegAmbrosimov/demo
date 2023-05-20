package my.web.app.demo.controllers;

import my.web.app.demo.models.Good;
import my.web.app.demo.repo.IGoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoodController {
    @Autowired
    private IGoodRepository goodRepository;
    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @GetMapping("/goods")
    public String showGoods(Model model) {
        Iterable<Good> goods = goodRepository.findAll();
        model.addAttribute("goods", goods);
        return "goods";

    }

    @PostMapping("/good/add")
    public String getGood(@RequestParam String name,
                          @RequestParam String info,
                          @RequestParam int price,
                          Model model) {
        Good good = new Good(name, info, price);
        goodRepository.save(good);
        return "redirect:/goods";
    }
@GetMapping("/good/{id}")
    public String showCard(@PathVariable(value = "id")long id, Model model){
var good = goodRepository.findById(id).get();
model.addAttribute("good", good);
return "card";
}
}