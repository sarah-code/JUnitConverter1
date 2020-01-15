public class Main {
    public static void main(String[] args) {
        var cs = new Model();
        cs.initUnittable();
        var con = new Controller();
        var view = new View();
        view.readUnits();
        view.awtui();
        System.out.println(cs.unittable.get("meterkilometer"));

    }
}
