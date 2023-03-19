import java.util.Scanner;
import java.util.InputMismatchException;

public class ManguKontrollija {
    Tegelane tegelane;
    Boss boss;
    int valik;

    boolean mangKestab = true;

    public ManguKontrollija(Tegelane tegelane, Boss boss) {
        this.tegelane = tegelane;
        this.boss = boss;
    }

    public void leiaVoitjat(){
        if(tegelane.getHp() <= 0 && boss.getHp() <= 0){
            System.out.println("Viik");
            mangKestab = false;
        }

        if(tegelane.getHp() <= 0) {
            System.out.println("Kaotus");
            mangKestab = false;
        }
        if (boss.getHp() <= 0) {
            System.out.println("Võit");
            mangKestab = false;
        }
    }

    public void valideeriOskust(){
        System.out.println("validerin");
        if(valik > tegelane.getOskused().size() -1 || valik < 0){
            valjastaMangijaMenu();
            return;
        }
        Oskus oskus = tegelane.getOskus(valik);
        System.out.println("vahenda dmg");
        boss.vahenedaHp(oskus.getDmg());
    }

    public void naitaManguMenu(){
        System.out.println(tegelane.getNimi() + " " + tegelane.getHp());
        System.out.println(boss.getNimi() + " " + boss.getHp());
        int loendur = Abi.valjastaNumbigaJarjestatudOskus(tegelane.getOskused());
        System.out.println(loendur+". pass");
    }

    public void valjastaMangijaMenu(){
        naitaManguMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            valik = scanner.nextInt()-1;
        }catch (InputMismatchException e){
            Abi.valjastaValeAndmed();
            valjastaMangijaMenu();
            return;
        }
        valideeriOskust();
        leiaVoitjat();
    }
}
