public class Weapon implements Arming{
    protected double ability;

    protected Weapon(double ability) throws Exception{
        this.setAbility(ability);
    }

    protected void setAbility(double ability) throws Exception{
        if (ability < 1 || ability > 5){
            throw new Exception("Too much power!");
        }
        this.ability = ability;
    }

    public double getAbility() {
        return ability;
    }
}
