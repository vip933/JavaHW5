package Zappy.java.bse208.hw5;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        IterableFile iterator;
        try {
            iterator = new IterableFile(path);
            iterator.forEach(System.out::println);
        } catch (SecurityException ex) {
            System.out.println("Не удается получить доступ к файлу: " + ex.getMessage());
            return;
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
            return;
        }
        iterator.close();
    }
}
