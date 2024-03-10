public class Wizard extends Hero{
    public int MAX_MANA = 100;
    protected int mana;
    protected int spell;

    public Wizard(String username, int level, int health, int mana, int spell) throws Exception{
        super(username, level, health);
        this.setMana(mana);
        this.setSpell(spell);
        System.out.println(this.toString());
    }

    public void setMana(int mana) throws Exception{
        if (mana < 1 || mana > 100){
            throw new Exception("Wrong value of mana");
        }
        this.mana = mana;
    }

    public void setSpell(int spell) throws Exception{
        if (spell > mana){
            throw new Exception("Wrong value of spell");
        }
        this.spell = spell;
    }

    protected boolean spell(){
        if (spell > 0 && spell <= mana){
            mana = mana - spell;
            return true;
        }
        return false;
    }


    @Override
    public boolean change(Weapon vweapon) {
        if (vweapon instanceof Staff){
            System.out.println(username + " change Weapon");
            weapon = vweapon;
            return true;
        }
        else
            System.out.println("Wrong weapon");
        return false;
    }

    @Override
    public String action() {
        if (spell()){
            if (weapon != null) {
                return username + "throws at you a fireball with power " + spell* weapon.getAbility() + " [" + mana + " mana left]";
            }
            return username + "throws at you a fireball with power " + spell + " [" + mana + " mana left]";
        }
        else
        return username + "has no mana";
    }

    @Override
    public boolean useItem(int item) {
        if (this.items[item] != null && this.items[item] instanceof HealthPotion){
            this.recoverHealth(items[item].count);
            items[item].use();
            items[item] = null;
            System.out.println(username + "use HealthPotion");
            return true;
        }
        if (this.items[item] != null && this.items[item] instanceof ManaPotion){
            this.mana += items[item].count;
            items[item].use();
            items[item] = null;
            if (mana > MAX_MANA){
                mana = MAX_MANA;
                System.out.println(username + "use ManaPotion");
                return true;
            }
        }
        return false;
    }

}
