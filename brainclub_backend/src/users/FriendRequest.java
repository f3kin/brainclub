package users;

import users.User;

public class FriendRequest {
    private User requester;
    private User requestee;
    private boolean accepted;
    private boolean declined;

    public FriendRequest(User requester, User requestee){
        this.requester = requester;
        this.requestee = requestee;
        this.accepted = false;
        this.declined = false;
    }

    /**
     * Friend request accepted, add users to eachothers friend list
     */
    public void acceptRequest() {
        accepted = true;
        requester.addFriend(requestee);
        requestee.addFriend(requester);
        System.out.println(requester.getUsername() + " and " + requestee.getUsername()
        + " are now friends");
    }

    /**
     * users.User declines friend request. update
     */
    public void declineRequest() {
        declined = true;
        System.out.println(requestee.getUsername() + " declined " + requester.getUsername() +
                " friend request.");
    }


    // Getters + setters

    public User getRequester() {
        return requester;
    }
    public User getRequestee() {
        return requestee;
    }

    public boolean isDeclined() {
        return declined;
    }
}
