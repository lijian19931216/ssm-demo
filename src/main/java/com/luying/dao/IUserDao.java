package com.luying.dao;

import com.luying.model.Family;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<Family> getFamilies();
    List<Map<String,Object>> getFamiliesMap();

}