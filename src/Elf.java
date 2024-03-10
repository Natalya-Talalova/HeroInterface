public class Elf extends Hero{
    protected int arrowsCount;

    public Elf(String username, int level, int health, int arrowsCount) throws Exception{
        super(username, level, health);
        this.setArrows(arrowsCount);
        System.out.println(this.toString());
    }

    private void setArrows(int arrowsCount) throws Exception{
        if (arrowsCount < 1 || arrowsCount > 100){
            throw new Exception("Wrong value of arrows count");
        }
        this.arrowsCount = arrowsCount;
     }

     private boolean shootArrow(){
        if (arrowsCount > 0){
            return true;
        }
        return false;
     }

    @Override
    public boolean change(Weapon eweapon) {
        if (eweapon instanceof Bow){
            System.out.println(username + " change Weapon");
            weapon = eweapon;
            return true;
        }
        else
            System.out.println("Wrong weapon");
        return false;
    }

    @Override
    public String action() {
        if (shootArrow()){
            if (weapon != null) {
                arrowsCount-=arrowsCount;
                return username + "shoot arrow with strength" + arrowStrength()*weapon.getAbility() + " [" + arrowsCount +" arrows left]";
            }
            arrowsCount-=arrowsCount;
            return username + "shoot arrow [" + arrowsCount +" arrows left]";
        }
        else
        return username + "has no arrows";
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
        else
        return false;
    }

    private int arrowStrength(){
        return 1;
    }
}

