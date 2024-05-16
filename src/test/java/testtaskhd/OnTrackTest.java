package testtaskhd;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import taskhd.OnTrack;
import taskhd.Task;
import taskhd.Unit;

public class OnTrackTest {
    private OnTrack onTrack;

    @Before
    public void setUp() {
        onTrack = new OnTrack();
    }

    @Test
    public void testEnrollUnit() {
        onTrack.enrollUnit("student1", "CS101");
        List<String> units = onTrack.listEnrolledUnits("student1");
        assertEquals(1, units.size());
        assertTrue(units.contains("CS101"));
    }

    @Test
    public void testListEnrolledUnits() {
        onTrack.enrollUnit("student1", "CS101");
        onTrack.enrollUnit("student1", "CS102");

        List<String> units = onTrack.listEnrolledUnits("student1");
        assertEquals(2, units.size());
        assertTrue(units.contains("CS101"));
        assertTrue(units.contains("CS102"));
    }

    @Test
    public void testListTasks() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        List<String> tasks = onTrack.listTasks("student1", "CS101");
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains("Assignment1"));
    }

    @Test
    public void testGetTaskInformation() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        String taskInfo = onTrack.getTaskInformation("student1", "CS101", "Assignment1");
        assertTrue(taskInfo.contains("Complete the project"));
    }

    @Test
    public void testChatWithProfessor() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        onTrack.chatWithProfessor("student1", "CS101", "Assignment1", "I need help with this assignment.");
        Task task = unit.getTask("Assignment1");
        assertEquals(1, task.getChatMessages().size());
        assertEquals("I need help with this assignment.", task.getChatMessages().get(0));
    }

    @Test
    public void testUpdateTaskStatus() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        onTrack.updateTaskStatus("student1", "CS101", "Assignment1", "In Progress");
        Task task = unit.getTask("Assignment1");
        assertEquals("In Progress", task.getStatus());
    }

    @Test
    public void testMakeSubmission() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        onTrack.makeSubmission("student1", "CS101", "Assignment1", "Here is my project submission.");
        Task task = unit.getTask("Assignment1");
        assertEquals(1, task.getSubmissions().size());
        assertEquals("Here is my project submission.", task.getSubmissions().get(0));
    }

    @Test
    public void testRequestExtension() {
        onTrack.enrollUnit("student1", "CS101");
        Unit unit = onTrack.getUnit("student1", "CS101");
        unit.addTask("Assignment1", "Complete the project", new Date());

        Date newDueDate = new Date();
        onTrack.requestExtension("student1", "CS101", "Assignment1", newDueDate);
        Task task = unit.getTask("Assignment1");
        assertEquals(newDueDate, task.getExtensionRequest());
    }
}

