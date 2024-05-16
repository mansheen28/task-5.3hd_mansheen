package taskhd;

import java.util.*;

public class OnTrack {
	public Map<String, List<Unit>> enrolledUnits;

    public OnTrack() {
        this.enrolledUnits = new HashMap<>();
    }

    // Enroll a student in a unit
    public void enrollUnit(String studentId, String unitName) {
        enrolledUnits.computeIfAbsent(studentId, k -> new ArrayList<>()).add(new Unit(unitName));
    }

    // List all enrolled units for a student
    public List<String> listEnrolledUnits(String studentId) {
        List<Unit> units = enrolledUnits.getOrDefault(studentId, new ArrayList<>());
        List<String> unitNames = new ArrayList<>();
        for (Unit unit : units) {
            unitNames.add(unit.getUnitName());
        }
        return unitNames;
    }

    // List all tasks for a given unit
    public List<String> listTasks(String studentId, String unitName) {
        Unit unit = getUnit(studentId, unitName);
        if (unit != null) {
            return unit.getTaskList();
        }
        return new ArrayList<>();
    }

    // Get task information
    public String getTaskInformation(String studentId, String unitName, String taskName) {
        Task task = getTask(studentId, unitName, taskName);
        if (task != null) {
            return "Task Info: " + task.getTaskInfo() + ", Due Date: " + task.getDueDate() + ", Status: " + task.getStatus();
        }
        return "Task not found";
    }

    // Chat with professor
    public void chatWithProfessor(String studentId, String unitName, String taskName, String message) {
        Task task = getTask(studentId, unitName, taskName);
        if (task != null) {
            task.addChatMessage(message);
        }
    }

    // Update task status
    public void updateTaskStatus(String studentId, String unitName, String taskName, String status) {
        Task task = getTask(studentId, unitName, taskName);
        if (task != null) {
            task.updateStatus(status);
        }
    }

    // Make a submission
    public void makeSubmission(String studentId, String unitName, String taskName, String submission) {
        Task task = getTask(studentId, unitName, taskName);
        if (task != null) {
            task.addSubmission(submission);
        }
    }

    // Request an extension
    public void requestExtension(String studentId, String unitName, String taskName, Date newDueDate) {
        Task task = getTask(studentId, unitName, taskName);
        if (task != null) {
            task.requestExtension(newDueDate);
        }
    }

    // Helper method to get a unit
    public Unit getUnit(String studentId, String unitName) {
        List<Unit> units = enrolledUnits.get(studentId);
        if (units != null) {
            for (Unit unit : units) {
                if (unit.getUnitName().equals(unitName)) {
                    return unit;
                }
            }
        }
        return null;
    }

    // Helper method to get a task
    public Task getTask(String studentId, String unitName, String taskName) {
        Unit unit = getUnit(studentId, unitName);
        if (unit != null) {
            return unit.getTask(taskName);
        }
        return null;
    }

    
}

