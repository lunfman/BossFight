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
    public static void main(String[] args) {
        testiTegelane();
    }
}
