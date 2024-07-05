import java.util.List;
import java.util.ArrayList;

public class BrainClub {
    private List<User> users;


    public static void main(String args[])
    {
        BrainClub brainClub = new BrainClub();
        // brainClub.testFriendRequest();
        brainClub.testCommentAndRespect();

    }

    public BrainClub() {
        this.users = new ArrayList<>();
    }


    /**
     * test the friend request functionality
     */
    private void testFriendRequest(){
        User user1 = new User("user1", "user1_pass");
        User user2 = new User("user2", "user2_pass");
        User user3 = new User("user3", "user3_pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        user2.sendFriendRequest(user1);
        user3.sendFriendRequest(user1);

        List<FriendRequest> user1FriendRequests = user1.getRecievedRequests();

        for (FriendRequest request : user1FriendRequests){
            if (request.getRequester().equals(user2)){
                request.acceptRequest();
            }
            if (request.getRequester().equals(user3)){
                request.declineRequest();
            }
        }
    }

    /**
     * test posting, commenting and respecting functionality
     */
    private void testCommentAndRespect(){
        User user1 = new User("user1", "user1_pass");
        User user2 = new User("user2", "user2_pass");
        User user3 = new User("user3", "user3_pass");

        user1.createPost("Study Session", "FOA revision");
        user1.createPost("Assignment", "FOA Assignment 1");

        // Get all of user1 posts
        List<Post> user1Posts = user1.getPosts();

        // Extract a post
        Post user1Post1 = user1Posts.get(1);

        // Generate a comment object and add it to a post
        Comment user2Comment = new Comment(user2, "Great job");
        user2.makeComment(user1Post1, user2Comment);
        Comment user3Comment = new Comment(user3, "Awesome");
        user3.makeComment(user1Post1, user3Comment);

        // Get all the comment of user1 post 1
        List<Comment> user1Post1Comments = user1Post1.getComments();

        int i = 0;
        for (Comment comment : user1Post1Comments){
            System.out.println("Comment " + i + ": " + comment.getCommentText());
            i++;
        }



    }
}
