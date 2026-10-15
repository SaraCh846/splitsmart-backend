package com.splitsmart.backend.service;

import com.splitsmart.backend.model.Group;
import com.splitsmart.backend.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }
    public Group createGroup(Group group){
        return groupRepository.save(group);
    }
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }
    public Optional<Group> getGroupId(Integer id){
        return groupRepository.findById(id);
    }
    
}
