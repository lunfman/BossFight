import java.util.List;
import java.util.Scanner;

public class Mang {
    int valik;
    boolean jookseb = true, mangJookseb=true;

    Tegelased tegelased = new Tegelased();


    Tegelane tegelaseValik;
    Boss bossiValik;

    public void arvutaTegelaseXP(){
        return;
    }

    public int naitaValikMenu(String kirjeldus, List<ManguTegelane> manguTegelased){
        Scanner scanner = new Scanner(System.in);
        System.out.println(kirjeldus);
        int loendur = Abi.valjastaNumbigaJarjestatud(manguTegelased);
        System.out.println(loendur + ". tagasi");
        valik = scanner.nextInt();
        return valik;
    }
    public void valiBossi(){
        valik = naitaValikMenu("Vali bossi:", tegelased.bossid);
        if(valik > 0 && valik <= tegelased.bossid.size()){
            bossiValik = (Boss) tegelased.bossid.get(valik-1);
            return;
        }
        if(valik == tegelased.bossid.size()+1){
            jookseb = false;
        }
    }

    public boolean valiCharacteri(){
        valik = naitaValikMenu("Vali character:", tegelased.tegelased);

        if(valik > 0 && valik <= tegelased.tegelased.size()){
            tegelaseValik = (Tegelane) tegelased.tegelased.get(0);
            return true;
        }

        return valik != tegelased.tegelased.size() + 1;
    }

    public void alustaMangu(){
        ManguKontrollija gameMaster = new ManguKontrollija(tegelaseValik, bossiValik);
        while (gameMaster.isMangKestab()){
            gameMaster.valjastaMangijaMenu();
        }
        jookseb = false;
    }

    public void avaManguMenu(){
        valiBossi();
        if(!jookseb) return;
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
