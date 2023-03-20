import java.util.Scanner;
import java.util.InputMismatchException;

public class ManguKontrollija {
    Tegelane tegelane;
    Boss boss;
    int valik;
    Oskus enneOliKasutatud;

    private boolean tegelaneVoitsid = false, viik = false;

    private boolean mangKestab = true;

    public ManguKontrollija(Tegelane tegelane, Boss boss) {
        this.tegelane = tegelane;
        this.boss = boss;
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
            System.out.println("Te, ei saa praegu kasutada, seda oskust!!!!!!!!!!");
            return false;
        }
        // kui jõuame siiamani, siis saame vahenedaCD
        vahenedaKoikOskused(tegelane);
        oskus.kasutaOskust();
        vordleElmineJaPraeguneOskus(oskus, tegelane, boss);
        enneOliKasutatud = oskus;
        return true;
    }

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
            System.out.println(kesKasutas.getNimi() + "kasutas " + oskus.getNimi() + " " + ((Runnak) oskus).getDmg() + "dmg");
            kedaKontrollime.vahenedaHp(((Runnak) oskus).getDmg());
        }
    }

    public void vahenedaKoikOskused(ManguTegelane tegelane){
        for (Oskus oskus: tegelane.getOskused()){
            oskus.vahenedaOnVajaOodata();
        }
    }

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

    public void naitaManguMenu(){
        System.out.println(tegelane.getNimi() + " " + tegelane.getHp());
        System.out.println(boss.getNimi() + " " + boss.getHp());
        int loendur = Abi.valjastaNumbigaJarjestatudOskus(tegelane.getOskused());
        System.out.println(loendur+". pass");
    }

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
