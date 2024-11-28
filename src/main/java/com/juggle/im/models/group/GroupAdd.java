package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * 添加群 传参对象
 *
 * @date 2024-11-28
 */
public class GroupAdd {

    /**
     * 群id
     */
    @SerializedName("group_id")
    private String groupId;

    /**
     * 群名称
     */
    @SerializedName("group_name")
    private String groupName;

    /**
     * 群头像
     */
    @SerializedName("group_portrait")
    private String groupPortrait;

    /**
     * 其他配置
     */
    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    /**
     * 群成员id集合
     */
    @SerializedName("member_ids")
    private List<String> memberIds;

    public GroupAdd() {
    }

    public String getGroupId() {
        return groupId;
    }

    public GroupAdd setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public GroupAdd setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupPortrait() {
        return groupPortrait;
    }

    public GroupAdd setGroupPortrait(String groupPortrait) {
        this.groupPortrait = groupPortrait;
        return this;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public GroupAdd setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
        return this;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public GroupAdd setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
        return this;
    }

    @Override
    public String toString() {
        return "GroupAdd{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupPortrait='" + groupPortrait + '\'' +
                ", extFields=" + extFields +
                ", memberIds=" + memberIds +
                '}';
    }

}
