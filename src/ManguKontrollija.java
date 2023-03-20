import java.util.Scanner;
import java.util.InputMismatchException;

public class ManguKontrollija {
    Tegelane tegelane;
    Boss boss;
    int valik;
    Oskus enneOliKasutatud;

    private boolean tegelaneVoitsid = false, viik = false, mangijaAlustab;

    private boolean mangKestab = true;

    public ManguKontrollija(Tegelane tegelane, Boss boss) {
        this.tegelane = tegelane;
        this.boss = boss;
        this.mangijaAlustab = Math.random() >= 0.5;
        otsustaKesAlustab();
    }

    public boolean isTegelaneVoitsid() {
        return tegelaneVoitsid;
    }

    public boolean isViik() {
        return viik;
    }

    public boolean isMangKestab() {
        return mangKestab;
    }

    /**
     *  kontrollida, kes võitis ja lõpetada mäng.
     */
    public void leiaVoitjat(){
        if(tegelane.getHp() <= 0 && boss.getHp() <= 0){
            System.out.println("Viik");
            mangKestab = false;
            viik = true;
            return;
        }

        if(tegelane.getHp() <= 0) {
            System.out.println("Kaotus");
            mangKestab = false;
            return;
        }
        if (boss.getHp() <= 0) {
            System.out.println("Võit");
            tegelaneVoitsid = true;
            mangKestab = false;
        }
    }

    /**
     * Kontrollime, mida kasutaja sisestas. Kontrollime, kas oli kasutatud pass.
     * Vaatame, kas mängija saab kasutada oma oskusi. Kui vaja, siis me vähendame cd ooteaega.
     * Kirjutame, et oskus oli ära kasutatud. Vaatame, mida boss kasutas.
     * @return true kui kõik on korras
     */
    public boolean valideeriOskust(){
        if(valik > tegelane.getOskused().size()  || valik < 0){
            System.out.println("Vale vaartus !!!!!!");
            return false;
        }

        if(valik == tegelane.getOskused().size()){
            vahenedaKoikOskused(tegelane);
            enneOliKasutatud = null;
            return true;
        }

        Oskus oskus = tegelane.getOskus(valik);

        if(!oskus.getSaanKasutada()){
            System.out.println("Te ei saa praegu seda oskust kasutada.!!!!!!!!!!");
            return false;
        }
        // kui jõuame siiamani, siis saame vahenedaCD
        vahenedaKoikOskused(tegelane);
        oskus.kasutaOskust();
        vordleElmineJaPraeguneOskus(oskus, tegelane, boss);
        enneOliKasutatud = oskus;
        return true;
    }

    /**
     * Võrdleme, mida oponent kasutas ja arvutame, mis juhtub.
     * Siin kontrollime nt VastuRünnal - Rünnal, Kaitse - Rünnak, Rõnnak - Rünnak
     * @param oskus mis oskus oli just kasutatud
     * @param kesKasutas kes kasutas oskust
     * @param kedaKontrollime kellega, võrdleme
     */
    public void vordleElmineJaPraeguneOskus(Oskus oskus, ManguTegelane kesKasutas, ManguTegelane kedaKontrollime){
        if(oskus instanceof VastuRunnak){
            return;
        }
       if (oskus instanceof Runnak) {
            if(enneOliKasutatud instanceof Kaitse){
                System.out.println(kedaKontrollime.getNimi()+" kasutas kaitset,"+kesKasutas.getNimi() +"rünnak ebaõnnestas");
                return;
            }else if(enneOliKasutatud instanceof VastuRunnak){
                System.out.println(kedaKontrollime.getNimi()+" kasutas vasturünnakut, rünnak ebaõnnestus ja "+ kesKasutas.getNimi() +" hp kahanes " +((Runnak) enneOliKasutatud).getDmg() + "võrra");
                kesKasutas.vahenedaHp(((Runnak) enneOliKasutatud).getDmg());
                return;
            }
            System.out.println(kesKasutas.getNimi() + " kasutas " + oskus.getNimi() + " " + ((Runnak) oskus).getDmg() + "dmg");
            kedaKontrollime.vahenedaHp(((Runnak) oskus).getDmg());
        }
    }

    /**
     * vähendame kõik oskused tegelase või bossi jaoks.
     * @param tegelane ehk ManguTegelane , kas Boss või Tegelane
     */
    public void vahenedaKoikOskused(ManguTegelane tegelane){
        for (Oskus oskus: tegelane.getOskused()){
            oskus.vahenedaOnVajaOodata();
        }
    }

    /**
     * Bossi aju ..
     * valime juhusliku oskuse ja kasutame seda, kui võimalik, muidu kasutame passi.
     */
    public void ründaTegelast(){
        Oskus oskus = boss.getSuvalineOskus();

        if(oskus.getSaanKasutada()){
            vahenedaKoikOskused(boss);
            oskus.kasutaOskust();
            vordleElmineJaPraeguneOskus(oskus, boss, tegelane);
            enneOliKasutatud = oskus;
            return;
        }
        enneOliKasutatud = null;
        vahenedaKoikOskused(boss);

    }

    /**
     * Kuvab mängumenüü
     */
    public void naitaManguMenu(){
        System.out.println(tegelane.getNimi() + " " + tegelane.getHp());
        System.out.println(boss.getNimi() + " " + boss.getHp());
        int loendur = Abi.valjastaNumbigaJarjestatudOskus(tegelane.getOskused());
        System.out.println(loendur+". pass");
    }

    /**
     * juhuslikult valime, kes alustab mängu
     */
    public void otsustaKesAlustab(){
        if(!mangijaAlustab){
            System.out.println("Boss Alustab");
            mangijaAlustab = true;
            ründaTegelast();
        }
    }

    // "põhi meetood klassis"
    public void valjastaMangijaMenu(){
        leiaVoitjat();
        naitaManguMenu();
        Scanner scanner = new Scanner(System.in);
        try {
            valik = scanner.nextInt()-1;
        }catch (InputMismatchException e){
            Abi.valjastaValeAndmed();
            return;
        }
        if(valideeriOskust()){
            ründaTegelast();
            leiaVoitjat();
        };
    }
}
