import java.util.ArrayList;

public class Race {
    String leaderName;
    int distance = 0;

    public Race() {}


    public void checkLeader(ArrayList<Auto> autoList) {
        for (Auto auto : autoList) {
            int carDistance = auto.speed * 24;
            if (carDistance > distance) {
                distance = carDistance;
                leaderName = auto.name;
            }
        }
    }
}