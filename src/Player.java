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
    private boolean healthStatus;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    private int dragonScalesBalance;
    //Constructor
    public Player(String name){
        this.name = name;
        health = 100;
        healthStatus = true;
        gold = 50;
        healthPotStatus = false;
        sword = new Sword();
        dragonScalesBalance = 0;
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


    public void setHealthPotStatus(boolean foundHealthPot){
        healthPotStatus = foundHealthPot;
    }

    public Sword getSword(){
        return sword;
    }

    public void addHealth(int moreHealth){
        health += moreHealth;
    }

    public void subtractHealth(int damage){
        health -= damage;
    }

    public void addGold(int newGold){
        gold += newGold;
    }

    public void subtractGold(int newGold){
        gold -= newGold;
    }


    /**
     * This method determines the attack amount for the Player
     * Displays the corresponding text for the attack amount
     */
    public int getPlayerAttack(){
        int attackAmt = sword.getAttack();
        int buffer = (int)(Math.random() * 10) + 1;

        if (generateSpellSuccess()){
            attackAmt *= buffer;
       } else {
           attackAmt /= 2;
        }

        return attackAmt;
    }

    public boolean generateSpellSuccess(){

        int successRate = (int)(Math.random() * 2) + 1;
        if (successRate == 1){
            return false;
        } else {
            return true;
        }


    }

    public void resetEverything(){
        health = 100;
        healthStatus = true;
        gold = 50;
        healthPotStatus = false;
        sword = new Sword();
        dragonScalesBalance = 0;
    }

    public boolean getHealthStatus(){
        return healthStatus;
    }


    public boolean playerIsDead(){
        if (health > 0) {
            healthStatus = false;
        } else {
            healthStatus = true;
        }
        return healthStatus;
    }


    public void subtractDragonScales(int scales){
        dragonScalesBalance -= scales;
    }

    public int getDragonScalesBalance(){
        return dragonScalesBalance;
    }

    public void addDragonScales(int scales){
        dragonScalesBalance = scales;
    }

}
