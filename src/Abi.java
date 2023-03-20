import java.util.List;

public class Abi {
    /**
     * väljastab ekraanile tegelased järjekorras ja tagastab numbri, mis on võrdne järgmise elemendiga
     * @param list ManguTegelane
     * @return list.size() + 1
     */
    public static int valjastaNumbigaJarjestatud(List<ManguTegelane> list){
        int loendur = 1;
        for (ManguTegelane tegelane: list) {
            System.out.println(loendur+". " + tegelane);
            loendur ++;
        }
        return loendur;
    }

    /**
     * väljastab ekraanile oskused järjekorras ja tagastab numbri, mis on võrdne järgmise elemendiga
     * @param list oskused
     * @return list.size() + 1
     */
    public static int valjastaNumbigaJarjestatudOskus(List<Oskus> list){
        int loendur = 1;
        for (Oskus oskus: list) {
            System.out.println(loendur+". " + oskus);
            loendur ++;
        }
        return loendur;
    }

    /**
     * Kui kasutaja sisestab valed andmed, võime kasutada seda metoodi, et teadet näidata.
     */
    public static void valjastaValeAndmed(){
        System.out.println("Palun sisestage õiged andmed");
    }
}
