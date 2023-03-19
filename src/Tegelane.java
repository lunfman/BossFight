public class Tegelane extends ManguTegelane {
    private int lvl, xp, esialgneHp;

    public Tegelane(String nimi, int hp, int xp) {
        super(nimi, hp);
        this.xp = xp;
        this.esialgneHp = hp;
        // järjekord on oluline !
        arvutaLvl();
        surendaHpXpBaasil();
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        arvutaLvl();
        surendaHpXpBaasil();
    }

    private void surendaHpXpBaasil(){
         setHp(esialgneHp +  (lvl-1) * 10);
    }

    private void arvutaLvl(){
        // 101, sest lvl 0-100, 101 - 200, ... n-99 - n
        this.lvl = xp / 101 + 1;
    }


    public String getInfo(){
        return "Nimi: "+getNimi() + " LVL:" + lvl + " HP:" + getHp() + " XP:" + xp;
    }
}
