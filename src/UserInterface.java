import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private VesselUtil vesselUtil;
    private Scanner scanner;

    public UserInterface() {
        vesselUtil = new VesselUtil();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.print("Enter number of vessels: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter vessel details (id:name:speed:type): ");
            String input = scanner.nextLine();

            String[] parts = input.split(":");

            Vessel vessel = new Vessel(
                    parts[0],
                    parts[1],
                    Double.parseDouble(parts[2]),
                    parts[3]
            );

            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.print("Enter vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel result = vesselUtil.getVesselById(searchId);

        if (result != null) {
            System.out.println(
                    result.getVesselId() + " " +
                            result.getVesselName() + " " +
                            result.getAverageSpeed() + " " +
                            result.getVesselType()
            );
        } else {
            System.out.println("Vessel not found");
        }

        System.out.println("High Performance Vessels:");
        List<Vessel> highPerformanceVessels =
                vesselUtil.getHighPerformanceVessels();

        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(
                    vessel.getVesselId() + " " +
                            vessel.getVesselName() + " " +
                            vessel.getAverageSpeed() + " " +
                            vessel.getVesselType()
            );
        }

        scanner.close();
    }
}
