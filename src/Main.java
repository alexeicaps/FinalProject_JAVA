import java.util.*;

public class Main {

    static Set<Notebooks> addLaptops() {
        Notebooks notebook1 = new Notebooks();
        notebook1.RAM = 16; // ОЗУ
        notebook1.HDD = 512; // объем жесткого диска
        notebook1.Brand = "MacBook"; //Марка
        notebook1.OS = "macOS"; //Операционная система
        notebook1.Colour = "Black"; //Цвет
        notebook1.Price = 860.00; //Стоимость

        Notebooks notebook2 = new Notebooks();
        notebook2.RAM = 8; // ОЗУ
        notebook2.HDD = 1000; // объем жесткого диска
        notebook2.Brand = "Asus"; //Марка
        notebook2.OS = "Win10"; //Операционная система
        notebook2.Colour = "Red"; //Цвет
        notebook2.Price = 720.00; //Стоимость

        Notebooks notebook3 = new Notebooks();
        notebook3.RAM = 16; // ОЗУ
        notebook3.HDD = 512; // объем жесткого диска
        notebook3.Brand = "MacBook"; //Марка
        notebook3.OS = "macOS"; //Операционная система
        notebook3.Colour = "Grey"; //Цвет
        notebook3.Price = 850.00; //Стоимость

        Notebooks notebook4 = new Notebooks();
        notebook4.RAM = 8; // ОЗУ
        notebook4.HDD = 512; // объем жесткого диска
        notebook4.Brand = "Dell"; //Марка
        notebook4.OS = "Linux"; //Операционная система
        notebook4.Colour = "Grey"; //Цвет
        notebook4.Price = 675.00; //Стоимость

        Notebooks notebook5 = new Notebooks();
        notebook5.RAM = 16; // ОЗУ
        notebook5.HDD = 512; // объем жесткого диска
        notebook5.Brand = "Asus"; //Марка
        notebook5.OS = "Linux"; //Операционная система
        notebook5.Colour = "Black"; //Цвет
        notebook5.Price = 799.50; //Стоимость

        Notebooks notebook6 = new Notebooks();
        notebook6.RAM = 8; // ОЗУ
        notebook6.HDD = 256; // объем жесткого диска
        notebook6.Brand = "MSI"; //Марка
        notebook6.OS = "Win10"; //Операционная система
        notebook6.Colour = "Grey"; //Цвет
        notebook6.Price = 650.00; //Стоимость

        Notebooks notebook7 = new Notebooks();
        notebook7.RAM = 8; // ОЗУ
        notebook7.HDD = 256; // объем жесткого диска
        notebook7.Brand = "MSI"; //Марка
        notebook7.OS = "Win10"; //Операционная система
        notebook7.Colour = "Red"; //Цвет
        notebook7.Price = 720.00; //Стоимость

        Notebooks notebook8 = new Notebooks();
        notebook8.RAM = 12; // ОЗУ
        notebook8.HDD = 256; // объем жесткого диска
        notebook8.Brand = "Dell"; //Марка
        notebook8.OS = "Win10"; //Операционная система
        notebook8.Colour = "Grey"; //Цвет
        notebook8.Price = 560.99; //Стоимость

        Set<Notebooks> notebook = new HashSet<>();
        notebook.add(notebook1);
        notebook.add(notebook2);
        notebook.add(notebook3);
        notebook.add(notebook4);
        notebook.add(notebook5);
        notebook.add(notebook6);
        notebook.add(notebook7);
        notebook.add(notebook8);
        return notebook;
    }

