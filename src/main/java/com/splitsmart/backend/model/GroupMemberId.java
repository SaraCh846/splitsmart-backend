package com.splitsmart.backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GroupMemberId implements Serializable {

    private Integer userId;
    private Integer groupId;

    public GroupMemberId() {
    }

    public GroupMemberId(Integer userId, Integer groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    @Override // equals() checks whether two composite IDs represent the same key.
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof GroupMemberId)) { // if it is not an instance of  GroupMemberId then it cannot be equal
            return false;
        }

        GroupMemberId that = (GroupMemberId) o;

        return Objects.equals(userId, that.userId)
                && Objects.equals(groupId, that.groupId);
    }
    
    @Override // hashCode() gives equal IDs the same numeric fingerprint.
    public int hashCode() {
        return Objects.hash(userId, groupId);
    }
}