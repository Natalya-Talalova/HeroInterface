public class Clothes implements Armor{
    protected int durability;

    public Clothes(int durability) throws Exception{
        this.setDurability(durability);
    }

    public void setDurability(int durability) throws Exception{
        if (durability < 1 || durability > 5){
            throw new Exception("That's bedrock");
        }
        else
        this.durability = durability;
    }

    /**
     * Если destroy > 0, то весь дамаг уходит водежду, если destroy < 0, то дамаг перекидывается на персонажа
     * @param num
     * @return
     */
    @Override
    public int destroy(int num) {
        return durability = durability-num;
    }

    @Override
    public boolean isBroken() {
        if (durability < 1){
            return true;
        }
        else
        return false;
    }
}
