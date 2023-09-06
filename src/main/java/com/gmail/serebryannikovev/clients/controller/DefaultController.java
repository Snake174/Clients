package com.gmail.serebryannikovev.clients.controller;

import com.gmail.serebryannikovev.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DefaultController {
    private final ClientService clientService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("clients", clientService.getClients());
        return "index";
    }
}
