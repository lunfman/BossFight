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
        Runnak oskus1 = new Runnak("Runnak 1", 1, new String[]{"ok"}, "ok", 10);
        Kaitse oskus2 = new Kaitse("Kaitse", 2, new String[]{"ok"}, "ok");
        Runnak oskus3 = new Runnak("Runnak 2", 2, new String[]{"ok"}, "ok", 30);
        VastuRunnak oskus4 = new VastuRunnak("Vastu runnak", 3,  new String[]{"ok"}, "ok", 30);
        t1.lisaOskust(oskus1);
        t1.lisaOskust(oskus2);
        t1.lisaOskust(oskus3);
        t1.lisaOskust(oskus4);
        tegelased.add(t1);

        Boss t2 = new Boss("Boss", 200);
        Runnak oskus5 = new Runnak("Skill1", 3, new String[]{"ok"}, "ok", 30);
        Kaitse oskus6 = new Kaitse("Skill2", 2, new String[]{"ok"}, "ok");
        Runnak oskus7 = new VastuRunnak("Skill3", 2, new String[]{"ok"}, "ok", 10);
        Runnak oskus8 = new VastuRunnak("Skill4", 2, new String[]{"ok"}, "ok", 10);

        t2.lisaOskust(oskus5);
        t2.lisaOskust(oskus6);
        t2.lisaOskust(oskus7);
        t2.lisaOskust(oskus8);
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
