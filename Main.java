import java.util.Scanner;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.File;

class Main{
    public static void main(String[] args){

        // used to upload picture
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("pokemon.jpg");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // to read .txt file
        Scanner dataFile = null;
        try{
          dataFile = new Scanner(new File("pokemonStats.txt"));
        } catch (Exception e){
            System.out.println("File did not open.");
            System.exit(-1);
        }

        // intializing arrays 
        String[] name = new String[6];
        String[] type = new String[6];
        int[] currentHealth = new int [6];
        int [] maxHealth = new int[6];
        int[] attack = new int[6];
        int[] defence = new int[6];
        int[] speed = new int[6];
        int[] ragePotion = new int[6];

        String[] battleWords = {"obliterating", "lacerating", "demolishing", "annihilating", "decapitating", "hammering", "bludgeoning", "beating up", "putting an end to", "slaughtering" };

        // scans through the file
        for (int j = 0; j < 6; j++){
          name[j] = dataFile.next();
          type[j] = dataFile.next();
          currentHealth[j] = dataFile.nextInt();
          maxHealth[j] = dataFile.nextInt();
          attack[j] = dataFile.nextInt();
          defence[j] = dataFile.nextInt();
          speed[j] = dataFile.nextInt();
          ragePotion[j] = dataFile.nextInt();
        }

        // makes the player objects
        Player player1 = new Player();
        Player player2 = new Player();
        
        // user input
        Scanner input = new Scanner(System.in);

        // random object
        Random rand = new Random();

        // counters
        int roundCounter = 0;
        int playerOneWinCount = 0;
        int playerTwoWinCount = 0;
        int battleCounter = 0;
        
        // player choices (user input)
        int playerOneChoice;
        int playerTwoChoice;

        // starting pokemon levels
        int playerOneLevel = 1;
        int playerTwoLevel = 1;

        // adds the statistics of pokemons from pokemonStats.txt file
        player1.pokeArray(name[0], type[0], currentHealth[0], maxHealth[0], attack[0], defence[0], speed[0], ragePotion[0]);
        player1.pokeArray(name[1], type[1], currentHealth[1], maxHealth[1], attack[1], defence[1], speed[1], ragePotion[1]);
        player1.pokeArray(name[2], type[2], currentHealth[2], maxHealth[2], attack[2], defence[2], speed[2], ragePotion[2]);
        
        player2.pokeArray(name[3], type[3], currentHealth[3], maxHealth[3], attack[3], defence[3], speed[3], ragePotion[3]);
        player2.pokeArray(name[4], type[4], currentHealth[4], maxHealth[4], attack[4], defence[4], speed[4], ragePotion[4]);
        player2.pokeArray(name[5], type[5], currentHealth[5], maxHealth[5], attack[5], defence[5], speed[5], ragePotion[5]);

        // ascii art
        System.out.println("");
        System.out.println("====================================================");
        System.out.println("===============  ===================================");
        System.out.println("===============  ===================================");
        System.out.println("===============  ===================================");
        System.out.println("=    ====   ===  =  ===   ===  =  = ====   ===  = ==");
        System.out.println("=  =  ==     ==    ===  =  ==        ==     ==     =");
        System.out.println("=  =  ==  =  ==   ====     ==  =  =  ==  =  ==  =  =");
        System.out.println("=    ===  =  ==    ===  =====  =  =  ==  =  ==  =  =");
        System.out.println("=  =====  =  ==  =  ==  =  ==  =  =  ==  =  ==  =  =");
        System.out.println("=  ======   ===  =  ===   ===  =  =  ===   ===  =  =");
        System.out.println("====================================================");
        System.out.println("");

        // prints the instrictions
        System.out.println("**See attached picture for pokemon collections**");
        System.out.println("");
        System.out.println("Game Mechanics 1 - How a pokemon loses HP");
        System.out.println("Example: If player one is attacking, the damage dealt to playertwo is calculated through the sum of player one's attack and speed, and subtracted by player two's defence. This is vice-versa when player two is attacking.");
        System.out.println("");
        System.out.println("Game Mechanics 2 - Leveling Up");
        System.out.println("When a player earns a win, they level up. If the player levels up to level 2, they get 50hp added to their chosen of pokemon for the next battle. If the player levels up to level 2, they get 75hp added to their chosen pokemon for the next battle. NOT all pokemon, just the chosen pokemon per battle.");
        System.out.println("");
        System.out.println("Game Mechanics 3 - Introducing the Rage Potion");
        System.out.println("After each player earns a win, they will activate the rage potion, which increases the pokemon's speed and attack.");
        System.out.println("");
        System.out.println("TIP: You may want to choose your best pokemon first so that you can activate rage mode quicker!");
        System.out.println("");

        // prints the statistics for ALL pokemons before battle
        System.out.println("STATISTICS");
        System.out.println("Player One Pokemon Collection");
        System.out.println(player1);
        System.out.println("Player Two Pokemon Collection");
        System.out.println(player2);

        // runs for the 3 battles
        for(int i = 0; i < 3; i++){
            
            roundCounter = 0;

            battleCounter++;
            System.out.println("");
            System.out.println(" BATTLE " + battleCounter);
            System.out.println("");
            
            // asks player one for pokemon selection
            System.out.println("Player One Pokemon Collection");
            System.out.println("1. Vaporeon (Water)");
            System.out.println("2. Rhydon (Ground)");
            System.out.println("3. Exeggutor (Grass)");
            System.out.print("Player One - Choose your pokemon(1-3): ");
            playerOneChoice = input.nextInt();
            System.out.println("");
            
            // Ensures that player one does not select an invalid pokemon
            while(playerOneChoice > 3 || playerOneChoice < 1){
                System.out.println("______Invalid Pokemon______");
                System.out.println("Choose another pokemon: ");
                System.out.println("Player One Pokemon Collection");
                System.out.println("1. Vaporeon (Water)");
                System.out.println("2. Rhydon (Ground)");
                System.out.println("3. Exeggutor (Grass)");
                System.out.print("Player One - Choose your pokemon(1-3): ");
                playerOneChoice = input.nextInt();
                System.out.println("");
            }

            // asks player two for pokemon selection
            System.out.println("Player Two Pokemon Collection");
            System.out.println("1. Jigglypuff (Fairy)");
            System.out.println("2. Muk (Poison)");
            System.out.println("3. Mew (Psychic)");
            System.out.print("Player Two - Choose your pokemon(1-3): ");
            playerTwoChoice = input.nextInt();
            System.out.println("");
            
            // Ensures that player two does not select an invalid pokemon
            while(playerTwoChoice > 3 || playerTwoChoice < 1){
                System.out.println("______Invalid Pokemon______");
                System.out.println("Choose another pokemon: ");
                System.out.println("Player Two Pokemon Collection");
                System.out.println("1. Jigglypuff (Fairy)");
                System.out.println("2. Muk (Poison)");
                System.out.println("3. Mew (Psychic)");
                System.out.print("Player Two - Choose your pokemon(1-3): ");
                playerTwoChoice = input.nextInt();
                System.out.println("");
            }
            
            // Ensures that fainted pokemon cannot be used again
            while((player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth()) <= 0){
                System.out.println("______This pokemon has fainted!______");
                System.out.println("Choose another pokemon: ");
                System.out.println("Player One Pokemon Collection");
                System.out.println("1. Vaporeon (Water)");
                System.out.println("2. Rhydon (Ground)");
                System.out.println("3. Exeggutor (Grass)");
                System.out.print("Player One - Choose your pokemon(1-3): ");
                playerOneChoice = input.nextInt();
                System.out.println("");
            }
            while((player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth()) <= 0){
                System.out.println("______This pokemon has fainted!______");
                System.out.println("Choose another pokemon: ");
                System.out.println("Player Two Pokemon Collection");
                System.out.println("1. Jigglypuff (Fairy)");
                System.out.println("2. Muk (Poison)");
                System.out.println("3. Mew (Psychic)");
                System.out.print("Player Two - Choose your pokemon(1-3): ");
                playerTwoChoice = input.nextInt();
                System.out.println("");
            }
            
            // notifies the players when rage mode is activated
            if(i == 1 && (playerOneWinCount == 1 || playerOneWinCount == 2)){
                System.out.println("Player one has drank the rage potion! RAGE MODE ACTIVATED");
                System.out.println("");
            }
            if(i == 2 && (playerOneWinCount == 1 || playerOneWinCount == 2)){
                System.out.println("Player one has drank the rage potion! RAGE MODE ACTIVATED");
                System.out.println("");
            }
            if(i == 1 && (playerTwoWinCount == 1 || playerTwoWinCount == 2)){
                System.out.println("Player two has drank the rage potion! RAGE MODE ACTIVATED");
                System.out.println("");
            }
            if(i == 2 && (playerTwoWinCount == 1 || playerTwoWinCount == 2)){
                System.out.println("Player two has drank the rage potion! RAGE MODE ACTIVATED");
                System.out.println("");
            }
            
            // activates rage mode
            if(playerOneWinCount == 1){
                player1.currentBattlePokemon(playerOneChoice - 1).setAttack(player1.currentBattlePokemon(playerOneChoice - 1).getActivateRagePotion());
            }
            if(playerTwoWinCount == 1){
                player2.currentBattlePokemon(playerTwoChoice - 1).setAttack(player2.currentBattlePokemon(playerTwoChoice - 1).getActivateRagePotion());
            }
            
            // upgrades the pokemons when in level 2
            if(playerOneLevel == 2){
                player1.currentBattlePokemon(playerOneChoice - 1).newCurrentHealth(player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() + 50);
                player1.currentBattlePokemon(playerOneChoice - 1).setMaxHealth(player1.currentBattlePokemon(playerOneChoice - 1).getMaxHealth() + 50);
            }
            if(playerTwoLevel == 2){
                player2.currentBattlePokemon(playerTwoChoice - 1).newCurrentHealth(player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() + 50);
                player2.currentBattlePokemon(playerTwoChoice - 1).setMaxHealth(player2.currentBattlePokemon(playerTwoChoice - 1).getMaxHealth() + 50);
            }
            
            // upgrades the pokemons when in level 3
            if(playerOneLevel == 3){
                player1.currentBattlePokemon(playerOneChoice - 1).newCurrentHealth(player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() + 75);
                player1.currentBattlePokemon(playerOneChoice - 1).setMaxHealth(player1.currentBattlePokemon(playerOneChoice - 1).getMaxHealth() + 75);
            }
            if(playerTwoLevel == 3){
                player2.currentBattlePokemon(playerTwoChoice - 1).newCurrentHealth(player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() + 75);
                player2.currentBattlePokemon(playerTwoChoice - 1).setMaxHealth(player2.currentBattlePokemon(playerTwoChoice - 1).getMaxHealth() + 75);
            }
            

            // allows pokemons to keep battling until one faints
            while((player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() > 0) && (player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() > 0) ){

                int random = rand.nextInt(10);

                // round counter
                roundCounter++;
                System.out.println("");
                System.out.println("ROUND " + roundCounter);
                
                // calculates how pokemon loses hp by adding one player's attack and speed and subtracting it by the other user's defence
                player1.currentBattlePokemon(playerOneChoice - 1).setDamageFactor(player1.currentBattlePokemon(playerOneChoice - 1).getAttackFactor() - player2.currentBattlePokemon(playerTwoChoice - 1).getDefence() );
                
                player2.currentBattlePokemon(playerTwoChoice - 1).setDamageFactor(player2.currentBattlePokemon(playerTwoChoice - 1).getAttackFactor() - player1.currentBattlePokemon(playerOneChoice - 1).getDefence() );
                
                // applies the damage dealt to pokemon by subtracting the current health with the damage factor calculated above 
                player1.currentBattlePokemon(playerOneChoice - 1).newCurrentHealth(player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() - player2.currentBattlePokemon(playerTwoChoice - 1).getDamageFactor() );
                
                player2.currentBattlePokemon(playerTwoChoice - 1).newCurrentHealth(player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() - player1.currentBattlePokemon(playerOneChoice - 1).getDamageFactor() );
                
                // Ensure a pokemon's health does not go into negative and determines battle winner
                if(player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() < 0 ){
                    player1.currentBattlePokemon(playerOneChoice - 1).newCurrentHealth(0);
                    playerTwoWinCount++;
                    playerTwoLevel++;
                    System.out.println("**Player Two won this battle**");
                }
                if(player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() < 0 ){
                    player2.currentBattlePokemon(playerTwoChoice - 1).newCurrentHealth(0);
                    playerOneWinCount++;
                    playerOneLevel++;
                    System.out.println("**Player One won this battle**");
                }
                
                // prints the statistics for player one every round
                System.out.println( player1.currentBattlePokemon(playerOneChoice - 1).getName() + "(" + player1.currentBattlePokemon(playerOneChoice - 1).getType() + ")   " + player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() + "/" + player1.currentBattlePokemon(playerOneChoice - 1).getMaxHealth() + "hp --- Attack:" + player1.currentBattlePokemon(playerOneChoice - 1).getAttack() + " Defence:" + player1.currentBattlePokemon(playerOneChoice - 1).getDefence() + " Speed:" + player1.currentBattlePokemon(playerOneChoice - 1).getSpeed() + " Rage:" + player1.currentBattlePokemon(playerOneChoice - 1).getRagePotion() );
                
                // prints the statistics for player two every round
                System.out.println( player2.currentBattlePokemon(playerTwoChoice - 1).getName() + "(" + player2.currentBattlePokemon(playerTwoChoice - 1).getType() + ")   " + player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() + "/" + player2.currentBattlePokemon(playerTwoChoice - 1).getMaxHealth() + "hp --- Attack:" + player2.currentBattlePokemon(playerTwoChoice - 1).getAttack() + " Defence:" + player2.currentBattlePokemon(playerTwoChoice - 1).getDefence() + " Speed:" + player2.currentBattlePokemon(playerTwoChoice - 1).getSpeed() + " Rage:" + player2.currentBattlePokemon(playerTwoChoice - 1).getRagePotion()  );

                // makes the battle more interesting by printing battle words inbetween rounds
                if(player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth() > player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth()){
                  System.out.println("Player One is " + battleWords[random] + " Player Two!");
                }
                else if(player2.currentBattlePokemon(playerTwoChoice - 1).getCurrentHealth() > player1.currentBattlePokemon(playerOneChoice - 1).getCurrentHealth()){
                  System.out.println("Player Two is " + battleWords[random] + " Player One!");
                }
                
            }
            
            // prints the levels and wins
            System.out.println("");
            System.out.println("Player One Level: " + playerOneLevel);
            System.out.println("Player Two Level " + playerTwoLevel);
            System.out.println("Player One Wins: " + playerOneWinCount);
            System.out.println("Player Two Wins: " + playerTwoWinCount);
            
        }
        
        System.out.println("");
        System.out.println("-------PROGRAM TERMINATED-------");
        System.out.println("");
        
        // determines the winner of the game
        if(playerOneWinCount > playerTwoWinCount){
            System.out.println("Player One is the WINNER!");
        }
        if(playerTwoWinCount > playerOneWinCount){
            System.out.println("Player Two is the WINNER!");
        }

    }
}
