import java.util.Random;

public class Boss extends ManguTegelane {
    public Boss(String nimi, int hp) {
        super(nimi, hp);
    }

    public Oskus getSuvalineOskus(){
        Random rand = new Random();
        return getOskused().get(rand.nextInt(getOskused().size()));
    }
}
