package taskhd;
import java.util.*;

public class Unit {
	public String unitName;
	public Map<String, Task> tasks;

    public Unit(String unitName) {
        this.unitName = unitName;
        this.tasks = new HashMap<>();
    }

    public String getUnitName() {
        return unitName;
    }

    public List<String> getTaskList() {
        return new ArrayList<>(tasks.keySet());
    }

    public Task getTask(String taskName) {
        return tasks.get(taskName);
    }

    public void addTask(String taskName, String taskInfo, Date dueDate) {
        tasks.put(taskName, new Task(taskName, taskInfo, dueDate));
    }
}
