package Zappy.java.bse208.hw5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        try (MyFileIterator iterator = new MyFileIterator(path)) {
            while (iterator.hasNext()) {
                String line = iterator.next();
                System.out.println(line);
            }
        } catch (SecurityException ex) {
            System.out.println("Не удается получить доступ к файлу: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Ошибка при работе с файлом: " + ex.getMessage());
        }
    }
}
