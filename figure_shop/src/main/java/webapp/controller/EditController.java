package webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapp.model.Figure;
import webapp.repository.FigureRepository;

@Controller
@Slf4j
@RequestMapping("/edit")
public class EditController {
//    @Qualifier("jdbcFigureRepository")
    @Autowired
    FigureRepository repo;

    //hien thi thong tin figure dang sua
    @GetMapping("{id}")
    public String edit(@PathVariable("id") String id, Model model){
        Figure figure = repo.getReferenceById(Long.parseLong(id));
        model.addAttribute(figure);
        return "edit";
    }
    @PostMapping("/{id}")
    public String process_edit(@PathVariable String id, Figure figure) {
        try {
            System.out.println(id);
            System.out.println(figure.getName());
            update(figure, id);
            System.out.println("updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/view_shop/";
    }

//    =================================================================
    private JdbcTemplate jdbc;
    public EditController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public void update(Figure figure, String id) {
        try {
            jdbc.update("update figure set code = ?, name = ?, price = ?, des = ? " +
                            "where id = ?", figure.getCode(), figure.getName(),
                    figure.getPrice(), figure.getDes(), id);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
