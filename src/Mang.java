import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Mang {
    int valik;
    boolean jookseb = true, bossValitud = false;

    Tegelased tegelased = new Tegelased();
    Tegelane tegelaseValik;
    Boss bossiValik;

    /**
     * Mängu lõpus arvutame selle metoodi abil, kui palju xpt peab tegelane saama.
     * @param tulemusViik väärtus on võimalik saada ManguKontrollija klassist
     * @param tegelaneVoitsid väärtus on võimalik saada ManguKontrollija klassist
     */
    public void arvutaTegelaseXP(boolean tulemusViik, boolean tegelaneVoitsid){
        if(tulemusViik){
            System.out.println("XP: 5");
        }
        else if(tegelaneVoitsid){
            System.out.println("Xp: 10");
        }
        else {
            System.out.println("XP: 2");
        }
    }

    /**
     * Meetod väljästab ekraanil kõik võimalikud mängutegelased, lisaks kontrolib, mida kasutajas sisestas.
     *
     * @param kirjeldus - String mida väljästatakse ekranile alguses
     * @param manguTegelased - ManguTegelane List
     * @return tagastab õige valiku või -1 juhul, kui valideerimine ebaõnnestus
     */

    public int naitaValikMenu(String kirjeldus, List<ManguTegelane> manguTegelased){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(kirjeldus);
            int loendur = Abi.valjastaNumbigaJarjestatud(manguTegelased);
            System.out.println(loendur + ". tagasi");
            valik = scanner.nextInt();
            return valik;
        }catch (InputMismatchException e){
            Abi.valjastaValeAndmed();
            return -1;
        }
    }

    /**
     *  Kuvab kõik bossid keda on võimalik valida ja lisaks valideerib valiku.
     */
    public void valiBossi(){
        valik = naitaValikMenu("Vali bossi:", tegelased.bossid);
        if(valik > 0 && valik <= tegelased.bossid.size()){
            bossiValik = (Boss) tegelased.bossid.get(valik-1);
            bossValitud = true;
            return;
        }
        if(valik == tegelased.bossid.size()+1){
            jookseb = false;
            return;
        }

        Abi.valjastaValeAndmed();
    }
    /**
     *  Kuvab kõik tegelased keda on võimalik valida ja lisaks valideerib valiku.
     */
    public boolean valiCharacteri(){
        valik = naitaValikMenu("Vali character:", tegelased.tegelased);
        System.out.println(valik);
        if(valik > 0 && valik <= tegelased.tegelased.size()){
            tegelaseValik = (Tegelane) tegelased.tegelased.get(valik-1);
            return true;
        }

        if(valik == -1){
            return false;
        }else if(valik == tegelased.tegelased.size() + 1){
            bossValitud = false;
            return false;
        }
        Abi.valjastaValeAndmed();
        return false;
    }

    /**
     *  loob ManguKontrollija ja kontrollib kas mäng veel kestab või mitte, kui mäng on läbi, siis
     *  arvutame xpt ja viskame tagasi pea ekraanile
     */
    public void alustaMangu(){
        ManguKontrollija manguKontrollija = new ManguKontrollija(tegelaseValik, bossiValik);
        while (manguKontrollija.isMangKestab()){
            manguKontrollija.valjastaMangijaMenu();
        }
        arvutaTegelaseXP(manguKontrollija.isViik(), manguKontrollija.isTegelaneVoitsid());
        jookseb = false;

    }

    public void avaManguMenu(){
        if(!bossValitud) valiBossi();
        if(!jookseb || !bossValitud) return;
        if(valiCharacteri()){
            alustaMangu();
        }
    }

    public void alusta(){
        while (jookseb){
            avaManguMenu();
        }
    }

}
