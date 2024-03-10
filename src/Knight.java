public class Knight extends Hero {
    public int MAX_STRENGTH = 100;
    protected int strength;
    protected int force;

    public Knight(String username, int level, int health, int strength, int force) throws Exception{
        super(username, level, health);
        this.setStrength(strength);
        this.setForce(force);
        System.out.println(this.toString());
    }

    private void setStrength(int strength) throws Exception{
        if (strength < 1 || strength > 100){
            throw new Exception("Wrong value of strength");
        }
        else
        this.strength = strength;
    }

    private void setForce(int force) throws Exception{
        if (force > strength){
            throw new Exception("Too much power!!!");
        }
        else
        this.force =  force;
    }

    protected boolean fight() {
        if (force > 0 && force <= strength){
            strength = strength - force;
            return true;
        }
        else
        return false;
    }

    @Override
    public boolean change(Weapon nweapon) {
        if (nweapon instanceof Sword){
            System.out.println(username + " change Weapon");
            weapon = nweapon;
            return true;
        }
        else
            System.out.println("Wrong weapon");
        return false;
    }

    @Override
    public String action() {
        if (fight()){
            if (weapon != null) {
                return username + " beat you with force " + force * weapon.getAbility() + " [" + strength + " strength left]";
            }
            else
                return username + " beat you with force " + force + " [" + strength + " strength left]";
        }
        else
        return username + " has no strength";
    }

    @Override
    public boolean useItem(int item) {
        if (this.items[item] instanceof HealthPotion){
            this.recoverHealth(items[item].count);
            items[item].use();
            items[item] = null;
            System.out.println(username + "use HealthPotion");
            return true;
        }
        if (this.items[item] != null && this.items[item] instanceof Food){
            this.strength += items[item].count;
            items[item].use();
            items[item] = null;
            if (strength > MAX_STRENGTH){
                strength = MAX_STRENGTH;
                System.out.println(username + "use Food");
                return true;
            }
        }
           return false;
    }
}
