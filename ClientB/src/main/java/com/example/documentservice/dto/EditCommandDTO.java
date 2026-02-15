package com.example.documentservice.dto;

public class EditCommandDTO {
    private Long requesterId;
    private Long editorId;
    private String editCommand;

    // Constructors
    public EditCommandDTO() {}

    public EditCommandDTO(Long requesterId, Long editorId, String editCommand) {
        this.requesterId = requesterId;
        this.editorId = editorId;
        this.editCommand = editCommand;
    }

    // Getters and Setters
    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }

    public String getEditCommand() {
        return editCommand;
    }

    public void setEditCommand(String editCommand) {
        this.editCommand = editCommand;
    }
}
