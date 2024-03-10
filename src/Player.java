public class Player implements Identifiable, Experienced{
    protected String username;
    protected int level;

    public Player(String username, int level) throws Exception{
        this.setUsername(username);
        this.setLevel(level);
    }

    private void setUsername(String username) throws Exception{
        if (username.length() < 5){
            throw new Exception("Username can't be less than 5");
        }
        else
        this.username = username;
    }

    private void setLevel(int level) throws Exception{
        if (level < 0){
            throw new Exception("Level can't be less than 0");
        }
        else
        this.level = level;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int levelUp() {
        return level = level+1;
    }
}
