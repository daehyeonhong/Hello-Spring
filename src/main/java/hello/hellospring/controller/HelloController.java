package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(final Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping(value = "/hello-mvc")
    public String helloMvc(@RequestParam(value = "name") final String name,
                           final Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
