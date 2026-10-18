package com.splitsmart.backend.repository;

import com.splitsmart.backend.model.GroupMember;
import com.splitsmart.backend.model.GroupMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberId> {
    List<GroupMember> findByGroup_Id(Integer groupId); // query method
}