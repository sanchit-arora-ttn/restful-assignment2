package com.sanchit.Restfull_2.service;

import com.sanchit.Restfull_2.models.UserDynamicFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDynamicFilterService {
    private final Map<String, UserDynamicFilter> userMap = new HashMap<>();

    public UserDynamicFilterService() {
        userMap.put("1", new UserDynamicFilter(1,"Sanchit Arora","KrishnaPassw"));
        userMap.put("2", new UserDynamicFilter(2, "Akshat Shrivastav", "AkshatPassw"));
        userMap.put("3", new UserDynamicFilter(3, "Kunal Rawat", "KunalPassw"));
        userMap.put("4", new UserDynamicFilter(4, "Sanchit Arora",  "SanchitPass"));
    }
    public List<UserDynamicFilter> getUsers() {
        return new ArrayList<>(userMap.values());
    }
}
