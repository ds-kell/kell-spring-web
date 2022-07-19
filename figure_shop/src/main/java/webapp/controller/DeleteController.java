package webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.model.Figure;
import webapp.repository.FigureRepository;

@Controller
@Slf4j
//thuc hien tren trang delete
@RequestMapping("/delete")
public class DeleteController {
//    @Qualifier("jdbcFigureRepository")
    @Autowired
    private FigureRepository repo;

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        System.out.println( "id = " + id);
        Figure figure = repo.getReferenceById(Long.parseLong(id));
        System.out.println(figure.getName());
        model.addAttribute("figure", figure);
        return "delete";
    }
    @PostMapping("/{id}")
    public String delete(@PathVariable String id) {
        try {
            repo.deleteById(Long.parseLong(id));
            System.out.println("deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/view_shop/";
    }
    @PostMapping("/cancel")
    public String cancel(){
        System.out.println("cancel");
        return "redirect:/view_shop/";
    }
}
