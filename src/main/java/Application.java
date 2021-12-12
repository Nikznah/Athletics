import exception.BatonTransferException;

/**
 *
 */
public class Application {

    public static void main(String[] args) throws BatonTransferException {

        Athlete athlete1 = new Athlete(1);
        Athlete athlete2 = new Athlete(2);
        Athlete athlete3 = new Athlete(3);
        Athlete athlete4 = new Athlete(4);

        Baton baton = new Baton();

        athlete1.takeBaton(baton);
        athlete1.runWitchBaton();
        athlete1.transferBaton(athlete2);
        athlete2.runWitchBaton();
        athlete2.transferBaton(athlete3);
        athlete3.transferBatonRisky(athlete4);
        athlete3.transferBaton(athlete4);
        athlete4.runWitchBaton();
        System.out.println("Победила дружба!");
    }
}
