public class Notebooks {
    int RAM;
    int HDD;
    String Brand;
    String OS;
    String Colour;
    double Price;



    @Override
    public String toString() {
        return "Марка ноутбука: " + Brand
                + "\nОперативная память: " + RAM +" GB"
                + "\nОбъем жесткого диска: " + HDD +" GB"
                + "\nОперационная система: " + OS
                + "\nЦвет: " + Colour
                + "\nЦена: " + Price + " euro";
    }
}
