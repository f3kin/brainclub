import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store all user data
 */
public class User {
    private String username;
    private String password;
    private List<Post> posts;
    private List<User> friends;
    private List<FriendRequest> recievedRequests;
    private List<FriendRequest> sentRequests;
    private EducationInstitution educationInstitution;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.recievedRequests = new ArrayList<>();
        this.sentRequests = new ArrayList<>();
    }

    /**
     * Creates a new user post and adds to the user array list
     */
    public void createPost(String name, String description){
        Post post = new Post(name, description, LocalDate.now());

        posts.add(post);
    }

    /**
     * Deletes a user post and removes it from array list
     */
    public void deletePost(Post postToRemove){
        posts.remove(postToRemove);
    }

    /**
     * Sends a friend request to the selected user.
     */
    public void sendFriendRequest(User friend){
        // Checks if friend request has been declined already
        for (FriendRequest request : friend.getRecievedRequests()){
            if (request.isDeclined() && request.getRequester().equals(this)){
                System.out.println("Friend request already rejected");
                return;
            } else if (request.getRequester().equals(this)) {
                System.out.println("Friend request already sent");
            }
        }

        // Creates friend request, adds to requester and requestee friend request lists
        FriendRequest request = new FriendRequest(this, friend);
        friend.recieveFriendRequest(request);
        sentRequests.add(request);
    }

    /**
     * Accepts a user friend request and removes request from the relevant lists
     */
    public void acceptFriendRequest(FriendRequest request){
        request.acceptRequest();
        recievedRequests.remove(request);
        // TO_DO : Remove the request from other person
    }

    /**
     * Makes a comment on the post by a given user
     */
    public void makeComment(Post post, Comment comment){
        post.addComment(comment);
    }

    public void declineFriendRequest(FriendRequest request){
        request.declineRequest();
    }

    /**
     * Recieve a user friend request
     */
    public void recieveFriendRequest(FriendRequest request){
        recievedRequests.add(request);
    }

    public void addFriend(User friend){
        friends.add(friend);
    }

    public void removeFriend(User friend){
        friends.remove(friend);
    }



    // Getters + setters

    public List<FriendRequest> getRecievedRequests() {
        return recievedRequests;
    }
    public List<FriendRequest> getSentRequests() {
        return sentRequests;
    }
    public String getUsername(){
        return username;
    }
    public void setEducationInstitution(EducationInstitution institution){
        this.educationInstitution = institution;
    }
    public List<Post> getPosts(){
        return posts;
    }

}
