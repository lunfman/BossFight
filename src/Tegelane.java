import java.util.ArrayList;
import java.util.List;

public class Tegelane {
    private String nimi;
    private int hp, lvl, xp, esialgneHp;
    private List<Oskus> oskused;
    private List<Norkus> norkused;

    public Tegelane(String nimi, int hp, int xp) {
        this.nimi = nimi;
        this.esialgneHp = hp;
        this.hp = hp;
        this.xp = xp;
        this.oskused = new ArrayList<>();
        this.norkused = new ArrayList<>();
        // järjekord on oluline !
        arvutaLvl();
        surendaHpXpBaasil();
    }

    public int getHp() {
        return hp;
    }

    public void surendaHp(int hp) {
        this.hp += hp;
    }

    public void vahenedaHp(int hp){
        this.hp -= hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        arvutaLvl();
        surendaHpXpBaasil();
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


    private void surendaHpXpBaasil(){
        this.hp = esialgneHp +  (lvl-1) * 10;
    }

    private void arvutaLvl(){
        // 101, sest lvl 0-100, 101 - 200, ... n-99 - n
        this.lvl = xp / 101 + 1;
    }


    @Override
    public String toString() {
        return nimi;
    }

    public String getInfo(){
        return "Nimi: "+nimi + " LVL:" + lvl + " HP:" + hp + " XP:" + xp;
    }
}
