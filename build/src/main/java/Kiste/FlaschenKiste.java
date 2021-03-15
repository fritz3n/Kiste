package Kiste;
import java.util.List;

public class FlaschenKiste {
    private List<Flasche> flaschen;
    final int maxFlaschen = 12;

    public FlaschenKiste(List<Flasche> flaschen) {
        if(flaschen.size() > maxFlaschen)
            throw new IllegalArgumentException("Zu viele Flaschen für Kasten. 12 erlaubt.");
        this.flaschen = flaschen;
    }

    public Flasche rausnehmen(){
        if(flaschen.size() == 0)
            throw new IllegalStateException("Keine Flaschen verfügbar");
        Flasche flasche =  flaschen.remove(flaschen.size() - 1 );
        flasche.setKasten(false);
        return flasche;
    }

    public void reinstecken(Flasche flasche){
        if(flaschen.size() == maxFlaschen)
            throw new IllegalStateException("Zu viele Flaschen für Kasten. 12 erlaubt.");
        flasche.setKasten(true);
        flaschen.add(flasche);
    }

    public int getGwewicht(){
        return (int)flaschen
            .stream()
            .map(flasche -> flasche.getGewicht())
            .reduce(0, (gewicht, flasche) -> gewicht + flasche);
    }

}
