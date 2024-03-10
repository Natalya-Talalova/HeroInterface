import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Hero> players = new ArrayList<>();

            Hero legolas = new Elf("Legolas ", 1, 70, 1);
            Hero arthur = new Knight("Arthur", 35, 70, 100, 12);
            Hero merlin = new Wizard("Merlin " , 100, 70, 100, 80);

            legolas.put(new HealthPotion(5), 1);
            legolas.useItem(1);

            System.out.println(legolas.toString());

            arthur.change(new Sword (2.5));
            merlin.change(new Sword (2.5));
            arthur.dress(new Boots(4),1);
            arthur.dress(new Boots(4),1);

            merlin.levelUp();
            players.add(legolas);
            players.add(arthur);
            players.add(merlin);
            for (Hero hero : players) {
                System.out.println(hero.action());
                System.out.println(hero.action());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
