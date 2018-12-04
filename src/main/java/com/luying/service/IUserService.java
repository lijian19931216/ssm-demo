package com.luying.service;

import com.luying.model.Family;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Family> getFamilies();
    List<Map<String,Object>> getFamiliesMap();
}