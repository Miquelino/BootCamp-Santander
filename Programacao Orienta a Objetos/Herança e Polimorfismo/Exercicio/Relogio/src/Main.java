import Model.BRLClock;
import Model.Clock;
import Model.USClock;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Clock brlClock = new BRLClock();
        brlClock.setSecond(0);
        brlClock.setMinute(0);
        brlClock.setHour(12);

        System.out.println(brlClock.getTime());

        System.out.println(new USClock().convert(brlClock).getTime());
    }
}