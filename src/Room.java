public class Room {
    /**
     * Used to create one of the rooms in the dragon’s lair; there are a total of 5 rooms.
     * Should store the room’s name (e.g. “the den”), how many dragons are spawned and/or remain to be killed, whether
     * the room has been cleared, and whether the room has already been searched for a health pot (a player can only search a room once).
     * Should have methods to enter the room and to search the room (allowing the player to possibly discover a health pot).
     * Should include any other static or instance variables and/or methods, including getters/setters and private helper
     * methods, that you determine are necessary to implement the requirements.
     */

    private static String lairName;
    private int numDragons;
    private boolean isAllSlayed;
    private boolean isCleared;
    private boolean roomSearched;

    //constructor
    public Room(){
        lairName = "";
        int randomNumDragons = (int)(Math.random() * 2);
        numDragons = randomNumDragons;
        isAllSlayed = false;
        isCleared = false;
        roomSearched = false;
    }


    /**
     * Gets a new room
     */
    public Room getNewRoom()
    {
        double rnd = Math.random();
        if (rnd < .2)
        {
            return new Room();
        }
        else if (rnd < .4)
        {
            return new Room();
        }
        else if (rnd < .6)
        {
            return new Room();
        }
        else if (rnd < .8)
        {
            return new Room();
        }
        else if (rnd < 1.0)
        {
            return new Room();
        }
        else
        {
            return new Room();
        }
    }

    /**
     * "enters" a room
     */
    public void enterRoom() {
        getNewRoom();
        System.out.println("You have entered a new room..." + "\n");
        System.out.println("Welcome to " + getLairName());
    }

    /**
     * returns a boolean whether the room has been searched for a health pot or not
     * @return
     */
    public boolean isRoomSearched() {
        return roomSearched;
    }

    //getter and setter methods
    public String getLairName(){
        return lairName;
    }

    public void setLairName(String currentLairName){
        lairName = currentLairName;
    }

    public int getNumDragons(){
        return numDragons;
    }

    public boolean getIsAllSlayed() {
        if (numDragons == 0){
            isAllSlayed = true;
        } else {
            isAllSlayed = false;
        }
        return isAllSlayed;
    }

    public boolean GetIsCleared(){
        if (isAllSlayed){
            isCleared = true;
        } else {
            isCleared = false;
        }
        return isCleared;
    }



}
