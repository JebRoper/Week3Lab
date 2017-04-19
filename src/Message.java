import java.util.Random;

/**
 * Created by admin on 4/14/17.
 */
public class Message {

    private int id;
    private Priority priority;
    private String description;
    private String senderName;

    public Message(Priority priority, String description, String senderName) {
        Random random = new Random();
        this.id = Math.abs(random.nextInt());  //random int here
        this.priority = priority;
        this.description = description;
        this.senderName = senderName;
    }

    public int getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getSenderName() {
        return senderName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", senderName='" + senderName + '\'' +
                '}';
    }
}



