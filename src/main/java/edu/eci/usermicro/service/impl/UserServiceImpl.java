package edu.eci.usermicro.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.eci.usermicro.entities.User;
import edu.eci.usermicro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private HashMap<String,User> users;
    private final AtomicLong counter = new AtomicLong();
    public UserServiceImpl(){
        users = new HashMap<>();
    }

    @Override
    public User create(User user) {
        return users.put(Long.toString(counter.incrementAndGet()), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);        
    }

    @Override
    public User update(User user, String userId) {
        return users.put(userId, user);
    }
    
}
