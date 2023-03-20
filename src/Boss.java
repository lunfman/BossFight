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
}
