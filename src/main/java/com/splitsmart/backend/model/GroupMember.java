package com.splitsmart.backend.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity 
@Table(name = "group_members")
public class GroupMember {
    
    @EmbeddedId 
    private GroupMemberId id;

    @ManyToOne
    @MapsId("userId") // This tells the JPA that FK is also part of the composite PK
    @JoinColumn(name = "user_id", nullable = false)// This tells the JPA which database column is the FK to User
    private User user; 

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public GroupMember() {
    }

    public GroupMember(User user, Group group) {
        this.user = user;
        this.group = group;
        this.id = new GroupMemberId(user.getId(), group.getId());
    }

    public GroupMemberId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }
}
