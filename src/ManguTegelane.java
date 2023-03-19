import java.util.ArrayList;
import java.util.List;

public abstract class ManguTegelane {

    private String nimi;
    private int hp;
    private List<Oskus> oskused;
    private List<Norkus> norkused;

    public ManguTegelane(String nimi, int hp) {
        this.nimi = nimi;
        this.hp = hp;
        this.oskused = new ArrayList<>();
        this.norkused = new ArrayList<>();
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

    public List<Norkus> getNorkused() {
        return norkused;
    }

    public void lisaOskust(Oskus oskus){
        oskused.add(oskus);
    }

    public void lisaNorkus(Norkus norkus){
        norkused.add(norkus);
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
