
public abstract class Item {

    public void equip(Creature c){
        if(c.equipable() == true){
            c.setAttack(c.getAttack() + getAttackBuff());
            c.setHealth(c.getHealth() + getHealthBuff());
            c.setHunger(c.getHunger() + getHungerBuff());
        }
        else System.out.println("Creature cannot equip items");
    }

    public abstract int getAttackBuff();
        
    public abstract int getHealthBuff();

    public abstract int getHungerBuff();
    
    public abstract void setAttackBuff(int attackB);
    
    public abstract void setHealthBuff(int healthB);
    
    public abstract void setHungerBuff(int hungerB);

}