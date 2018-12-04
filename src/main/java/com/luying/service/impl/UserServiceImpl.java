package com.luying.service.impl;
import com.luying.dao.IUserDao;
import com.luying.model.Family;
import com.luying.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userService")  
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public List<Family> getFamilies() {
        return userDao.getFamilies();
    }

    @Override
    public List<Map<String, Object>> getFamiliesMap() {
        return userDao.getFamiliesMap();
    }
}
