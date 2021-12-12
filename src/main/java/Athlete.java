import exception.AthleteFailedWhileRunningException;
import exception.BatonTransferException;
import lombok.Data;

import javax.annotation.Nullable;
import java.util.Random;

@Data
public class Athlete {
    public static final Random RANDOM = new Random();
    public static final int LUCKY_RANGE = 10;
    public static final int FAIL_CHANCE = 2;

    private final int number;
    private final String currentAthlete;

    @Nullable
    private Baton baton;

    public Athlete(int number) {
        this.number = number;
        this.currentAthlete = "Спортсмен №" + this.number;
    }

    public void takeBaton(Baton baton) {
        System.out.printf("%s взял палочку\n", currentAthlete);
        this.baton = baton;
    }

    public void runWitchBaton() {
        System.out.printf("%s побежал\n", currentAthlete);
        if (isLucky()) {
            throw new AthleteFailedWhileRunningException(String.format("%s упал во время бега", currentAthlete));
        }
        System.out.printf("%s успешно побежал!\n", currentAthlete);
    }

    public void transferBaton(Athlete athlete) {
        System.out.printf("%s передал палочку спортсмену %s\n", currentAthlete, athlete.getNumber());
        athlete.takeBaton(baton);
        this.baton = null;
    }

    public void transferBatonRisky(Athlete athlete) throws BatonTransferException {
        if (isLucky()) {
            throw new BatonTransferException(String.format("%s промахнулся, кинув палочку", currentAthlete));
        }
        this.transferBaton(athlete);
    }
    private boolean isLucky() {
        return FAIL_CHANCE >= RANDOM.nextInt(LUCKY_RANGE);
    }
}
