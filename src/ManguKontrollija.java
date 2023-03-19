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
        if(valik > tegelane.getOskused().size()  || valik < 0){
            System.out.println("Vale vaartus !!!!!!");
            return;
        }

        if(valik == tegelane.getOskused().size()){
            vahenedaKoikOskused();
            return;
        }

        Oskus oskus = tegelane.getOskus(valik);

        if(!oskus.getSaanKasutada()){
            System.out.println("Te, ei saa praegu kasutada, seda oskust!!!!!!!!!!");
            return;
        }
        // kui jõuame siiamani, siis saame vahenedaCD
        vahenedaKoikOskused();

        if (oskus instanceof Runnak) {
            boss.vahenedaHp(((Runnak) oskus).getDmg());
            oskus.kasutaOskust();
        }
    }

    public void vahenedaKoikOskused(){
        System.out.println("kasuta");
        for (Oskus oskus: tegelane.getOskused()){
            oskus.vahenedaOnVajaOodata();
        }
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
            return;
        }
        valideeriOskust();
        leiaVoitjat();
    }
}
