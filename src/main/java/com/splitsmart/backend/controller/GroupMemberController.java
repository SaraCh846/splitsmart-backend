package com.splitsmart.backend.controller;

import com.splitsmart.backend.model.GroupMember;
import com.splitsmart.backend.service.GroupMemberService;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/groups/{groupId}/members")
public class GroupMemberController {
    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService){
        this.groupMemberService = groupMemberService;
    }

    @PostMapping
    public GroupMember addGroupMember(@RequestBody Integer userid, @PathVariable Integer groupId){
        return groupMemberService.addMember(userid,groupId);
    }

    @GetMapping
    public List<GroupMember> getAllGroupMembers(@PathVariable Integer groupId){
        return groupMemberService.getAllGroupMember(groupId);
    }
}
