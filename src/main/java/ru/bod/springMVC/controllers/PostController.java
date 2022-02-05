package ru.bod.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bod.springMVC.DAO.UserDAO;
import ru.bod.springMVC.models.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {
    private final UserDAO userDAO;

    public PostController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @PostMapping()
    public String sdd_user(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "post/sing_up";
        }
        userDAO.save(user);
        int id = UserDAO.PEOPLE_COUNT;
        return "redirect:/post/"+id;
    }
    @GetMapping("/users")

    public String users(Model model){
        model.addAttribute("users_all",userDAO.index());

        return "post/index";

    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("user",userDAO.show(id));
        return "post/show";
    }
    @GetMapping("/register")
    public String reg(@ModelAttribute("user") User user){
        return "post/sing_up";
    }
    @GetMapping("/{id}/edit")
    public  String edit_user(Model model,@PathVariable("id") int id){
        model.addAttribute("user",userDAO.show(id));
        return "post/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,@PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "post/edit";
        } else {
            userDAO.update(id, user);
            return "redirect:/post/" + id;
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")  int id){
        userDAO.delete(id);
        return "redirect:/post/users";
    }
}
