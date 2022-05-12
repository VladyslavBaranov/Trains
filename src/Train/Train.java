package Train;

import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;

public class Train {

    private List<TrainItem> items = new ArrayList<TrainItem>();

    public int getNumberOfItems() {
        return items.size();
    }

    public void connect(TrainItem item, int position) {
        if (item.isConnected) { 
            System.out.println("Warning: This locomitive/wagon is already connected to other train");
            System.out.println(MessageFormat.format("Loomotive/wagon serial number: {0}", item.serialNumber));
            return;
        }
        item.isConnected = true;
        item.itsTrain = this;
        items.add(position, item);
        for (int i = 0; i < items.size(); i++) {
            items.get(i).orderInTrain = i;
        }
    }

    public TrainItem diconnect(int itemOrder) {
        TrainItem itemAt = items.remove(itemOrder);
        itemAt.isConnected = false;
        for (int i = 0; i < items.size(); i++) {
            items.get(i).orderInTrain = i;
        }
        return itemAt;
    }

    public double getEmptyWeight() {
        double weight = 0.0;
        for (TrainItem trainItem : items) {
            weight += trainItem.emptyWeight;
        }
        return weight;
    }

    public int getMaxPassangers() {
        int passangers = 0;
        for (TrainItem trainItem : items) {
            passangers += trainItem.maxPassangers;
        }
        return passangers;
    }

    public double getMaxLoadingWeightsForGoods() {
        double weight = 0.0;
        for (TrainItem trainItem : items) {
            weight += trainItem.maxLoadingWeightForGoods;
        }
        return weight;
    }

    public double getMaxLoadingWeights() {
        int maxPassangersWeight = getMaxPassangers() * 75;
        return maxPassangersWeight + getMaxLoadingWeightsForGoods();
    }

    public double getMaxTotalWeight() {
        return getEmptyWeight() + getMaxLoadingWeights();
    }

    public double getPhysicalLength() {
        double length = 0.0;
        for (TrainItem trainItem : items) {
            length += trainItem.length;
        }
        return length;
    }
    
    public boolean canDrive() {
        double maxTractiveEffort = 0.0;
        for (TrainItem item : items) {
            if (item instanceof Locomotive) {
                maxTractiveEffort += ((Locomotive)item).tractiveEffort;
            }
        }
        return maxTractiveEffort > getMaxTotalWeight();
    }
    
    public int getNumberOfMaxNeccessaryConductors() {
        int maxPassagers = getMaxPassangers();
        return maxPassagers / 50;
    }

}
