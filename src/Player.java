public class Player {
    /**
     * Used to create the player.
     * Should store the player’s name, health, gold, health pot status (has one or doesn’t), and sword (Sword class).
     * Should have methods to attack (including determine attack amount), handle an incoming attack (including updating
     * the player’s own health), and use a health pot (if the player is carrying one).
     * You should also consider including methods related to menu options that deal with the player, such as checking
     * player health level or the player’s sword stats.
     * Should include any other static or instance variables and/or methods, including getters/setters and private helper
     * methods, that you determine are necessary to implement the requirements.
     */

    //Instance variables
    private static String name;

    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    //Constructor
    public Player(String name){
        this.name = name;
        health = 100;
        gold = 50;
        healthPotStatus = false;
        sword = new Sword();
    }

    //Getter and setter methods
    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getGold(){
        return gold;
    }

    public boolean getHealthPotStatus(){
        return healthPotStatus;
    }

    public Sword getSword(){
        return sword;
    }

    public void addHealth(int damage){
        health += damage;
    }

    public void subtractHealth(int damage){
        health -= damage;
    }

    public void addGold(int newGold){
        gold += newGold;
    }

    public void subtractGold(int newGold){
        gold += newGold;
    }


    /**
     * This method determines the attack amount for the Player
     * Displays the corresponding text for the attack amount
     */
    public int getPlayerAttack(){
        int attackAmt = sword.getAttack();

        int buffer = (int)(Math.random() * 10) + 1;
        attackAmt *= buffer;

        return attackAmt;
    }

}
