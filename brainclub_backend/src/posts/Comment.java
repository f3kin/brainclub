package posts;

import java.time.LocalDateTime;

public class Comment {
    private User user;
    private String commentText;
    private LocalDateTime timestamp;

    public Comment(User user, String commentText){
        this.user = user;
        this.commentText = commentText;
        this.timestamp = LocalDateTime.now();
    }



    // Getters + setters
    public User getUser() {
        return user;
    }
    public String getCommentText(){
        return commentText;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }

}
