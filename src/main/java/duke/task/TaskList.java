package duke.task;

import duke.exception.DukeDuplicatesCommandException;
import duke.exception.DukeException;
import duke.exception.DukeNotTaskException;

import java.util.ArrayList;

/**
 * A Class that acts as an array for storing all the tasks.
 *
 * @author marioalvaro
 */
public class TaskList {
    enum DuplicatesMode {
        ON,
        OFF,
        TEXT,
    }
    private ArrayList<Task> taskList;
    private DuplicatesMode duplicatesMode;

    /**
     * Constructor if the taskList has not been created
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
        duplicatesMode = DuplicatesMode.ON;
    }

    /**
     * Constructor if there is an existing taskList.
     *
     * @param taskList ArrayList of task.
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
        duplicatesMode = DuplicatesMode.ON;
    }

    /**
     * Add a task into the TaskList.
     *
     * @param task the task that want to be added
     */
    public void add(Task task) {
        this.taskList.add(task);
    }

    /**
     * Remove a task from the TaskList
     *
     * @param index The index of the task that want to be removes.
     */
    public void remove(int index) {
        this.taskList.remove(index);
    }

    /**
     * Get the task based on the index.
     *
     * @param index of the task
     * @return the Task with the index
     */
    public Task get(int index) {
        return this.taskList.get(index);
    }

    /**
     * Get the size of the list
     * @return the size of the list
     */
    public int size() {
        return this.taskList.size();
    }

    /**
     * Get the index of a task.
     *
     * @param task The task
     * @return the index of the task
     */
    public int indexOf(Task task) {
        return this.taskList.indexOf(task);
    }

//    public void updateCheckDuplicates(String command) {
//        if (command.equals("on")) {
//            this.duplicatesMode = DuplicatesMode.ON;
//        } else if (command.equals("text")) {
//            this.duplicatesMode = DuplicatesMode.TEXT;
//        } else {
//            assert command.equals("off") : "Duplicates Command word is wrong!";
//            this.duplicatesMode = DuplicatesMode.OFF;
//        }
//    }
//    public boolean isDuplicates(Task task) throws DukeException {
//        switch (duplicatesMode) {
//        case ON:
//            return isAbsoluteDuplicates(task);
//        case TEXT:
//            return isTextDuplicates(task);
//        case OFF:
//            return false;
//        default:
//            throw new DukeDuplicatesCommandException("");
//        }
//    }
//
//    private boolean isAbsoluteDuplicates(Task task) {
//        for (int i = 0; i < this.size(); i++) {
//            if (this.get(i) == null) {
//                break;
//            }
//            if (task.equals(this.get(i))) {
//                return true;
//            }
//
//        }
//        return false;
//    }
//
//    private boolean isTextDuplicates(Task task) {
//        for (int i = 0; i < this.size(); i++) {
//            if (this.get(i) == null) {
//                break;
//            }
//            if (task.equalsText(this.get(i))) {
//                return true;
//            }
//
//        }
//        return false;
//    }


}
