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
    private Room den;
    private int totalDragons;
    private boolean playerTurn;
    private int numRooms;
    private Set<String> defeatedDragons;
    private Set<String> listOfDragons;
    private boolean isValid;

    private boolean wantsToContinue;
    private boolean playAgain;


    public DragonSlayer() {
        scan = new Scanner(System.in);
        defeatedDragons = new HashSet<>();
        listOfDragons = new HashSet<>(Arrays.asList("Toothless", "Mushu", "Maleficnet", "Dvalin", "Stormfly", "Morax", "Azhdaha"));
        den = getNewRoom();
        dragon = getDragon();
        playerTurn = true;
        numRooms = 0;
        totalDragons = 7;
        isValid = true;
        wantsToContinue = true;
        playAgain = true;
    }

    //Getter and setter methods
    private Dragon getDragon() {
        String dragonName = "";
        int randomName = (int) (Math.random() * 7) + 1; //randomly sets a dragon's name
        if (randomName == 1) {
            dragonName = "Toothless";
        } else if (randomName == 2) {
            dragonName = "Mushu";
        } else if (randomName == 3) {
            dragonName = "Maleficent";
        } else if (randomName == 4) {
            dragonName = "Dvalin";
        } else if (randomName == 5) {
            dragonName = "Stormfly";
        } else if (randomName == 6) {
            dragonName = "Morax";
        } else {
            dragonName = "Azhdaha";
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

    /**
     * sets den to the new room created in getNewRoom()
     */
    private void setDen(){
        den = getNewRoom();
    }

    /**
     * Gets a new room
     */
    private Room getNewRoom()
    {
        double rnd = (int)(Math.random() * 7) + 1;
        if (rnd == 1)
        {
            den = new Room();
            den.setLairName("Azul Sea of Terror");

        }
        else if (rnd == 2)
        {
            den = new Room();
            den.setLairName("Emerald Green Jungle");
        }
        else if (rnd == 3)
        {
            den = new Room();
            den.setLairName("Golden Death Desert");

        }
        else if (rnd == 4)
        {
            den = new Room();
            den.setLairName("White Wraith Island");
        }
        else if (rnd == 5)
        {
            den = new Room();
            den.setLairName("Black Soul Mountains");
        }
        else if (rnd == 6)
        {
            den = new Room();
            den.setLairName("Violet Delights Archipelago");
        } else
        {
            den = new Room();
            den.setLairName("Crimson Blood Keep");
        }
        return den;
    }


    private void setDragon(Dragon newDragon) {
        dragon = newDragon;
    }

    /**
     * method to ensure that the same dragon and level does not get used again
     * The dragonName and its level will be placed in the HashMap
     */
    private void addDefeatedDragon(Dragon dragon) {
        defeatedDragons.add(dragon.getDragonName());
    }

    private void resetStats(){
        defeatedDragons = new HashSet<>();
        listOfDragons = new HashSet<>(Arrays.asList("Toothless", "Mushu", "Maleficent", "Dvalin", "Stormfly", "Morax", "Azhdaha"));
        den = getNewRoom();
        dragon = getDragon();
        playerTurn = true;
        numRooms = 0;
        totalDragons = 7;
        isValid = true;
        wantsToContinue = true;
        playAgain = true;
    }


    /**
     * This method will greet the player
     */
    private void greeting() {
        System.out.print("Welcome to Dragon Slayer Game! Please enter your name: ");
        String playerName = scan.nextLine();

        //creates player object
        player = new Player(playerName);
        sword = player.getSword();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Greetings " + player.getName() + "! We have been awaiting for your arrival. Dragons have plagued our kingdom and we need your help to slay them!");
        System.out.println("With each dragon you slay, you gain a certain amount of dragon scales. With them, you can get a sword upgrade, increase dodge rate, or regain a fraction of your health!\n");
        System.out.println("Kill all dragons within FIVE lairs (AKA Rooms) to save us!");
        System.out.println("." + "\n" + "." + "\n" + ".");
        System.out.println("What's that? You want...a reward? Err...you could also get more gold by trading in some dragon scales?");
        System.out.println("." + "\n" + "." + "\n" + ".");
        System.out.println("O-oh you accept? *mumbles* What a little sh-" + "\n");
        System.out.print("Silly me! We must keep this school-friendly. Well then, brave warrior, enter 'y' to venture on! ");

    }

    public void play() {
        greeting();
        String answer = scan.nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("-------------------------------------------------------------------------------------------");
            displayBaseStats();
            setDragon(dragon);

            while (wantsToContinue && !player.playerIsDead() && playAgain) {
                numRooms++;
                System.out.println("You are now in your room: " + numRooms);

                if (numRooms == 1){
                    System.out.println("You have ventured into your first room..." + "\n");
                } else {
                    System.out.println("You have ventured into a new room..." + "\n");
                    setDen();
                    System.out.println(den.getLairName());
                    den.setNumDragons(den.getNumDragons());
                    setDragon(getDragon());
                }

                System.out.println("Welcome to " + den.getLairName() + "!");
                searchHealthPot();
                System.out.println("Beware...there are " + den.getNumDragons() + " dragons in here...");
                System.out.println("Here comes a dragon! " + dragon.getDragonName() + " is a level " + dragon.getDragonLevel());
                System.out.println("--------------------------------------------------------------------------------------");
                enterRoom();

                if (player.playerIsDead()){
                    System.out.println("GAME OVER! Do you want to play again? (y/n)");
                    String playerPlaysAgain = scan.nextLine();

                    if (playerPlaysAgain.equals("n")){
                        wantsToContinue = false;
                        playAgain = false;
                    } else if (playerPlaysAgain.equals("y")){
                        wantsToContinue = true;
                        playAgain = true;
                        player.resetHealth();
                        resetStats();
                    }

                } else {
                    System.out.println("Would you like to proceed into the next room? (y/n)");
                    String proceed = scan.nextLine();
                    if (proceed.equals("y")){
                        wantsToContinue = true;
                    } else  {
                        wantsToContinue = false;
                        System.out.println("Goodbye!");
                    }
                    System.out.println("--------------------------------------------------------------------------------------");
                }

            }

        } else {
            System.out.println("That was an invalid input. Goodbye!");
            isValid = false;
            wantsToContinue = false;
        }
    }

    /**
     * "enters" a room/Dragon's den
     * contains the code and game logic in each room (player and dragon attacks)
     * will keep the player in the same room if there are more than one dragon to defeat
     */
    private void enterRoom() {

        while (isValid && !player.playerIsDead() && !den.getIsAllSlayed() && wantsToContinue && playAgain) {
            int playerAttack = player.getPlayerAttack();
            int dragonAttack = dragon.getDragonAttack();

            if (playerTurn) {
                System.out.println("Your current sword attack stat is " + sword.getAttack() + ".");
                System.out.print("Do you want to risk casting a spell for a higher sword attack? (y/n)");
                String spellChoice = scan.nextLine();

                if (spellChoice.equals("y") || spellChoice.equals("Y")){
                    if (playerAttack <= sword.getAttack()){
                        System.out.println("Not the best upgrade. Did you do something to anger the Gods? Oh well! Your new sword attack is now " + playerAttack + "!");
                    } else {
                        System.out.println("The Gods smile upon you! Your new sword attack is now " + playerAttack + "!");
                    }
                    System.out.println("You attack " + dragon.getDragonName());
                    dragon.subtractDragonHealth(playerAttack);
                } else {
                    System.out.println("You attack " + dragon.getDragonName());
                    playerAttack = sword.getAttack();
                    dragon.subtractDragonHealth(playerAttack);
                }

                if (dragon.dragonIsDead()) {

                    addDefeatedDragon(dragon);
                    listOfDragons.remove(dragon.getDragonName());
                    System.out.println(defeatedDragons);
                    System.out.println("You defeated " + dragon.getDragonName() + "!");
                    den.slayedDragon();
                    purchaseMenu();
                    System.out.println("Number of dragons left: " + den.getNumDragons());

                    if (den.getNumDragons() > 0){
                        System.out.println("Don't celebrate too soon! There is still " + den.getNumDragons() + " more dragons...");
                        setDragon(getDragon());
                    } else {
                        break;
                    }
                } else {
                    System.out.printf("The dragon takes %s damage!\n", playerAttack);
                    System.out.printf("The dragon has %s health left%n", dragon.getDragonHealth());
                }
                playerTurn = false;

                promptEnterKey();
                System.out.println("--------------------------------------------------------------------------------------");

            } else {
                System.out.printf("%s has begun to attack...", dragon.getDragonName());
                System.out.printf("It attacks with %s attack points!\n", dragonAttack);

                int randomDodge = (int)(Math.random() * 20) + 1;
                if (randomDodge >= sword.getDodge()/2){
                    System.out.println("The dragon swipes and you dodge!");
                } else {
                    player.subtractHealth(dragonAttack);
                    System.out.println("Ouch! The dragon swipes and you get hit!");

                    if (player.getHealth() > 0){
                        System.out.printf("You now have %s health left\n", player.getHealth());
                    } else {
                        System.out.println(dragon.getDragonName() + " has defeated you! You are DEAD.");

                    }
                }

                if (den.isRoomSearched() && !player.playerIsDead() && player.getHealthPotStatus()){
                    System.out.println("Would you like to use your health pot now? (y/n)");
                    String healthPot = scan.nextLine();
                    if (healthPot.equals("y")){
                        player.addHealth(Math.abs(player.getHealth() - 100)/2);
                        System.out.println("You have used your health pot! Your health has been restored to " + player.getHealth());
                        player.setHealthPotStatus(false);
                    } else {
                        System.out.println("Alright then, if you say so!");
                    }
                } else if (den.isRoomSearched() && !player.playerIsDead() && !player.getHealthPotStatus()) {
                    System.out.println("You've already used your health pot!");
                } else {
                    System.out.println(":p no health pot");
                }

                promptEnterKey();
                playerTurn = true;
                System.out.println("--------------------------------------------------------------------------------------");
            }
        }
    }

    private void purchaseMenu(){
        System.out.println(dragon.getDragonName() + " has dropped " + dragon.getDragonScales() + " scales!");
        System.out.println("Here are you options:\n1. 10 Gold to double your current health.\n2. 20 Gold to double your base sword attack.\n3. 30 Gold to double your dodge rate.\n4. Trade in half of your dragon scales for 50 more pieces of gold.\n5. Do nothing and keep your dragon scales!");
        System.out.println("Type in the corresponding answer number (i.e. 1, 2, 3...)");
        String purchase = scan.nextLine();

        if (purchase.equals("1")){
            player.subtractGold(10);
            player.addHealth(player.getHealth() * 2);
            System.out.println("Your current health is now: " + player.getHealth());
        } else if (purchase.equals("2")){
            player.subtractGold(20);
            sword.setAttack(sword.getAttack() * 2);
            System.out.println("Your current base sword attack is now: " + sword.getAttack());
        } else if (purchase.equals("3")){
            player.subtractGold(30);
            sword.setDodge(sword.getDodge() * 2);
            System.out.println("Your current dodge rate is now: " + sword.getDodge());
        } else if (purchase.equals("4")){
            player.subtractDragonScales(player.getDragonScalesBalance()/2);
            player.addGold(50);
        } else {
            System.out.println("Alright then! Nothing shall be done.");
            System.out.println("You currently have " + player.getDragonScalesBalance() + " dragon scales!");
        }

        System.out.println("Your current gold balance is now: " + player.getGold());

    }

    private void searchHealthPot(){
        System.out.println("Would you like to search the room for a health pot? You can save and use it to heal yourself during battle! (y/n)");
        String answer = scan.nextLine();
        if (answer.equals("n") || answer.equals("N")){
            den.setRoomSearchedStatus(false);
        } else {
            int healthPotRandom = (int)(Math.random() * 2) + 1;
            if (healthPotRandom == 1){
                den.setRoomSearchedStatus(true);
                System.out.println("You've successfully found a health pot! You may now choose to use it as you see fit during battle.");
                player.setHealthPotStatus(true);
            } else {
                den.setRoomSearchedStatus(false);
                System.out.println("Unfortunately, there is no health pot in this room.");
                player.setHealthPotStatus(false);
            }
        }
    }

    private static void displayBaseStats(){
        System.out.println("Here are your base stats:");
        System.out.println("- Your health is 100.\n- Your current sword attack is 10 (you can increase it when you clear a room)!\n- Your dodge rate is 20%.\n- You currently have 50 gold.");
        System.out.println("** During battle, you can choose to cast a spell to temporarily increase your sword attack (beware, it might decrease it :p)! **" + "\n");
        System.out.println("Here is a dragon's base stats:");
        System.out.println("- Each dragon starts a with a health of 100.\n- Each dragon has a base attack of 30 (which they can also increase during battle)." + "\n");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        scan.nextLine();
    }
}
