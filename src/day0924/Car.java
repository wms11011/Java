package day0924;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName Car.java
 */
public class Car implements Comparable<Car>{

    private String CarName;

    public Car() {
    }

    public Car(String carName) {
        CarName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(CarName, car.CarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CarName);
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarName='" + CarName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return getCarName().compareTo(o.getCarName());
    }
}
