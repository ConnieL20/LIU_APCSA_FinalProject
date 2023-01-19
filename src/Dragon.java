import java.util.ArrayList;
import java.util.HashMap;

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
    private String dragonName;
    private int level;
    private int attack;
    private int dragonScales;

    //Constructor
    public Dragon(String dragonName, int level){
        health = 100;
        this.dragonName = dragonName;
        this.level = level;
        attack = 30;

        int randomScales = 0;
        if (level > 2){
            randomScales = (int)(Math.random() * 41) + 20;
        } else {
            randomScales = (int)(Math.random() * 11) + 10;
        }
        dragonScales = randomScales;

    }

    /**
     * Method for calculating the attack amount of the dragon
     * @return
     */
    public int getDragonAttack(){
        int dragonAttackAmt = level;

        int dragonBuffer = (int)(Math.random() * 9) + 2;
        dragonAttackAmt *= dragonBuffer;

        return dragonAttackAmt + attack;
    }

    //Getter and setter methods
    public int getDragonHealth() {
        return health;
    }

    public int getDragonLevel(){
        return level;
    }

    public String getDragonName(){
        return dragonName;
    }

    public void subtractDragonHealth(int damage){
        health -= damage;
    }

    public int getDragonScales(){
        return dragonScales;
    }



    /**
     * boolean that checks if a dragon is dead or not
     */
    public boolean dragonIsDead() {
        if (health > 0){
            return false;
        } else {
            return true;
        }
    }






}
