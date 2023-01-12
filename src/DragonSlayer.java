import java.util.*;

public class DragonSlayer {
    /**
     * Contains the logic for running the game, including welcoming the player, presenting the main menu, presenting
     * appropriate player actions, printing messages to the user, moving the player from room to room, determining game
     * over status, generating score, etc.
     * Must include a play() method that is the launching point for the entire game.
     * Should include any other static or instance variables and/or methods, including getters/setters and private helper
     * methods, that you determine are necessary to implement the requirements.
     */
    private Scanner scan;
    private Player player;
    private Dragon dragon;
    private Sword sword;
    private int numDragons;
    private boolean playerTurn;
    private int rooms;
    private Set<String> defeatedDragons;


    public DragonSlayer() {
        scan = new Scanner(System.in);
        defeatedDragons = new HashSet<>();
        dragon = getDragon();
        playerTurn = true;
        rooms = 8;
        numDragons = 0;
    }

    //Getter and setter methods
    public Dragon getDragon() {
        String dragonName = "";
        int randomName = (int) (Math.random() * 7) + 1; //randomly sets a dragon's name
        if (randomName == 1) {
            dragonName = "Lucifer";
        } else if (randomName == 2) {
            dragonName = "Mammon";
        } else if (randomName == 3) {
            dragonName = "Asmodeus";
        } else if (randomName == 4) {
            dragonName = "Leviathan";
        } else if (randomName == 5) {
            dragonName = "Beelzebub";
        } else if (randomName == 6) {
            dragonName = "Satan";
        } else {
            dragonName = "Belphegor";
        }

        int level = 0;
        int randomLevel = (int) (Math.random() * 4) + 1; //randomly sets a dragon's level
        if (randomLevel == 1) {
            level = 1;
        } else if (randomLevel == 2) {
            level = 2;
        } else if (randomLevel == 3) {
            level = 3;
        } else {
            level = 4;
        }
        return new Dragon(dragonName, level);
    }

    public void setDragon(Dragon newDragon) {
        dragon = newDragon;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * method to ensure that the same dragon and level does not get used again
     * The dragonName and its level will be placed in the HashMap
     */
    public void addDefeatedDragon(Dragon dragon) {
        defeatedDragons.add(dragon.getDragonName());
    }


    /**
     * This method will greet the player
     */
    public void greeting() {
        System.out.print("Welcome to Dragon Slayer Game! Please enter your name: ");
        String playerName = scan.nextLine();

        //creates player object
        player = new Player(playerName);
        sword = player.getSword();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Greetings " + player.getName() + "! We have been awaiting for your arrival.");
        System.out.println("Dragons have plagued our kingdom and we need your help to slay them!");
        System.out.println("Defeat just FOUR of them and the rest will flee!");
        System.out.println("." + "\n" + "." + "\n" + ".");
        System.out.println("What's that? You want...a reward? Err...if you defeat a dragon you might get some gold!");
        System.out.println("." + "\n" + "." + "\n" + ".");
        System.out.println("O-oh you accept? *mumbles* What a little sh-" + "\n");
        System.out.print("Silly me! We must keep this school-friendly. Well then, brave warrior, enter 'y' to venture on! ");

    }

    public void play() {
        greeting();
        boolean isValid = true;
        String answer = scan.nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("-------------------------------------------------------------------------------------------");
        } else {
            System.out.println("That was an invalid input. Goodbye!");
            isValid = false;
        }

        while (isValid && numDragons < 4 && !dragon.isDead()) {
            setDragon(dragon);
            numDragons++;

            if (playerTurn) {
                int playerAttack = player.getPlayerAttack();

                if (dragon.isDead()) {
                    addDefeatedDragon(dragon);
                } else {
                    dragon.subtractDragonHealth(playerAttack);
                    System.out.printf("The dragon takes %s damage!\n", playerAttack);
                    System.out.printf("The dragon has %s health left%n", dragon.getDragonHealth());
                    playerTurn = false;
                }

            } else {
                System.out.println("The dragon has begun to attack...");
                int dragonAttack = dragon.getDragonAttack();
                int maxProb = sword.getDodge();
                int randomDodge = (int) (Math.random() * maxProb);

                if (randomDodge >= maxProb / 2) {
                    System.out.println("The dragon swipes and you dodge!");
                } else {
                    System.out.println("Ouch! The dragon swipes and you get hit!");
                    player.subtractHealth(dragonAttack);
                    System.out.printf("You now have %s health left\n", player.getHealth());
                }
                playerTurn = true;
            }
        }


    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
