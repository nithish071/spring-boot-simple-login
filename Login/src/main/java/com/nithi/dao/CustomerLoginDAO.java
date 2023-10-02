package com.nithi.dao;

import com.nithi.model.CustomerLogin;

public interface CustomerLoginDAO {
    public CustomerLogin getCustomerLoginByLoginName(String loginName);
}
