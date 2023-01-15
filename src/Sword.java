public class Sword {
    /**
     * Used to create the player’s sword.
     * Should store sword’s attack power and dodge rating.
     * Should have a method (or methods) to update the sword stats when an upgrade is obtained.
     * Should include any other static or instance variables and/or methods, including getters/setters and private
     * helper methods, that you determine are necessary to implement the requirements.
     */

    //Instance variables
    private int attack;
    private double dodge;

    //Constructor
    public Sword() {
        attack = 10;
        dodge = 20;
    }

    //Getter and setter methods
    public int getAttack(){
        return attack;
    }

    public double getDodge(){
        return dodge/10;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

}
