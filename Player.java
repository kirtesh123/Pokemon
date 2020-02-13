import java.util.ArrayList;

public class Player{
    
    // attributes 
    private int playerChoice;
    private ArrayList<Pokemon> list;

    public Player(){
      this.list = new ArrayList<Pokemon>();
    }

    /**  Adds the pokemon's to an array list
    *    @param name - the name of the pokemon
    *    @param type - the type of the pokemon 
    *    @param currentHealth - the current health of the pokemon
    *    @param maxHealth - the maximum health of the pokemon
    *    @param attack - the attack of the pokemon
    *    @param defence - the defence of the pokemon
    *    @param speed - the speed of the pokemon
    *    @param ragePotion - the rage factor of the pokemon
    */
    public void pokeArray(String name, String type, int currentHealth, int maxHealth, int attack, int defence, int speed, int ragePotion){
        Pokemon add = new Pokemon(name, type, currentHealth, maxHealth, attack, defence, speed, ragePotion);
        list.add(add);
    }
    
    /** Collects the user's pokemon selection
    *   @return list.get(playerChoice) - Returns the pokemon object selected
    *   @param playerChoice - the player's pokemon selection
    */
    public Pokemon currentBattlePokemon(int playerChoice){
        this.playerChoice = playerChoice;
        return list.get(playerChoice);
    }
    
    /** Returns the statistics for each pokemon
    *   @return toReturn - the pokemon statistics
    */
    public String toString(){
        String toReturn = "";
        for(Pokemon x : list){
          toReturn += x.toString() + "\n";
        }
        return toReturn;
    }
    
}
