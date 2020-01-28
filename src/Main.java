import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        var cs = new Model();
        cs.initUnittable();
        var con = new Controller();
        var viewer = new View();
        viewer.setContentPane(new View().converterPanel);

        viewer.setTitle("Converter Tool");
        //viewer.readUnits();
        System.out.println(cs.unittable.get("meterkilometer"));

        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setResizable(false);
        viewer.pack();
        viewer.setVisible(true);


    }
}
