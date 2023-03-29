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
        Tegelane t1 = new Tegelane("Frost the Icicle Warrior", 100, 101);
        Runnak oskus1 = new Runnak("Mighty Bash 1", 1,  10);
        Kaitse oskus2 = new Kaitse("Steel Shield", 2);
        Runnak oskus3 = new Runnak("Brave Stab", 2, 30);
        VastuRunnak oskus4 = new VastuRunnak("Gallant Parry", 3, 30);
        t1.lisaOskust(oskus1);
        t1.lisaOskust(oskus2);
        t1.lisaOskust(oskus3);
        t1.lisaOskust(oskus4);
        tegelased.add(t1);

        Boss t2 = new Boss("Inferno the Firestarter", 200);
        Runnak oskus5 = new Runnak("Blazing Inferno Blast II", 3, 30);
        Kaitse oskus6 = new Kaitse("Steel Fortress", 2);
        Runnak oskus7 = new Runnak("Blazing Inferno Blast I", 2, 10);
        Runnak oskus8 = new VastuRunnak("Earthquake Tremor", 2, 10);

        t2.lisaOskust(oskus5);
        t2.lisaOskust(oskus6);
        t2.lisaOskust(oskus7);
        t2.lisaOskust(oskus8);
        bossid.add(t2);

        Boss t3 = new Boss("Zephyr the Windrider", 300);
        Runnak oskus9 = new Runnak("Thunderclap Smash", 3, 80);
        VastuRunnak oskus10 = new VastuRunnak("Venomous Fang Strike Counter", 2, 50);
        Runnak oskus11= new Runnak("Frostbite Chill", 1, 30);
        Runnak oskus12 = new VastuRunnak("Cyclone Spin", 2, 35);

        t3.lisaOskust(oskus9);
        t3.lisaOskust(oskus10);
        t3.lisaOskust(oskus11);
        t3.lisaOskust(oskus12);
        bossid.add(t3);
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
