public abstract class Hero extends Player implements Healthy, Armed, Inventory {
    protected int health;
    protected Weapon weapon;
    protected Clothes[] clothes = new Clothes[CLOTHES];
    protected Item[] items = new Item[ITEMS];

    public Hero(String username, int level, int health) throws Exception{
        super(username, level);
        this.setHealth(health);
    }

    private void setHealth(int health) throws Exception{
        if (health < 0 || health > 100){
            throw new Exception("Wrong value of health");
        }
        else
        this.health = health;
    }

    @Override
    public abstract boolean change(Weapon weapon);

    @Override
    public boolean dress(Clothes clothe, int clot) {
        for (Clothes clothee : clothes) {
            if (clothee != null) {
                if (clothee instanceof Boots && clothe instanceof Boots) {
                    System.out.println("You aren't allowed to wear 2 socks");
                    return false;
                }
                if (clothee instanceof Helmet && clothe instanceof Helmet) {
                    System.out.println("You aren't allowed to wear 2 caps");
                    return false;
                }
                if (clothee instanceof Dress && clothe instanceof  Dress) {
                    System.out.println("You aren't allowed to wear 2 caps");
                    return false;
            }
        }
    }
        clothes[clot] = clothe;
        System.out.println(username + " change " + clothe.getClass().getSimpleName());
        return true;
    }



    @Override
    public abstract String action();

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void recoverHealth(int count) {
        this.health += count;
        if (health > MAX_HEALTH){
            health = MAX_HEALTH;
        }
    }


    @Override
    public boolean put(Item item, int num) {
        if (num > 0 && num < 4){
            items[num] = item;
            System.out.printf("%sput %s\n", this.getUsername(), item.getClass().getSimpleName());
            return true;
        }
        else
            System.out.println("Wrong key");
            return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + username +"[" + level + " level, " + health + " health] is online";
    }

    @Override
    public abstract boolean useItem(int num1);
}
