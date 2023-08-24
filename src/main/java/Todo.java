public class Todo extends Task{
    /**
     * the type Icon
     */
    private String type = "T";

    /**
     * constructor for Event task
     * @param description the text stored
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * override the toString method
     * @return a string
     */
    @Override
    public String toString() {
        return "[" + type + "]" + super.toString();
    }
}
