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
    private String name;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    private Dragon dragon;
    //Constructor
    public Player(String name){
        this.name = name;
        health = 100;
        gold = 50;
        healthPotStatus = false;
        sword = new Sword();
        dragon = new Dragon();
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

    public void addHealth(int newHealth){
        health += newHealth;
    }

    public void subtractHealth(int newHealth){
        health -= newHealth;
    }

    public void addGold(int newGold){
        gold += newGold;
    }

    public void subtractGold(int newGold){
        gold += newGold;
    }


    /**
     * This method determines the attack amount for the Player
     */
    public void playerAttack(){
        int attackAmt = sword.getAttack();
        System.out.println("You current weapon has an attack of " + attackAmt + ".");

        int buffer = (int)(Math.random() * 10) + 1;
        if (buffer >= 1 && buffer < 5){
            attackAmt *= buffer;
            System.out.println("The Gods have given you their mercy.");
        } else {
            attackAmt *= buffer;
            System.out.println("The Gods smile down upon you!");
        }
        System.out.println("Your attack amount has been multiplied by " + buffer + " and is now " + attackAmt);
        dragon.subtractDragonHealth(attackAmt);
        System.out.println("You attack " + dragon.getDragonName() + ". Now it has " + dragon.getDragonHealth() + " health left!");
    }

}
