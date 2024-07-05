import java.util.List;
import java.util.ArrayList;

public class BrainClub {
    private List<User> users;


    public static void main(String args[])
    {
        BrainClub brainClub = new BrainClub();
        // brainClub.testFriendRequest();

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
}
