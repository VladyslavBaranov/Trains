package Train;

import java.util.List;
import java.util.ArrayList;

public abstract class TrainItem {

    static List<Integer> serialNumbers = new ArrayList<Integer>();

    public static int maxPassangersForTrain = 50;

    boolean isConnected;
    
    Train itsTrain;

    double emptyWeight;
    double length;
    int orderInTrain;

    int maxPassangers;
    double maxLoadingWeightForGoods;

    String manufacturer;
    int yearOfProduction;
    int serialNumber;

    boolean conductorIsRequired() {
        return maxPassangers > TrainItem.maxPassangersForTrain;
    }

    public static boolean serialNumberExists(int serialNumber) {
        return serialNumbers.contains(serialNumber);
    }

    public static void registerSerialNumber(int serialNumber) {
        serialNumbers.add(serialNumber);
    }
}
