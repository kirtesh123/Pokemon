public class Pokemon{
    
    // attributes
    private String name;
    private String type;
    private int currentHealth;
    private int maxHealth;
    private int ragePotion;
    private int defence;
    private int speed;
    private int attack;
    private int attackFactor;
    private int damageFactor;
    

    /** Constucts a pokemon with the given paramter values
    *    @param name - the name of the pokemon
    *    @param type - the type of the pokemon 
    *    @param currentHealth - the current health of the pokemon
    *    @param maxHealth - the maximum health of the pokemon
    *    @param attack - the attack of the pokemon
    *    @param defence - the defence of the pokemon
    *    @param speed - the speed of the pokemon
    *    @param ragePotion - the rage factor of the pokemon
    */
    public Pokemon(String name, String type, int currentHealth, int maxHealth, int attack, int defence, int speed, int ragePotion){
        this.name = name;
        this.type = type;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.ragePotion = ragePotion;
    }
    
    /** Returns the pokemon's name
    *   @return name - the name of the pokemon
    */
    public String getName(){
        return this.name;
    }

    /** Returns the pokemon's type
    *   @return type - the type of the pokemon
    */
    public String getType(){
        return this.type;
    }
    
    /** Returns the pokemon's maximum health
    *   @return maxHealth - the maximum health of the pokemon
    */
    public int getMaxHealth(){
        return this.maxHealth;
    }
    
    /** sets the maximum health with the given parmater value
    *   @param maxHealth - the maximum health of the pokemon
    */
    public void setMaxHealth( int maxHealth){
        this.maxHealth = maxHealth;
    }
    
    /** Returns the pokemon's attack
    *   @return attack - the attack of the pokemon
    */
    public int getAttack(){
        return this.attack;
    }
  
    /** sets the attack with the given parmater value
    *   @param newAttack - the attack of the pokemon
    */
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }
    
    /** Returns the pokemon's defence
    *   @return defence - the defence of the pokemon
    */
    public int getDefence(){
        return this.defence;
    }
    
    /** Returns the pokemon's speed
    *   @return speed - the speed of the pokemon
    */
    public int getSpeed(){
        return this.speed;
    }
    
    /** Returns the pokemon's current health
    *   @return currentHealth - the current health of the pokemon
    */
    public int getCurrentHealth(){
        return this.currentHealth;
    }
    
    /** sets the current health with the given parmater value
    *   @param newHealth - the current health of the pokemon
    */
    public void newCurrentHealth(int newHealth){
        this.currentHealth = newHealth;
    }
    
    /** Returns the pokemon's damage factor
    *   @return damageFactor - the damage factor of the pokemon
    */
    public int getDamageFactor(){
        return this.damageFactor;
    }
    
    /** sets the damage factor with the given parmater value
    *   @param damageFactor - the damage factor of the pokemon
    */
    public void setDamageFactor(int damageFactor){
        this.damageFactor = damageFactor;
    }
    
    /** Returns the pokemon's attack factor (attack + speed)
    *   @return attackFactor - the attack factor (attack + speed) of the pokemon
    */
    public int getAttackFactor(){
        this.attackFactor = this.attack + this.speed;
        return this.attackFactor;
    }
    
    /** Returns the pokemon's rage potion value
    *   @return ragePotion - the rage potion value of the pokemon
    */
    public int getRagePotion(){
        return this.ragePotion;
    }
    
    /** Returns the pokemon's rage mode value (attack + ragePotion)
    *   @return attack + rage - the rage mode value of the pokemon through the sum of attack and rage
    */
    public int getActivateRagePotion(){
        return this.attack + this.ragePotion;
    }

    public String toString(){
      return "Name:" + name + " Type:" + type +  " Health:" + maxHealth + " Attack:" + attack + " Defence:" + defence + " Speed:" + speed + " Rage:" + ragePotion;
    }

}

