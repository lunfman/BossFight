public abstract class Oskus {

    private String nimi;
    private int  cd, onVajaOodata = 0;
    private boolean saanKasutada = true;

    public Oskus(String nimi, int cd) {
        this.nimi = nimi;
        this.cd = cd;
    }

    public String getNimi() {
        return nimi;
    }

    public int getCd() {
        return cd;
    }

    public boolean getSaanKasutada() {
        return saanKasutada;
    }

    public String annaTeadaKuiKaiuOnVajaOodata(){
        if (onVajaOodata == 0) return "";

        return onVajaOodata > 1 ?
                " (saab kasutada parast "+ onVajaOodata +" sammu)" : " (saab kasutada jargmisel sammul)";
    }

    public String getKirjeldus() {
        return nimi  + " ("+cd + " cd)";
    }

    @Override
    public String toString() {
        String esimeneOsa = getKirjeldus();
        return saanKasutada ? esimeneOsa : esimeneOsa + annaTeadaKuiKaiuOnVajaOodata();
    }

    public void kasutaOskust() {
        //        onVajaOodata = cd+1;
        onVajaOodata = cd;
        saanKasutada = false;
    }

    public void vahenedaOnVajaOodata() {
        if(onVajaOodata == 0){
            return;
        }
        onVajaOodata --;
        if(onVajaOodata == 0) saanKasutada = true;
    }
}
