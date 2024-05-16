package testtaskhd;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import taskhd.Task;

public class TaskTest {
public Task task;

    @Before
    public void setUp() {
        task = new Task("Assignment1", "Complete the project", new Date());
    }

    @Test
    public void testGetTaskInfo() {
        assertEquals("Complete the project", task.getTaskInfo());
    }

    @Test
    public void testGetDueDate() {
        assertNotNull(task.getDueDate());
    }

    @Test
    public void testAddAndGetChatMessages() {
        task.addChatMessage("I need help with this assignment.");
        task.addChatMessage("Can you provide more details?");

        assertEquals(2, task.getChatMessages().size());
        assertEquals("I need help with this assignment.", task.getChatMessages().get(0));
        assertEquals("Can you provide more details?", task.getChatMessages().get(1));
    }

    @Test
    public void testUpdateStatus() {
        task.updateStatus("In Progress");
        assertEquals("In Progress", task.getStatus());
    }

    @Test
    public void testAddAndGetSubmissions() {
        task.addSubmission("Here is my project submission.");
        assertEquals(1, task.getSubmissions().size());
        assertEquals("Here is my project submission.", task.getSubmissions().get(0));
    }

    @Test
    public void testRequestExtension() {
        Date newDueDate = new Date();
        task.requestExtension(newDueDate);
        assertEquals(newDueDate, task.getExtensionRequest());
    }
}

