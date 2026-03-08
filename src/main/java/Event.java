/**
 * Represents an event task that occurs between a start time and an end time.
 */

public class Event extends Task {

    protected String startTime;
    protected String endTime;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description the description of the event
     * @param startTime the starting time of the event
     * @param endTime the ending time of the event
     */
    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the time range of the event.
     *
     * @return the event time range in the format "startTime-endTime"
     */
    public String getTimeRange() {
        return startTime + "-" + endTime;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}