package posts;

import java.time.LocalDateTime;

public class Respect {
    private User user;
    private LocalDateTime timestamp;

    public Respect(User user){
        this.user = user;
        this.timestamp = LocalDateTime.now();
    }


    // Getters + Setters
    public User getUser(){
        return user;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
}
