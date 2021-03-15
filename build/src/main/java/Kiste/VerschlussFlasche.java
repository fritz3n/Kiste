
package Kiste;

public class VerschlussFlasche extends Flasche {
    private boolean offen = false;
    private boolean seal = true;

    public VerschlussFlasche(int inhalt, int leerGewicht){
        super(inhalt, leerGewicht);
    }

    public void öffnen(){
        if(seal)
            System.out.println("Plop");
        seal = false;
        offen = true;
    }

    public void schliessen(){
        offen = false;
    }

    @Override
    public int trinken(int ml){
        if(!offen)
            throw new IllegalStateException("VerschlussFlasche ist nicht offen");
        return super.trinken(ml);
    }
}

