import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    int valik = -1;
    boolean jooksen = true;

    String logo = " ______                ______ _       _     _   \n" +
            "| ___ \\               |  ___(_)     | |   | |  \n" +
            "| |_/ / ___  ___ ___  | |_   _  __ _| |__ | |_ \n" +
            "| ___ \\/ _ \\/ __/ __| |  _| | |/ _` | '_ \\| __|\n" +
            "| |_/ / (_) \\__ \\__ \\ | |   | | (_| | | | | |_ \n" +
            "\\____/ \\___/|___/___/ \\_|   |_|\\__, |_| |_|\\__|\n" +
            "                                __/ |          \n" +
            "                               |___/"
            ;

    public Menu() {
        System.out.println(logo);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mängija nimi: ");
        String nimi = scanner.nextLine();
        System.out.println("Tere tulemast mängu BossFight, " + nimi + "!" + "\n" + "Mängu eesmärgiks on võita bossid. Selleks saad kasutada erinevaid oskusi, mis su tegelasel on.");
    }

    /**
     * meetood näitab, millised tegelased on mängus olemas.
     */
    public void naitaTegelasi() throws IOException  {
        Tegelased tegelased = new Tegelased();
        System.out.println("Tegelased: ");
        tegelased.getTegelasedInfo();

        System.out.println("Bossid: ");
        tegelased.getBossidInfo();
    }

    /**
     * meetood validerib, mida kasutaja sisestas ja vastavalt selle otsustab mida teha.
     * 1. Alusta mangu - kasutab Mang meetod alusta
     * 2. Tegelased - väjastab info, millised tegelased on olemas mängus ja nende omadused.
     * 3. Tagasi - exit
     * Kui valik oli vale, väljastab teavet.
     */
    public void valideeriValik () throws IOException {
        if(valik == 1) {
            Mang mang = new Mang();
            mang.alusta();
        }
        else if (valik== 2){
            naitaTegelasi();
        }
        else if (valik== 3){
            jooksen = false;
        }
        else{
            System.out.println("Vale valik!!!!");
        }
    }

    /**
     * Ongi avab menuut ja annab võimalust kasutaja sisestada andmed.
     * Valik salvestatakse ja pärast valideeritatakse valideeriValik abil.
     * Kui kasutaja, sisestab jama infot, anname teada, et see ei tööta
     */
    public void avaMenu() throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Alusta mängu");
            System.out.println("2. Tegelased");
            System.out.println("3. Head aega");
            System.out.print("Valik: ");
            valik = scanner.nextInt();
            valideeriValik();
        }catch (InputMismatchException e){
            Abi.valjastaValeAndmed();
        }

    }}

