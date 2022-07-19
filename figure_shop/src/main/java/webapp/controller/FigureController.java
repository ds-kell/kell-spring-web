package webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.model.Figure;
import webapp.repository.FigureRepository;

import java.util.List;

@Controller
@Slf4j
public class FigureController {

    @Autowired
    FigureRepository repo;
    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/view_shop")
    public String viewFigure(Model model){
        List<Figure> figureList = repo.findAll();
        model.addAttribute(figureList);
        return "view_shop";
    }

    @GetMapping("/add_successfully")
    public String add_successfully(){
        return "add_successfully";
    }
    @GetMapping("/add")
    public String add(Model model){
        Figure figure = new Figure();
        model.addAttribute("figure",figure);
        return "add";
    }
//    @RequestMapping("/edit")
//    @GetMapping("{id}")
//    public String edit(@PathVariable("id") String id, Model model){
//        Figure figure = repo.getReferenceById(Long.parseLong(id));
//        model.addAttribute(figure);
//        return "edit";
//    }
    @PostMapping("/process_add")
    public String process_add(Figure figure){
        repo.save(figure);
        return "add_successfully";
    }
// thử tạo trang confirm add
}
