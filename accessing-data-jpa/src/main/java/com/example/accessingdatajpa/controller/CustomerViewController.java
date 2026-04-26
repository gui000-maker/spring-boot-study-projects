package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.dto.CustomerRequest;
import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

    private final CustomerService customerService;

    public CustomerViewController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String ListCustomers (Model model) {
        Iterable<Customer> iterable = customerService.getAll();
        model.addAttribute("iterable", iterable);
        return "/customer/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new CustomerRequest(null, null));
        return "customer/form";
    }

    @PostMapping
    public String createCustomer(
            @Valid @ModelAttribute("customer") CustomerRequest request,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            return "customer/form";
        }

        customerService.create(request);
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String searchById(@RequestParam Long id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }
}
