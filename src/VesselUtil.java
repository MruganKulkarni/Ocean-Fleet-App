import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    private List<Vessel> vesselList;

    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }
}
