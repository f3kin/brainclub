import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    // Attributes
    private String title;
    private String description;
    private LocalDate date;
    private int likes;
    private int numComments;
    private List<Comment> comments;
    private List<Respect> respects;


    // Functional Code

    public Post(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.comments = new ArrayList<>();
        this.respects = new ArrayList<>();
    }

    public void addComment(Comment comment){
        comments.add(comment);
        System.out.println ("Comment: " + comment.getCommentText() + " added.");
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    public void editDescription(String newDescription){
        description = newDescription;
    }
    public void editTitle(String newTitle) {
        title = newTitle;
    }






    // Getters + Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRespects() {
        return respects.size();
    }
    public int getNumComments() {
        return comments.size();
    }

    public List<Comment> getComments() {
        return comments;
    }
}
