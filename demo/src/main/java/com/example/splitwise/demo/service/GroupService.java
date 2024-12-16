package com.example.splitwise.demo.service;

import com.example.splitwise.demo.models.Group;
import com.example.splitwise.demo.models.User;
import com.example.splitwise.demo.repo.GroupRepository;
import com.example.splitwise.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository  = groupRepository;
        this.userRepository = userRepository;
    }

   public Group createGroup(String name, List<Integer> userlist) {
        Group group = new Group();
        group.setName(name);
        List<User> userList  = userRepository.findAllById(userlist);
        group.setUsersList(userList);
       groupRepository.save(group);
        return group;
    }
    public List<Group> getAllGroups(){
       return groupRepository.findAll();
    }
}
