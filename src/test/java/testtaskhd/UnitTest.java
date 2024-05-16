package testtaskhd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import taskhd.Task;
import taskhd.Unit;

public class UnitTest {
    private Unit unit;

    @Before
    public void setUp() {
        unit = new Unit("CS101");
    }

    @Test
   public void testGetUnitName() {
        assertEquals("CS101", unit.getUnitName());
    }

    @Test
    public void testAddAndGetTask() {
        Date dueDate = new Date();
        unit.addTask("Assignment1", "Complete the project", dueDate);

        Task task = unit.getTask("Assignment1");
        assertNotNull(task);
        assertEquals("Complete the project", task.getTaskInfo());
        assertEquals(dueDate, task.getDueDate());
    }

    @Test
    public void testGetTaskList() {
        unit.addTask("Assignment1", "Complete the project", new Date());
        unit.addTask("Assignment2", "Prepare presentation", new Date());

        List<String> taskList = unit.getTaskList();
        assertEquals(2, taskList.size());
        assertTrue(taskList.contains("Assignment1"));
        assertTrue(taskList.contains("Assignment2"));
    }
}

