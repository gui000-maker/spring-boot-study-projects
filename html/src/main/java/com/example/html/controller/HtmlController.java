package com.example.html.controller;

import com.example.html.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {

    @GetMapping("/print")
    public String hello(Model model) {
        model.addAttribute("name", "John");
        return "print";
    }

    @GetMapping("/numbers")
    public String numbers(Model model) {

        List<Integer> numbers = List.of(1,2,3,4,5);

        model.addAttribute("numbers", numbers);
        return "numbers";
    }

    @GetMapping("/customers/test")
    public String testCustomers(Model model) {

        List<Customer> customers = List.of(
                new Customer("John","Doe"),
                new Customer("Anna","Smith")
        );

        model.addAttribute("customers", customers);

        return "customers-test";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("customer", new CustomerRequest(null,null));
        return "form";
    }

    @PostMapping("/form")
    public String submit(@ModelAttribute CustomerRequest request) {

        System.out.println(request.firstName());
        System.out.println(request.lastName());

        return "redirect:/form";
    }
}
