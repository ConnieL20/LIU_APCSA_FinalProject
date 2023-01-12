import java.util.Scanner;

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
    private boolean playerTurn;
    private int rooms;


    public DragonSlayer(){
        scan = new Scanner(System.in);
        player = null;
        dragon = null;
        playerTurn = true;
        rooms = 8;
    }

    /**
     * This method will greet the player
     */
    public void greeting(){
        System.out.print("Welcome to Dragon Slayer Game! Please enter your name: ");
        String playerName = scan.nextLine();

        //creates player object
        player = new Player(playerName);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Greetings " + player.getName() + "! We have been awaiting for your arrival.");
        System.out.println("Dragons have plagued our kingdom and we need your help to slay them!" + "\n");
        System.out.println("What's that? You want...a reward? Err...if you defeat a dragon you might get some gold!");
        System.out.println("O-oh you accept? *mumbles* what a son of a-" + "\n");
        System.out.println("Silly me! We must keep this school-friendly. Well then, brave warrior, venture one!");
        System.out.println("-------------------------------------------------------------------------------------------");
    }
    public void play(){
        greeting();
        dragon = new Dragon();
        while (rooms > 0) {
            if (playerTurn) {
                System.out.println("You have entered " + dragon.getDragonName() + "'s lair...");
                player.playerAttack();
                playerTurn = false;
            }
        }

    }
}
