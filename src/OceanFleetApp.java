import java.util.List;
import java.util.Scanner;

public class OceanFleetApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.print("Enter number of vessels: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter vessel details (id:name:speed:type): ");
            String input = scanner.nextLine();

            String[] parts = input.split(":");

            String vesselId = parts[0];
            String vesselName = parts[1];
            double averageSpeed = Double.parseDouble(parts[2]);
            String vesselType = parts[3];

            Vessel vessel = new Vessel(
                    vesselId,
                    vesselName,
                    averageSpeed,
                    vesselType
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

        List<Vessel> highPerformanceVessels =
                vesselUtil.getHighPerformanceVessels();

        System.out.println("High Performance Vessels:");
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
