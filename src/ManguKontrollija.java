import java.util.Scanner;
import java.util.InputMismatchException;

public class ManguKontrollija {
    Tegelane tegelane;
    Tegelane boss;
    int valik;

    boolean mangKestab = true;

    public ManguKontrollija(Tegelane tegelane, Tegelane boss) {
        this.tegelane = tegelane;
        this.boss = boss;
    }

    public void valideeriOskust(){
        if(valik > tegelane.getOskused().size() -1 || valik < 0){
            valjastaMangijaMenu();
        }
        Oskus oskus = tegelane.getOskus(valik);
        boss.vahenedaHp(oskus.dmg);
    }

    public void naitaMangiMenu(){
        System.out.println(tegelane.getNimi() + " " + tegelane.getHp());
        System.out.println(boss.getNimi() + " " + boss.getHp());
        int loendur = Abi.valjastaNumbigaJarjestatudOskus(tegelane.getOskused());
        System.out.println(loendur+". pass");
    }

    public void valjastaMangijaMenu(){
        naitaMangiMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            valik = scanner.nextInt()-1;
        }catch (InputMismatchException e){
            Abi.valjastaValeAndmed();
            valjastaMangijaMenu();
        }
        valideeriOskust();
    }
}
