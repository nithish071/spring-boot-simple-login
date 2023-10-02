package com.nithi.controller;

import com.nithi.model.CustomerLogin;
import com.nithi.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bank")
public class CustomerLoginController {

    @Autowired
    private CustomerLoginService customerLoginService;
    @GetMapping(value = "/login")
    public ModelAndView authenticateCustomer(@RequestParam String name, @RequestParam String password) throws Exception {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName(name);
        customerLogin.setPassword(password);

        String b = customerLoginService.authenticateCustomer(customerLogin);
        if (b.equals("Success")) {
            ModelAndView modelAndView = new ModelAndView("welcome");
            modelAndView.addObject("username", name);
            return modelAndView;
        } else
            return new ModelAndView("error");
    }
}
