import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void naidataErrori(String tekst){
        System.out.println("\u001B[31m"+tekst+"\u001B[0m");
    }

    public static void naidataOk(String tekst){
        System.out.println("\u001B[32m" + tekst + "\u001B[32m");
    }

    public static void testi(int tulemus, int peabOlema, String kirjeldus){
        if(tulemus != peabOlema){
            naidataErrori("[-] Ootasin: " + peabOlema + ", aga sain: " + tulemus);
        }else{
            naidataOk("[+] - "+kirjeldus);
        }
    }

    public static void testi(boolean tulemus, boolean peabOlema, String kirjeldus){
        if(tulemus != peabOlema){
            naidataErrori("[-] Ootasin: " + peabOlema + ", aga sain: " + tulemus);
        }else{
            naidataOk("[+] - "+kirjeldus);
        }
    }

    public static void testi(String tulemus, String peabOlema, String kirjeldus){
        if(!tulemus.equals(peabOlema)){
            naidataErrori("[-] Ootasin: " + peabOlema + ", aga sain: " + tulemus);
        }else{
            naidataOk("[+] - "+kirjeldus);
        }
    }

    public static void testiTegelane(){
        System.out.println("Tegelane klass test");
        String nimi = "Lord";
        String tulemus;
        int hp = 100;
        int xp = 0;
        Tegelane tegelane = new Tegelane(nimi, hp, xp);

        String kirjeldus = "Tegelane nimi get metood";
        testi(tegelane.getNimi(), nimi, kirjeldus);

        kirjeldus = "Tegelane xp get meetod";
        testi(tegelane.getXp(), 0, kirjeldus);

        kirjeldus = "Tegelane hp get meetod";
        testi(tegelane.getHp(), 100, kirjeldus);

        kirjeldus = "Tegelane toString meetod";
        testi(tegelane.toString(), nimi, kirjeldus);

        kirjeldus = "Tegelane getInfo meetod";
        tulemus = "Nimi: Lord LVL:1 HP:100 XP:0";
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Tegelane setXp, arvutaLvl, surendaHpXpBaasil xp = 99";
        tulemus = "Nimi: Lord LVL:1 HP:100 XP:99";
        tegelane.setXp(99);
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Tegelane setXp, arvutaLvl, surendaHpXpBaasil xp = 100";
        tulemus = "Nimi: Lord LVL:1 HP:100 XP:100";
        tegelane.setXp(100);
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Tegelane setXp, arvutaLvl, surendaHpXpBaasil xp = 101";
        tulemus = "Nimi: Lord LVL:2 HP:110 XP:101";
        tegelane.setXp(101);
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Tegelane setXp, arvutaLvl, surendaHpXpBaasil xp = 300";
        tulemus = "Nimi: Lord LVL:3 HP:120 XP:300";
        tegelane.setXp(300);
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Tegelane setXp, arvutaLvl, surendaHpXpBaasil xp = 1000";
        tulemus = "Nimi: Lord LVL:10 HP:190 XP:1000";
        tegelane.setXp(1000);
        testi(tegelane.getInfo(), tulemus, kirjeldus);

        kirjeldus = "Vähenda HP test, kasutame mängus";
        tegelane.setXp(xp);
        tegelane.vahenedaHp(23);
        testi(tegelane.getHp(), 77, kirjeldus);

        kirjeldus = "Surenda HP test, kasutame mängus";
        tegelane.surendaHp(24);
        testi(tegelane.getHp(), 101, kirjeldus);

        // on vaja veel testida getOskused, getNorkused, lisaNorkus, lisaOskus



    }

    public static void testiBoss(){
        System.out.println();
        System.out.println("Test boss klass");
        String nimi = "Boss";
        int hp = 100;
        Boss boss = new Boss(nimi, hp);

        String kirjeldus = "Boss getInfo meetod";
        testi(boss.getInfo(), "Nimi: "+nimi + " HP:"+ hp, kirjeldus);

        kirjeldus = "Boss toString meetod";
        testi(boss.toString(), nimi, kirjeldus);

        kirjeldus = "Boss lisaOskus and getOskus test";
        Oskus oskus1 = new Runnak("t", 1, 10);

        boss.lisaOskust(oskus1);

        testi(boss.getOskused().size(), 1, kirjeldus);
    }

    public static void testiOskus(){
        System.out.println();
        System.out.println("Test Runnak");

        String nimi = "Attack 1";
        int cd = 1;

        Oskus oskus = new Runnak(nimi ,cd, 10);

        String kirjeldus = "Test toString meetod";
        String peabOlema = "Attack 1 (10 dmg) (1 cd)";
        testi(oskus.toString(), peabOlema, kirjeldus);

        kirjeldus = "Test getNimi";
        testi(oskus.getNimi(), nimi, kirjeldus);

        kirjeldus = "Test getCD";
        testi(oskus.getCd(), 1, kirjeldus);

        kirjeldus = "Test getSaanKasutada";
        testi(oskus.getSaanKasutada(), true, kirjeldus);

        kirjeldus = "kasutaOskust -> ei saa kasutada";
        oskus.kasutaOskust();
        testi(oskus.getSaanKasutada(), false, kirjeldus);
        peabOlema = "Attack 1 (10 dmg) (1 cd) (saab kasutada jargmisel sammul)";
        kirjeldus = "kui ei saa kasutada, siis peab olema teave, et saan " +
                "kasutada jargmisel sammul";
        testi(oskus.toString(), peabOlema, kirjeldus);

        kirjeldus = "vahenedaOnVajaOodata -> true kuna cd 1";
        oskus.vahenedaOnVajaOodata();
        testi(oskus.getSaanKasutada(), true, kirjeldus);

        kirjeldus = "Kasutame oskust, millel cd on 3, ja kontrollime toString";
        oskus = new Runnak(nimi, 3, 10);
        oskus.kasutaOskust();
        peabOlema = "Attack 1 (10 dmg) (3 cd) (saab kasutada parast 3 sammu)";
        testi(oskus.toString(), peabOlema, kirjeldus);

        System.out.println();
        System.out.println("Test Kaitse");
        kirjeldus = "Kaitse toString";
        oskus = new Kaitse("Kaitse 1",cd);
        peabOlema = "Kaitse 1 (1 cd)";
        testi(oskus.toString(), peabOlema, kirjeldus);

    }

    public static void testiManguKontrollija(){
        System.out.println("Test Mangu Kontrollija");
        String nimi = "Lord";
        int hp = 100;
        int xp = 0;
        Tegelane tegelane = new Tegelane(nimi, hp, xp);

        // oskus
        String attackNimi = "Attack 1";
        int cd = 1;
        Oskus oskus = new Runnak(attackNimi ,cd, 10);
        tegelane.lisaOskust(oskus);



        String nimib = "Boss";
        int hpb = 100;
        Boss boss = new Boss(nimib, hpb);

        ManguKontrollija mk = new ManguKontrollija(tegelane, boss, true);

        String kirjeldus = "Kontrollime vaartust mangijaVoitsud";
        testi(mk.isTegelaneVoitsid(), false, kirjeldus);

        tegelane.setHp(0);
        mk.leiaVoitjat();
        kirjeldus = "Kontrollime mis juhtub, kui mangija hp = 0 ja kas mang veel kestab";
        testi(mk.isTegelaneVoitsid(), false, kirjeldus);
        testi(mk.isMangKestab(), false, kirjeldus);

        kirjeldus = "Kontrollime mis juhtub kui boss hp = 0 ja mangija hp = 0";
        mk = new ManguKontrollija(tegelane, boss, true);
        tegelane.setHp(0);
        boss.setHp(0);
        mk.leiaVoitjat();
        testi(mk.isTegelaneVoitsid(), false, kirjeldus);
        testi(mk.isMangKestab(), false, kirjeldus);
        testi(mk.isViik(), true, kirjeldus);

        kirjeldus = "Kontrollime mis juhtub kui mängija võitsid";
        mk = new ManguKontrollija(tegelane, boss, true);
        boss.setHp(0);
        tegelane.setHp(100);
        mk.leiaVoitjat();
        testi(mk.isTegelaneVoitsid(), true, kirjeldus);
        testi(mk.isMangKestab(), false, kirjeldus);
        testi(mk.isViik(), false, kirjeldus);

        // valideeriOskust

        kirjeldus = "Tegelnae saab kasutada oskust";
        mk = new ManguKontrollija(tegelane, boss, true);
        mk.setValik(0);
        testi(mk.valideeriOskust(), true, kirjeldus);

        kirjeldus = "Nuud tegelane, ei saa kusutada oskust, sest cd on 1";
        testi(mk.valideeriOskust(), false, kirjeldus);

        mk.vahenedaKoikOskused(tegelane);
        kirjeldus = "vahenedaKoikOskused,  cd on labi";
        testi(mk.valideeriOskust(), true, kirjeldus);

        kirjeldus = "Vale valik";
        mk.setValik(-1);
        testi(mk.valideeriOskust(), false, kirjeldus);

        kirjeldus = "Vale valik liiga suur";
        mk.setValik(2);
        testi(mk.valideeriOskust(), false, kirjeldus);

    }

    public static void testiAbi(){
        String nimi = "Lord";
        int hp = 100;
        int xp = 0;
        Tegelane tegelane = new Tegelane(nimi, hp, xp);

        String attackNimi = "Attack 1";
        int cd = 1;
        Oskus oskus = new Runnak(attackNimi ,cd, 10);
        tegelane.lisaOskust(oskus);


        String nimib = "Boss";
        int hpb = 100;
        Boss boss = new Boss(nimib, hpb);

        List<ManguTegelane> tegelased = new ArrayList<>();
        tegelased.add(tegelane);

        String kirjeluds = "Abi tagastba järmine number";
        testi(Abi.valjastaNumbigaJarjestatud(tegelased), 2, kirjeluds);

        kirjeluds = "Abi tagastba järmine oskus";
        testi(Abi.valjastaNumbigaJarjestatudOskus(tegelane.getOskused()), 2, kirjeluds);

    }

    public static void main(String[] args) {
        testiTegelane();
        testiBoss();
        testiOskus();
        testiManguKontrollija();
        testiAbi();
    }
}
