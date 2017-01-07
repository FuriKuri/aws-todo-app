package net.furikuri.controller;

import net.furikuri.domain.Todo;
import net.furikuri.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

  @Autowired
  private TodoService todoService;

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("todos", todoService.all());
    model.addAttribute("todo", new Todo());
    return "index";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String addTodo(@ModelAttribute Todo todo) {
    todoService.add(todo);
    return "redirect:/";
  }
}
