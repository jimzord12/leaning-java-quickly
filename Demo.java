
enum Engine {
    ELECTRIC("Electric", 150, 200),
    GAS("Gasoline", 180, 300),
    DIESEL("Diesel", 160, 250);

    private final String type;
    private final int topSpeed;
    private final int horsePower;

    // Private constructor
    private Engine(String type, int topSpeed, int horsePower) {
        this.type = type;
        this.topSpeed = topSpeed;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getHorsePower() {
        return horsePower;
    }

    // Nested Enum (Optional, if needed)
    public enum EngineTypes {
        ELECTRIC, GAS, DIESEL;
    }
}

class Car {

    String name;
    Engine engine;
    float currentSpeed = 0f;

    public Car(String name, Engine.EngineTypes engineType) {
        this.name = name;
        switch (engineType) {
            case ELECTRIC:
                this.engine = Engine.ELECTRIC;
                break;
            case GAS:
                this.engine = Engine.GAS;
                break;
            case DIESEL:
                this.engine = Engine.DIESEL;
                break;
            default:
                throw new AssertionError();
        }
    }

    public void accelerate(int seconds) {
        this.currentSpeed += seconds * (float) this.engine.getHorsePower() * 0.05f;
        System.out.println("");
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public String getName() {
        return name;
    }
}

public class Demo {

    public static void main(String args[]) {
        int num = 5;
        double d = 3.123456d;
        float f = 5.23f;
        long l = 5555555512L;
        char c = '👌';

        System.out.println(num + " " + d);

        show();
        playWithCars();
    }

    public static void show() {
        System.out.println("Running method: show()");

        if (true) {
            System.out.println("true");
        } else {
            System.out.println("");
        }

        // While Loops
        int i = 0;
        while (i < 5) {
            System.out.println("While :" + i);
            i++;
        }

        // Do-While Loops
        do {
            System.out.println("Do While :" + i);
            i++;
        } while (i < 10);

        // For Loop
        for (int j = 0; j < 5; j += 1) {
            System.out.println("For Loop: " + j);
        }
    }

    static void playWithCars() {
        Car car_01 = new Car("Honda Civic", Engine.EngineTypes.GAS);
        Car car_02 = new Car("Honda Civic", Engine.EngineTypes.ELECTRIC);

        int j = 0;
        while (j < 10) {
            car_01.accelerate(j);
            System.out.println("Car 01, current speed: " + car_01.getCurrentSpeed());

            car_02.accelerate(j);

            System.out.println("Car 02, current speed: " + car_02.getCurrentSpeed());

            j++;
        }
    }
}
