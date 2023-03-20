import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Mang {
    int valik;
    boolean jookseb = true, bossValitud = false;

    Tegelased tegelased = new Tegelased();
    Tegelane tegelaseValik;
    Boss bossiValik;

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

    public int naitaValikMenu(String kirjeldus, List<ManguTegelane> manguTegelased){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(kirjeldus);
            int loendur = Abi.valjastaNumbigaJarjestatud(manguTegelased);
            System.out.println(loendur + ". tagasi");
            valik = scanner.nextInt();
            return valik;
        }catch (InputMismatchException e){
            System.out.println("Palun sisestage õiged andmed");
            return -1;
        }
    }
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

        System.out.println("Sisestage õiged andmed");
    }

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
        System.out.println("Sisestage õiged andmed");
        return false;
    }

    public void alustaMangu(){
        ManguKontrollija gameMaster = new ManguKontrollija(tegelaseValik, bossiValik);
        while (gameMaster.isMangKestab()){
            gameMaster.valjastaMangijaMenu();
        }
        arvutaTegelaseXP(gameMaster.isViik(), gameMaster.isTegelaneVoitsid());
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
