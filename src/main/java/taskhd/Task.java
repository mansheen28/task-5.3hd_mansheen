package taskhd;

import java.util.*;

public class Task {
    public String taskName;
    public String taskInfo;
    public Date dueDate;
    public List<String> submissions;
    public List<String> chatMessages;
    public String status;
    public Date extensionRequest;

    public Task(String taskName, String taskInfo, Date dueDate) {
        this.taskName = taskName;
        this.taskInfo = taskInfo;
        this.dueDate = dueDate;
        this.submissions = new ArrayList<>();
        this.chatMessages = new ArrayList<>();
        this.status = "Not Started";
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public List<String> getSubmissions() {
        return submissions;
    }

    public List<String> getChatMessages() {
        return chatMessages;
    }

    public String getStatus() {
        return status;
    }

    public Date getExtensionRequest() {
        return extensionRequest;
    }

    public void addChatMessage(String message) {
        chatMessages.add(message);
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void addSubmission(String submission) {
        submissions.add(submission);
    }

    public void requestExtension(Date newDueDate) {
        this.extensionRequest = newDueDate;
    }
}
