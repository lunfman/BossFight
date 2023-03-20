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
            vahenedaKoikOskused(tegelane);
            return;
        }

        Oskus oskus = tegelane.getOskus(valik);

        if(!oskus.getSaanKasutada()){
            System.out.println("Te, ei saa praegu kasutada, seda oskust!!!!!!!!!!");
            return;
        }
        // kui jõuame siiamani, siis saame vahenedaCD
        vahenedaKoikOskused(tegelane);

        if (oskus instanceof Runnak) {
            boss.vahenedaHp(((Runnak) oskus).getDmg());
            oskus.kasutaOskust();
        }
    }

    public void vahenedaKoikOskused(ManguTegelane tegelane){
        System.out.println("kasuta");
        for (Oskus oskus: tegelane.getOskused()){
            oskus.vahenedaOnVajaOodata();
        }
    }

    public void ründaTegelast(){
        Oskus oskus = boss.getSuvalineOskus();

        if(oskus.getSaanKasutada()){
            System.out.println("kasutan bossi oskust");
            vahenedaKoikOskused(boss);
            oskus.kasutaOskust();
            if (oskus instanceof Runnak) {
                tegelane.vahenedaHp(((Runnak) oskus).getDmg());
                oskus.kasutaOskust();
            }
            return;
        }
        System.out.println("Boss ei saa kasutada oskust");
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
        valideeriOskust();
        ründaTegelast();
        leiaVoitjat();
    }
}
