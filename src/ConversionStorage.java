import java.util.HashMap;

public class ConversionStorage {
    HashMap<String, String> unittable = new HashMap<String, String>();

    public void setUnittable(HashMap<String, String> unittable) {
        this.unittable = unittable;
    }

    public HashMap<String, String> getUnittable() {
        return unittable;
    }

    public void initUnittable ()
    {
        unittable.put("inchcentimeter","2.54");
        unittable.put("centimetermeter","0.393701");

        unittable.put("kilometermiles", "0.621371");
        unittable.put("mileskilometer", "1.609");

        unittable.put("metermiles", "621.370999997514");
        unittable.put("milesmeter", "1609");

        unittable.put("centimetermiles", "6.21370999997515");
        unittable.put("milescentimeter", "160934");

        unittable.put("millimetermiles", "0.62137099999751510548");
        unittable.put("milesmillimeter", "1609344");

        unittable.put("centimetermeter", "0.01");
        unittable.put("metercentimeter", "100");

        unittable.put("kilometermeter", "0.001");
        unittable.put("meterkilometer", "1000");

        unittable.put("centimetermillimeter","0.1");
        unittable.put("millimetercentimeter", "10");

        unittable.put("millimetermeter", "1000");
        unittable.put("metermillimeter", "0.001");

        unittable.put("kilometermillimeter","1000000");
        unittable.put("millimeterkilometer", "0.000001");

        unittable.put("centimeterkilometer","0.00001");
        unittable.put("kilometercentimeter", "100000");

    }
}
