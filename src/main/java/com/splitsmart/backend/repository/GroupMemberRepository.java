package com.splitsmart.backend.repository;

import com.splitsmart.backend.model.GroupMember;
import com.splitsmart.backend.model.GroupMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberId> {
    
}