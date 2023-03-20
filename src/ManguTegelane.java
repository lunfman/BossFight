import java.util.ArrayList;
import java.util.List;

public abstract class ManguTegelane {

    private String nimi;
    private int hp;
    private List<Oskus> oskused;

    public ManguTegelane(String nimi, int hp) {
        this.nimi = nimi;
        this.hp = hp;
        this.oskused = new ArrayList<>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void surendaHp(int hp) {
        this.hp += hp;
    }

    public void vahenedaHp(int hp){
        this.hp -= hp;
    }

    public String getNimi() {
        return nimi;
    }

    public List<Oskus> getOskused() {
        return oskused;
    }

    public void lisaOskust(Oskus oskus){
        oskused.add(oskus);
    }

    public Oskus getOskus(int koht){
        return oskused.get(koht);
    }


    @Override
    public String toString() {
        return nimi;
    }

    public String getInfo(){
        return "Nimi: "+nimi + " HP:" + hp ;
    }
}
