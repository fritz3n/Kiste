package Kiste;

public class Flasche {
    private int inhalt;
    private int leerGewicht;
    private boolean imKasten = false;

    public Flasche(int inhalt, int leerGewicht) {
        this.inhalt = inhalt;
        this.leerGewicht = leerGewicht;
    }

    public int trinken(int ml){
        if(imKasten)
            throw new IllegalStateException("Flasche ist im Kasten");

        if(ml <= inhalt){
            inhalt -= ml;
            return ml;
        }
        ml = inhalt;
        inhalt = 0;
        return ml;
    }

    public boolean istLeer(){
        return inhalt == 0;
    }

    public int getGewicht(){
        return leerGewicht + inhalt;
    }

    public void setKasten(boolean kasten){
        imKasten = kasten;
    }

}