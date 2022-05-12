package Train;

public class Wagon extends TrainItem {
    WagonType wagonType;

    Wagon(
        WagonType wagonType,
        double emptyWeight,
        double length,
        int maxPassangers,
        double maxLoadingWeightForGoods,
        String manufacturer,
        int yearOfProduction,
        int serialNumber
    ) {
        this.wagonType = wagonType;
        this.emptyWeight = emptyWeight;
        this.length = length;
        this.maxPassangers = maxPassangers;
        this.maxLoadingWeightForGoods = maxLoadingWeightForGoods;
        this.manufacturer = manufacturer;
        this.yearOfProduction = yearOfProduction;
        this.serialNumber = serialNumber;
    }

    public static Wagon createInstance(
        WagonType wagonType,
        double emptyWeight,
        double length,
        int maxPassangers,
        double maxLoadingWeightForGoods,
        String manufacturer,
        int yearOfProduction,
        int serialNumber
    ) {
        if (emptyWeight < 0) { return null; }
        if (length < 0) { return null; }
        if (maxPassangers < 0) { return null; }
        if (maxLoadingWeightForGoods < 0) { return null; }
        if (TrainItem.serialNumberExists(serialNumber)) { return null; }
        TrainItem.registerSerialNumber(serialNumber);
        return new Wagon(wagonType, emptyWeight, length, maxPassangers, maxLoadingWeightForGoods, manufacturer, yearOfProduction, serialNumber);
    }
}
