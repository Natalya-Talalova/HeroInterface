public class Item implements Thing{
    protected int count;

    public Item(int count) throws Exception{
        this.setCount(count);
    }

    protected void setCount(int count) throws Exception{
        if (count < 1 || count > 5){
            throw new Exception("Wrong walue of items count");
        }
        this.count = count;
    }

    @Override
    public int use() {
        if (isUsed()){
            return 0;
        }
        else
            count = 0;
        return 0;
    }

    @Override
    public boolean isUsed() {
        if (count < 1){
            return true;
        }
        else
        return false;
    }
}
