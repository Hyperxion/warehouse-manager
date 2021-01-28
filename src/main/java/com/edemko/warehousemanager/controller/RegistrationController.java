package com.edemko.warehousemanager.controller;

import com.edemko.warehousemanager.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    //because we are doing a GET on the registration URL
    @GetMapping("registration")
    //We need to replace basic model (Map<Model, Object> model) with @ModelAttribute. We name this @ModelAttribute so
    //we can reference it in our page. We tie it to actual object (Registration registration). Now we have our object bound by our
    //model to this ModelAttribute
    public String getRegistration(@ModelAttribute ("registration") Registration registration) {
        //this will return registration page /WEB-INF/views/registration.html (suffix and prefix are specified WarehouseManagerConfigClass)
        return "registration";
    }

}
