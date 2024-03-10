public interface Inventory {
    final public int ITEMS = 5;
    public boolean put(Item item, int num);
    public boolean useItem(int num1);
}
