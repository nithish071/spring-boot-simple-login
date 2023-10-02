package com.nithi.service;

import com.nithi.dao.CustomerLoginDAO;
import com.nithi.model.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
    @Autowired
    private CustomerLoginDAO customerLoginDao;
    public String authenticateCustomer(CustomerLogin customerLogin){
        String toRet = null;
        CustomerLogin customerLoginFromDao = customerLoginDao.getCustomerLoginByLoginName(customerLogin.getLoginName());
        if (customerLogin.getPassword().equals(customerLoginFromDao.getPassword())) {
            toRet = "Success";
        } else {
            toRet = "Failed";
        }
        return toRet;
    }
}
