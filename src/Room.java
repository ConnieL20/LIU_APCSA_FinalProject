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
    private boolean roomSearched;
    private int healthPot;

    //constructor
    public Room(String lairName){
        this.lairName = lairName;
        int randomNumDragons = (int)(Math.random() * 2) + 1;
        numDragons = randomNumDragons;
        isAllSlayed = false;
        roomSearched = false;
        healthPot = 1;
    }


    /**
     * returns a boolean whether the room has been searched for a health pot or not
     * @return
     */
    public boolean isRoomSearched() {
        return roomSearched;
    }

    public void setRoomSearchedStatus(boolean status){
        roomSearched = status;
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

    public void setNumDragons(int newNuMDragons){
        numDragons = newNuMDragons;
    }

    public boolean getIsAllSlayed() {
        if (numDragons == 0){
            isAllSlayed = true;
        } else {
            isAllSlayed = false;
        }
        return isAllSlayed;
    }

    public void slayedDragon(){
        numDragons--;
    }




}
