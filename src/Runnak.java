public class Runnak extends Oskus{
    private int dmg;
    public Runnak(String nimi, int cd, int dmg) {
        super(nimi, cd);
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public String getKirjeldus() {
        return getNimi() + " ("+dmg + " dmg) " + "("+getCd() + " cd)";
    }
}
