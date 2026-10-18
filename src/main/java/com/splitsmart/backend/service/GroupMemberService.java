package com.splitsmart.backend.service;

import com.splitsmart.backend.model.User;
import com.splitsmart.backend.model.Group;
import com.splitsmart.backend.model.GroupMember;

import com.splitsmart.backend.repository.UserRepository;
import com.splitsmart.backend.repository.GroupRepository;
import com.splitsmart.backend.repository.GroupMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupMemberService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    public GroupMemberService(UserRepository userRepository, GroupRepository groupRepository, GroupMemberRepository groupMemberRepository){
        this.userRepository = userRepository;
        this.groupRepository=groupRepository;
        this.groupMemberRepository = groupMemberRepository;
    }
    public GroupMember addMember(Integer userid, Integer groupid){
       Optional<User> person = userRepository.findById(userid);
       Optional<Group> group1 = groupRepository.findById(groupid);
       if(person.isEmpty()){
          throw new IllegalArgumentException("User does not exist.");
       }
       if(group1.isEmpty()){
          throw new IllegalArgumentException("Group does not exist.");
       }
       GroupMember groupMember = new GroupMember(person.get(), group1.get());
       return groupMemberRepository.save(groupMember);
    }
    public List<GroupMember> getAllGroupMember(Integer id) {
       return groupMemberRepository.findByGroup_Id(id);
    }
}
