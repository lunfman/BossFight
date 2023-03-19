import java.util.ArrayList;
import java.util.List;

public class Tegelased {
    public List<ManguTegelane> tegelased;
    public List<ManguTegelane> bossid;

    public Tegelased() {
        tegelased = new ArrayList<>();
        bossid = new ArrayList<>();
        lisa();
    }

    public  void lisa (){
        Tegelane t1 = new Tegelane("Char", 100, 101);
        Oskus oskus1 = new Oskus("Skill1", 10, 1, new String[]{"ok"}, "ok");
//        oskus1.nimi = "skill1";
        t1.lisaOskust(oskus1);
        tegelased.add(t1);

        Boss t2 = new Boss("Boss", 200);
        Oskus oskus2 = new Oskus("Skill1", 10, 1, new String[]{"ok"}, "ok");
//        oskus1.nimi = "skill1";
        t2.lisaOskust(oskus2);
        bossid.add(t2);
    }

    public void getTegelasedInfo(){
        for (ManguTegelane tegelane: tegelased) {
            System.out.println(tegelane.getInfo());
        }
    }

    public void getBossidInfo(){
        for (ManguTegelane boss: bossid) {
            System.out.println(boss.getInfo());
        }
    }
}
