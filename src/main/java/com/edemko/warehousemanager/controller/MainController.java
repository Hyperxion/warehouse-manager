package com.edemko.warehousemanager.controller;

import com.edemko.warehousemanager.service.SecurityService;
import com.edemko.warehousemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @GetMapping("/sellOrders")
    public String sellOrders(Model model, String logout) {

        if (securityService.isAuthenticated()) {
            return "sellOrders";
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out.");

        return "login";
    }

    @GetMapping("/buyOrders")
    public String buyOrders(Model model, String logout) {

        if (securityService.isAuthenticated()) {
            return "buyOrders";
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out.");

        return "login";
    }

    @GetMapping("/stock")
    public String stock(Model model, String logout) {

        if (securityService.isAuthenticated()) {
            return "stock";
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out.");

        return "login";
    }

    @GetMapping("/owners")
    public String owners(Model model, String logout) {

        if (securityService.isAuthenticated()) {
            return "owners";
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out.");

        return "login";
    }

    @GetMapping({"/"})
    public String welcome() {
        return "sellOrders";
    }

    @GetMapping("newOwner")
    public String newOwner() {
        return "newOwner_modal";
    }
}
