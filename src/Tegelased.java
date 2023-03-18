import java.util.ArrayList;
import java.util.List;

public class Tegelased {
    public List<Tegelane> tegelased;
    public List<Tegelane> bossid;

    public Tegelased() {
        tegelased = new ArrayList<>();
        bossid = new ArrayList<>();
        lisa();
    }

    public  void lisa (){
        Tegelane t1 = new Tegelane("Char", 100, 101);
        Oskus oskus1 = new Oskus();
        oskus1.nimi = "skill1";
        t1.lisaOskust(oskus1);
        tegelased.add(t1);

        Tegelane t2 = new Tegelane("Boss", 200, 0);
        Oskus oskus2 = new Oskus();
        oskus1.nimi = "skill1";
        t2.lisaOskust(oskus2);
        bossid.add(t2);
    }

    public void getTegelasedInfo(){
        for (Tegelane tegelane: tegelased) {
            System.out.println(tegelane.getInfo());
        }
    }

    public void getBossidInfo(){
        for (Tegelane boss: bossid) {
            System.out.println(boss.getInfo());
        }
    }



}
