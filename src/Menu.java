import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    int valik = -1;
    boolean jooksen = true;

    public Menu() {
        System.out.println("Welcome, blalblalvladlaskdopapaskdas:");
    }

    public void valideeriValik () {
        if(valik == 1) {
            Mang mang = new Mang();
            mang.alusta();
        }
        else if (valik== 2){
            Tegelased tegelased = new Tegelased();
            System.out.println("Tegelased: ");
            tegelased.getTegelasedInfo();

            System.out.println("Bossid: ");
            tegelased.getBossidInfo();
        }
        else if (valik== 3){
            jooksen = false;
        };
    }
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