    public static void main(String[] args) {
        Scanner clientType = new Scanner(System.in);
        Map<Integer, String> resultFilter = new HashMap<>();
        int search;
        boolean Flag;
        do {
            resultFilter.clear();
            System.out.println("Вы можете выбрать следующие критерии для поиска:");
            for (Integer i : LaptopFilter().keySet()) {
                System.out.println(i + " - " + LaptopFilter().get(i));
            }
            do {
                System.out.print("Введите номер критерия или 0 для поиска:  ");
                search = clientType.nextInt();
                if (search != 0) {
                    System.out.print(LaptopFilter().get(search) + "=> ");
                    resultFilter.put(search, clientType.next());
                }
            } while (search != 0);
            Set<Notebooks> filteredLaptops = filterSet(resultFilter);
            if (filteredLaptops.isEmpty()) {
                System.out.print("По выбранным данным ничего не нашлось,\nпоказать Вам все ноутбуки? (Y/N) => ");
                if ("Yy".contains(clientType.next())) {
                    resultFilter.clear();
                    resultFilter.put(0, "Поиск");
                    System.out.println();
                    for (Notebooks rate_notes : filterSet(resultFilter)) {
                        System.out.println(rate_notes.toString());
                        System.out.println();
                    }
                    System.out.print("Поищем что-то еще? (Y/N) => ");
                    Flag = "Yy".contains(clientType.next());

                } else {
                    System.out.print("Будете искать еще? (Y/N) => ");
                    Flag = "Yy".contains(clientType.next());
                }
            } else {
                System.out.println("\nЕсть " + filteredLaptops.size() + " ноутбука по вашему поиску:\n");
                for (Notebooks note : filteredLaptops) {
                    System.out.println(note.toString());
                    System.out.println();
                }
                System.out.print("Будете искать еще? (Y/N) => ");
                Flag = "Yy".contains(clientType.next());
            }
        } while (Flag);

        System.out.println("До свидания.");

        clientType.close();
    }

    static Set<Notebooks> filterSet(Map<Integer, String> map) {
        if (map.isEmpty()) return addLaptops();
        Set<Notebooks> notebooks = addLaptops();
        Set<Notebooks> set = new HashSet<>(notebooks);
        Map<String, String> colours = new HashMap<>();
        colours.put("чёрный", "Black");
        colours.put("черный", "Black");
        colours.put("серый", "Grey");
        colours.put("красный", "Red");
        Map<String, String> brand = new HashMap<>();
        brand.put("делл", "Dell");
        brand.put("МСИ", "MSI");
        brand.put("асус", "Asus");
        Map<String, String> os = new HashMap<>();
        os.put("линукс", "Linux");
        os.put("линакс", "Linux");
        os.put("виндоус", "Win10");
        os.put("винда", "Win10");
        os.put("вин", "Win10");
        os.put("win", "Win10");
        os.put("windows", "Win10");
        os.put("mac", "macOS");
        os.put("макос", "macOS");
        os.put("мак", "macOS");
        for (Notebooks notebook : notebooks) {

            if (map.containsKey(1) && notebook.RAM != Integer.parseInt(map.get(1))
                    || map.containsKey(2) && notebook.HDD != Integer.parseInt(map.get(2))
                    || map.containsKey(3) && !(notebook.Brand.equalsIgnoreCase(map.get(3)))
                    && !(notebook.Brand.equalsIgnoreCase(brand.get(map.get(3).toLowerCase())))
                    || map.containsKey(4) && !(notebook.OS.equalsIgnoreCase(map.get(4)))
                    && !(notebook.OS.equalsIgnoreCase(os.get(map.get(4).toLowerCase())))
                    || map.containsKey(5) && !(notebook.Colour.equalsIgnoreCase(colours.get(map.get(5).toLowerCase())))
                    && (!(notebook.Colour.equalsIgnoreCase(map.get(5))))
                    || map.containsKey(6) && notebook.Price >= Double.parseDouble(map.get(6))) {
                set.remove(notebook);

            }

        }
        return set;
    }

    static Map<Integer, String> LaptopFilter() {
        Map<Integer, String> laptopFilter = new HashMap<>(); // словарь критериев фильтрации
        laptopFilter.put(1, "Объем оперативной памяти");
        laptopFilter.put(2, "Объем жесткого диска");
        laptopFilter.put(3, "Марка ноутбука");
        laptopFilter.put(4, "Операционная система");
        laptopFilter.put(5, "Цвет");
        laptopFilter.put(6, "Максимальная цена");
        laptopFilter.put(0, "Поиск");
        return laptopFilter;
    }


}
