package com.nithi.service;

import com.nithi.model.CustomerLogin;

public interface CustomerLoginService {
    public String authenticateCustomer(CustomerLogin customerLogin);
}
