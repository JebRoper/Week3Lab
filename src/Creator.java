import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Creator {
    private Priority priority;
    private String description;
    private String senderName;
    private ObjectMapper mapper = new ObjectMapper();


    public void createMessages() throws IOException {
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            System.out.println("enter description\n");
            while (s.hasNext()) {
                String temp = s.nextLine();
                if (description == null) {
                    description = temp;
                    //System.out.println("description is " + description);
                    System.out.println("enter sender name");
                } else if (senderName == null) {
                    senderName = temp;
                    //System.out.println("sender name is " + senderName);
                    System.out.println("enter priority");
                } else if (priority == null) {

                    switch (temp) {
                        case "CRITICAL":
                            priority = Priority.CRITICAL;
                            break;
                        case "HIGH":
                            priority = Priority.HIGH;
                            break;
                        case "STANDARD":
                            priority = Priority.STANDARD;
                            break;
                        case "LOW":
                            priority = Priority.LOW;
                            break;
                        case "NONE":
                            priority = Priority.NONE;
                            break;
                        default:
                            System.out.println("bad value enter priority again");
                    }


                    if (priority != null) {
                        Message message = new Message(priority, description, senderName);
                        String json = mapper.writeValueAsString(message);

                        try (PrintWriter pw = new PrintWriter(new FileWriter(message.getId() + ".json"))) {
                            pw.print(json);
                            pw.flush();
                        }

                        priority = null;
                        description = null;
                        senderName = null;
                        System.out.println("Enter description");
                    }
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    // create Message with priority description and message

    public static void main(String args[]) throws IOException {
        Creator creator = new Creator();
        creator.createMessages();
    }


}



