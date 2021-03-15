package Kiste;

import java.util.Timer;
import java.util.TimerTask;

public class Mensch {
    private int durst;
    private Timer timer;
    private String name;
    
    private int inhalt = 100;
    private FlaschenKiste kiste;

    public Mensch(String name, int durst, FlaschenKiste kiste){
        this.name = name;
        this.durst = durst;
		this.kiste = kiste;

        timer = new Timer(name);
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                leben();
            }
        }, (long)(Math.random() * 300), 1000);
    }

    private void leben(){
        inhalt -= durst;

        int min = 150;
        int soll = 250;

        if(inhalt < min){
            while(inhalt < soll){
                int ml = soll - inhalt;
                int getrunken;

                Flasche flasche = kiste.rausnehmen();
                if(flasche instanceof VerschlussFlasche){
                    VerschlussFlasche vFlasche = ((VerschlussFlasche)flasche);
                    vFlasche.öffnen();
                    getrunken = vFlasche.trinken(ml);
                    vFlasche.schliessen();
                }else{
                    getrunken = flasche.trinken(ml);
                }

                System.out.println(name + " hat " + getrunken + "ml getrunken.");
                inhalt += getrunken;


                if(!flasche.istLeer())
                    kiste.reinstecken(flasche);
            }
        }

        
        System.out.println(name + " inhalt " + inhalt + "ml");
    }


}
