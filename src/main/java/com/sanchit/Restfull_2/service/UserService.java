package com.sanchit.Restfull_2.service;

import com.sanchit.Restfull_2.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("1", new User("1", "Sanchit Arora", 21, "krishnaPassw"));
        userMap.put("2", new User("2", "Akshat Shrivastav", 22, "AkshatPassw"));
        userMap.put("3", new User("3", "Kunal Rawat", 23, "KunalPassw"));
        userMap.put("4", new User("4", "Sanchit Arora", 21, "SanchitPass"));
    }
    //public UserService(){
    //    userMap.put("1",new User("1","Krishna Sharma",21));
    //    userMap.put("2",new User("2","Akshat Shrivastav",22));
    //    userMap.put("3",new User("3","Kunal Rawat",23));
    //    userMap.put("4",new User("4","Sanchit Arora",21));
    //}

    public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }

    public void updateUser(String id, User user) {
        userMap.put(id, user);
    }

    public void deleteUser(String id) {
        userMap.remove(id);
    }
}
