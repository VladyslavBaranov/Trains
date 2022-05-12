package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.*;

import Train.Locomotive;
import Train.LocomotiveEngineType;
import Train.Train;
import Train.Wagon;
import Train.WagonType;

public class AppTests {

    Locomotive locomotive1 = Locomotive.createInstance(LocomotiveEngineType.DIESEL, 10400, 1000, 10, 6, 100, "Siemens", 2012, 366273);

    Wagon wagon1 = Wagon.createInstance(WagonType.PASSANGERS, 900, 20, 40, 500, "SAAB", 2017, 776135);
    Wagon wagon2 = Wagon.createInstance(WagonType.SLEEPING, 900, 20, 30, 500, "SAAB", 2017, 776136);
    Wagon wagon3 = Wagon.createInstance(WagonType.PASSANGERS, 900, 20, 50, 500, "SAAB", 2017, 776137);


    @Test
    public void testSerialNumberUniqueness() {
        Wagon wagonA = Wagon.createInstance(WagonType.PASSANGERS, 900, 20, 40, 500, "SAAB", 2017, 776139);
        Wagon wagonB = Wagon.createInstance(WagonType.SLEEPING, 900, 20, 30, 500, "SAAB", 2017, 776139);

        assertNotNull(wagonA);
        assertNull(wagonB);
    }

    @Test
    public void testPhysicalLength() {
        Train aTrain = new Train();
        aTrain.connect(locomotive1, 0);
        aTrain.connect(wagon1, 1);
        aTrain.connect(wagon2, 2);
        aTrain.connect(wagon3, 3);

        assertEquals(70, aTrain.getPhysicalLength(), 0);
    }

    @Test
    public void testMaxPassangers() {
        Train aTrain = new Train();
        aTrain.connect(locomotive1, 0);
        aTrain.connect(wagon1, 1);
        aTrain.connect(wagon2, 2);
        aTrain.connect(wagon3, 3);

        assertEquals(126, aTrain.getMaxPassangers(), 0);
    }

    @Test
    public void testMaxLoading() {
        Train aTrain = new Train();
        aTrain.connect(locomotive1, 0);
        aTrain.connect(wagon1, 1);
        aTrain.connect(wagon2, 2);
        aTrain.connect(wagon3, 3);

        double locomotivePart = 100 + 6 * 75;
        double wagonPart = 500 * 3 + 120 * 75;
        assertEquals(locomotivePart + wagonPart, aTrain.getMaxLoadingWeights(), 0);
    }

    @Test
    public void testCanDrive() {
        Train aTrain = new Train();
        aTrain.connect(locomotive1, 0);
        aTrain.connect(wagon1, 1);
        aTrain.connect(wagon2, 2);
        aTrain.connect(wagon3, 3);

        assertEquals(false, aTrain.canDrive());
    }

    @Test
    public void testWagonOwnership() {
        Train trainA = new Train();
        trainA.connect(locomotive1, 0);
        trainA.connect(wagon1, 1);
        trainA.connect(wagon2, 2);
        trainA.connect(wagon3, 3);

        Train trainB = new Train();
        trainB.connect(locomotive1, 0);
        trainB.connect(wagon1, 1);
        trainB.connect(wagon2, 2);
        trainB.connect(wagon3, 3);

        assertEquals(0, trainB.getPhysicalLength(), 0);

        trainA.diconnect(trainA.getNumberOfItems() - 1);
        trainB.connect(wagon3, 0);

        assertEquals(20, trainB.getPhysicalLength(), 0);

    }
}
