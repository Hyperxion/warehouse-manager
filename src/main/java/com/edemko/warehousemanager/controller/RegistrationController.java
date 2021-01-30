package com.edemko.warehousemanager.controller;

import com.edemko.warehousemanager.model.Registration;
import com.edemko.warehousemanager.model.User;
import com.edemko.warehousemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    //because we are doing a GET on the registration URL
    @GetMapping("/registration")
    //We need to replace basic model (Map<Model, Object> model) with @ModelAttribute. We name this @ModelAttribute so
    //we can reference it in our page. We tie it to actual object (Registration registration). Now we have our object bound by our
    //model to this ModelAttribute
    public String getRegistration(@ModelAttribute ("registration") Registration registration) {
        //this will return registration page /WEB-INF/views/registration.html (suffix and prefix are specified WarehouseManagerConfigClass)
        return "registration";
    }

    @PostMapping("/registration")
    public String saveEmployee(@Valid @ModelAttribute ("registration") Registration registration, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println("An error occurred.");
            return "registration";
        } else if(registration.getPasswordVerified().equals(registration.getPassword())) {
            System.out.println(user.toString() + " successfully created!");
            user.setPassword(registration.getPassword());
            // save user to database
            userService.saveUser(this.user);
        }
        return "redirect:/";
    }
}
