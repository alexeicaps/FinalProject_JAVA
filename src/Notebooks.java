public class Notebooks {
    int RAM; // Oперативная память (ОЗУ)
    int HDD; // объем жесткого диска
    String Brand; //Марка
    String OS; //Операционная система
    String Colour; //Цвет
    double Price; //Стоимость



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
