import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    int valik = -1;
    boolean jooksen = true;

    public Menu() {
        System.out.println("Welcome, blalblalvladlaskdopapaskdas:");
    }

    /**
     * meetood näitab, millised tegelased on mängus olemas.
     */
    public void naitaTegelasi(){
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
    public void valideeriValik () {
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
    public void avaMenu(){
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
            avaMenu();
        }

    }}

