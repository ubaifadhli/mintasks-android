package com.ubaifadhli.mintasks.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("due_date")
    @Expose
    private String dueDate;
    @SerializedName("owner_id")
    @Expose
    private String ownerId;
    @SerializedName("is_owner_checked")
    @Expose
    private Boolean isOwnerChecked;
    @SerializedName("collaborator_id")
    @Expose
    private String collaboratorId;
    @SerializedName("is_collaborator_checked")
    @Expose
    private Boolean isCollaboratorChecked;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("_id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getIsOwnerChecked() {
        return isOwnerChecked;
    }

    public void setIsOwnerChecked(Boolean isOwnerChecked) {
        this.isOwnerChecked = isOwnerChecked;
    }

    public String getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(String collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public Boolean getIsCollaboratorChecked() {
        return isCollaboratorChecked;
    }

    public void setIsCollaboratorChecked(Boolean iscollaboratorChecked) {
        this.isCollaboratorChecked = iscollaboratorChecked;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
