import java.util.List;

public class Abi {
    public static int valjastaNumbigaJarjestatud(List<ManguTegelane> list){
        int loendur = 1;
        for (ManguTegelane tegelane: list) {
            System.out.println(loendur+". " + tegelane);
            loendur ++;
        }
        return loendur;
    }


    public static int valjastaNumbigaJarjestatudOskus(List<Oskus> list){
        int loendur = 1;
        for (Oskus oskus: list) {
            System.out.println(loendur+". " + oskus);
            loendur ++;
        }
        return loendur;
    }

    public static void valjastaValeAndmed(){
        System.out.println("Palun sisestage õiged andmed");
    }
}
