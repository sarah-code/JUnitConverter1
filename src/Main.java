import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        var cs = new Model();
        cs.initUnittable();
        var con = new Controller();
        var view = new JFrame("View1");
        var viewer = new View1();
        view.setContentPane(new View1().converterPanel);
        System.out.println(cs.unittable.get("meterkilometer"));
        viewer.readUnits();
        viewer.awtui();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);


    }
}
