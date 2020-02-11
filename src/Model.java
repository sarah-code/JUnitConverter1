import java.io.*;
import java.util.HashMap;

public class Model {
    public HashMap<String, Double> unittable = new HashMap<>();

    public void setUnittable(HashMap<String, Double> unittable) {
        this.unittable = unittable;
    }

    public HashMap<String, Double> getUnittable() {
        return unittable;
    }

    String[] unitCategories;

    public void initUnittable ()
    {
        String line = null;
        try(FileReader fr = new FileReader("unittable.csv");
            BufferedReader br = new BufferedReader(fr);)
        {
            while ((line= br.readLine())!= null)
            {
                String lineValues []= line.split(",");
                unittable.put(lineValues[0], Double.parseDouble(lineValues[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        unittable.put("inchcentimeter",2.54);
//
//
//        unittable.put("kilometermiles", 0.621371);
//        unittable.put("mileskilometer", 1.609);
//
//        unittable.put("metermiles", 621.370999997514);
//        unittable.put("milesmeter", 1609.0);
//
//        unittable.put("centimetermiles", 6.21370999997515);
//        unittable.put("milescentimeter", 160934.0);
//
//        unittable.put("millimetermiles", 0.62137099999751510548);
//        unittable.put("milesmillimeter", 1609344.);
//
//        unittable.put("centimetermeter", 0.01);
//        unittable.put("metercentimeter", 100.0);
//
//        unittable.put("kilometermeter", 0.001);
//        unittable.put("meterkilometer", 1000.0);
//
//        unittable.put("centimetermillimeter",0.1);
//        unittable.put("millimetercentimeter", 10.0);
//
//        unittable.put("millimetermeter", 1000.0);
//        unittable.put("metermillimeter", 0.001);
//
//        unittable.put("kilometermillimeter",1000000.0);
//        unittable.put("millimeterkilometer", 0.000001);
//
//        unittable.put("centimeterkilometer",0.00001);
//        unittable.put("kilometercentimeter", 100000.0);
//
//        //medical
//        unittable.put("ng/dLmnol/L", 0.314465);
//        unittable.put("mnol/Lng/dL", 0.0347);


    }

    public String [] unitCategories()
    {
         unitCategories = new String [] {"----------", "Distance", "Mass", "Medical"};
        return unitCategories;
    }

}
