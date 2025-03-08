package com.sanchit.Restfull_2.service;

import com.sanchit.Restfull_2.models.UserEnhanced;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserEnhancedService {
    private final Map<String, UserEnhanced> userEnhancedMap = new HashMap<>();

    public UserEnhancedService() {
        userEnhancedMap.put("1", new UserEnhanced("1", "Sanchit ", "Arora", 21, "krishnaPassw"));
        userEnhancedMap.put("2", new UserEnhanced("2", "Akshat ", "Shrivastav", 22, "AkshatPassw"));
        userEnhancedMap.put("3", new UserEnhanced("3", "Kunal ", "Rawat", 23, "KunalPassw"));
        userEnhancedMap.put("4", new UserEnhanced("4", "Sanchit", "Arora", 21, "SanchitPass"));
    }


    public void createUser(UserEnhanced user) {
        userEnhancedMap.put(user.getId(), user);
    }

    public List<UserEnhanced> getUsers() {
        return new ArrayList<>(userEnhancedMap.values());
    }

    public UserEnhanced getUserById(String id) {
        return userEnhancedMap.get(id);
    }

    public void updateUser(String id, UserEnhanced user) {
        userEnhancedMap.put(id, user);
    }

    public void deleteUser(String id) {
        userEnhancedMap.remove(id);
    }
}
