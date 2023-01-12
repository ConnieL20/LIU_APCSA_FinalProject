import java.util.ArrayList;

public class Dragon {
    /**
     * Used to create a dragon.
     * Should store the dragon health and level (1, 2, or 3).
     * Should have methods to attack (including determine attack amount), handle an incoming attack
     * (including updating the dragon’s own health), and determine which of the four outcomes happen when it dies.
     * Should include any other static or instance variables and/or methods, including getters/setters and private
     * helper methods, that you determine are necessary to implement the requirements.
     */

    //Instance Variables
    private int health;
    private ArrayList<String> dragonNamesList = new ArrayList<String>();
    private String dragonName;
    private int level;
    private int attack;

    //Constructor
    public Dragon(){
        health = 100;
        int randomName = (int)(Math.random() * 8) + 1; //randomly sets a dragon's name
        if (randomName >= 1 && randomName < 3 ) {
            dragonName = "The Abysmal Wrath Dragon";
        } else if (randomName >= 3 && randomName < 5){
            dragonName = "The Golden Gluttonous Dragon";
        } else if (randomName >= 5 && randomName < 7) {
            dragonName = "The Crimson Fire Dragon";
        } else {
            dragonName = "The White Death Dragon" ;
        }

        int randomLevel = (int)(Math.random() * 4) + 1; //randomly sets a dragon's level
        if (randomLevel == 1) {
            level = 1;
        } else if (randomLevel == 2) {
            level = 2;
        } else if (randomLevel == 3) {
            level = 3;
        } else {
            level = 4;
        }

        attack = 30;
    }

    //Getter and setter methods
    public int getDragonHealth() {
        return health;
    }

    public String getDragonName(){
        return dragonName;
    }

    public void subtractDragonHealth(int newHealth){
        health -= newHealth;
    }



}
