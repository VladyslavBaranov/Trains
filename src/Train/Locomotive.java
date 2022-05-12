package Train;

public class Locomotive extends TrainItem {
    LocomotiveEngineType engineType;
    double tractiveEffort;

    Locomotive(
        LocomotiveEngineType engineType,
        double tractiveEffort,
        double emptyWeight,
        double length,
        int maxPassangers,
        double maxLoadingWeightForGoods,
        String manufacturer,
        int yearOfProduction,
        int serialNumber
    ) {
        this.engineType = engineType;
        this.tractiveEffort = tractiveEffort;
        this.emptyWeight = emptyWeight;
        this.length = length;
        this.maxPassangers = maxPassangers;
        this.maxLoadingWeightForGoods = maxLoadingWeightForGoods;
        this.manufacturer = manufacturer;
        this.yearOfProduction = yearOfProduction;
        this.serialNumber = serialNumber;
    }

    public static Locomotive createInstance(
        LocomotiveEngineType engineType,
        double tractiveEffort,
        double emptyWeight,
        double length,
        int maxPassangers,
        double maxLoadingWeightForGoods,
        String manufacturer,
        int yearOfProduction,
        int serialNumber
    ) {
        if (tractiveEffort < 0) { return null; }
        if (emptyWeight < 0) { return null; }
        if (length < 0) { return null; }
        if (maxPassangers < 0) { return null; }
        if (maxLoadingWeightForGoods < 0) { return null; }
        if (TrainItem.serialNumberExists(serialNumber)) { return null; }
        TrainItem.registerSerialNumber(serialNumber);
        return new Locomotive(engineType, tractiveEffort, emptyWeight, length, maxPassangers, maxLoadingWeightForGoods, manufacturer, yearOfProduction, serialNumber);
    }
}
