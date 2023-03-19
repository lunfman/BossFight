import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boss extends ManguTegelane {

    List<Integer> kontrollitudOskused = new ArrayList<>();
    public Boss(String nimi, int hp) {
        super(nimi, hp);
    }

    public Oskus getSuvalineOskus(){
        Random rand = new Random();
        return getOskused().get(rand.nextInt(getOskused().size()));
    }
    public boolean ründa() {
        // isegi, kui boss, võib kasutada, teist rünnakut, aga valis rünnaku, mis on ootel -> pass
        // ei tähenda, et boss päriselt ründab, võib kasuta kaitset ka.
        Oskus oskus = getSuvalineOskus();
        if(oskus.getSaanKasutada()){
            oskus.kasutaOskust();
            return true;
        }
        // siis kasutame passi
       return false;

    }
}
