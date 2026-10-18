package com.splitsmart.backend.controller;

import java.util.Optional;
import java.util.List;

import com.splitsmart.backend.model.Group;
import com.splitsmart.backend.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController 
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }
    
    @GetMapping 
    public List<Group> getAllGroup(){
        return groupService.getAllGroups();
    }
    
    @GetMapping("/{id}")
    public Optional<Group> getGroupId(@PathVariable Integer id){
        return groupService.getGroupId(id);
    }

    @PostMapping 
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }
}
