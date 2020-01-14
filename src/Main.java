public class Main {
    public static void main(String[] args) {
        var cs = new ConversionStorage();
        cs.initUnittable();
        JUnitConverter juc = new JUnitConverter();
        juc.readUnits();
        juc.awtui();

    }
}
