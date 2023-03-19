public class Oskus {

    private String nimi, tuup;
    private int dmg, cd, onVajaOodata = 0;
    private String[] omadused;
    private boolean saanKasutada = true;

    public Oskus(String nimi, int dmg, int cd, String[] omadused ,String tuup) {
        this.nimi = nimi;
        this.tuup = tuup;
        this.dmg = dmg;
        this.cd = cd;
        this.omadused = omadused;
    }

    public String getNimi() {
        return nimi;
    }

    public String getTuup() {
        return tuup;
    }

    public int getDmg() {
        return dmg;
    }

    public int getCd() {
        return cd;
    }

    public String[] getOmadused() {
        return omadused;
    }

    public boolean getSaanKasutada() {
        return saanKasutada;
    }

    public String annaTeadaKuiKaiuOnVajaOodata(){
        if (onVajaOodata == 0) return "";

        return onVajaOodata > 1 ?
                " (saab kasutada parast "+ onVajaOodata +" sammu)" : " (saab kasutada jargmisel sammul)";
    }


    @Override
    public String toString() {
        String esimeneOsa = nimi + " ("+dmg + " dmg) " + "("+cd + " cd)";
        return saanKasutada ? esimeneOsa : esimeneOsa + annaTeadaKuiKaiuOnVajaOodata();
    }

    public void kasutaOskust() {
        onVajaOodata = cd;
        saanKasutada = false;
    }

    public void vahenedaOnVajaOodata() {
        onVajaOodata --;
        if(onVajaOodata == 0) saanKasutada = true;
    }
}
