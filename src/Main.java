import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        var cs = new Model();
        cs.initUnittable();
        var con = new Controller();
        var viewer = new View1();
        viewer.setContentPane(new View1().converterPanel);
        viewer.readUnits();
        viewer.awtui();

        System.out.println(cs.unittable.get("meterkilometer"));

        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.pack();
        viewer.setVisible(true);


    }
}
