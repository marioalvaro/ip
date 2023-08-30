public class Task {
    /**
     * the task description
     */
    protected String description;
    /**
     * variable to indicate if it is marked or not
     */
    protected boolean isDone;

    /**
     * Constructor for Task class
     * @param description the string of description that would like to be stored
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * factory method to create task based on the type
     * @param splitTask String array containing the type and description
     * @return new Task object based on the types
     * @throws DukeException throws DukeException
     */
    public static Task createTaskType(String[] splitTask) throws DukeException {
        /**
         * variable to store the type of task
         */
        String type = splitTask[0];
        /**
         * variable to store description
         */
        String description = "";

        if (!(type.equals("deadline") || type.equals("todo") || type.equals("event"))) {
            throw new DukeNotTaskException(type);
        }

        try {
            description = splitTask[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeIndexOutOfBoundException(splitTask[0]);
        }

        try {
            if (type.equals("deadline")) {
                String[] splitDesc = description.split(" /by ", 2);
                return new Deadline(splitDesc[0], splitDesc[1]);
            } else if (type.equals("todo")) {
                return new Todo(description);
            } else {
                String[] splitDesc = description.split(" /from ", 2);
                String[] splitDesc2 = splitDesc[1].split(" /to ", 2);
                return new Event(splitDesc[0], splitDesc2[0], splitDesc2[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeNoTimeException(type);
        }
    }

    /**
     * return the status icon
     * @return the status icon
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * mark the task done
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * mark the task not done
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * override the toString method
     * @return a string
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + description;
    }

    public String toDataString() {
        if (this.isDone) {
            return "1 / " + this.description;
        } else {
            return "0 / " + this.description;
        }
    }
}

