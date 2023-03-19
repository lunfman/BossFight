import java.util.Scanner;
import java.util.function.Function;

public class Mang {
    String boss, character;
    int valik = -1;
    boolean jookseb = true, mangJookseb=true;

    Tegelased tegelased = new Tegelased();


    Tegelane tegelaseValik;
    Boss bossiValik;

    public void valiBossi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vali bossi:");
        int loendur = Abi.valjastaNumbigaJarjestatud(tegelased.bossid);
        System.out.println(loendur + ". tagasi");
        valik = scanner.nextInt();

        if(valik==1){
            bossiValik = (Boss) tegelased.bossid.get(0);
        }

        if(valik == loendur){
            jookseb = false;
            return;
        }

        boss = "Boss" + valik;

    }

    public void valiCharacteri(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vali character:");
        int loendur = Abi.valjastaNumbigaJarjestatud(tegelased.tegelased);
        System.out.println(loendur + ". tagasi");
        valik = scanner.nextInt();

        if(valik==1){
            tegelaseValik = (Tegelane) tegelased.tegelased.get(0);
        }

        if(valik == loendur){
            avaManguMenu();
            return;
        }
        character = "Character" + valik;
    }

    public void alustaMangu(){
        ManguKontrollija gameMaster = new ManguKontrollija(tegelaseValik, bossiValik);
        while (gameMaster.mangKestab){
            gameMaster.valjastaMangijaMenu();
        }
    }

    public void avaManguMenu(){
        valiBossi();
        if(!jookseb) return;
        valiCharacteri();
        alustaMangu();
    }

    public void alusta(){
        while (jookseb){
            avaManguMenu();
        }
    }

}
