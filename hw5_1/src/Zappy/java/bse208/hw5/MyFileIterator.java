package Zappy.java.bse208.hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MyFileIterator implements Iterable<String> {

    private Scanner scanner;

    public MyFileIterator(String pathToFile) {
        try {
            File iterableFile = new File(pathToFile);
            if (!iterableFile.exists() || !iterableFile.isFile()) {
                throw new FileNotFoundException(pathToFile + " - file not exits");
            } else {
                this.scanner = new Scanner(iterableFile);
            }
        } catch (SecurityException ex) {
            System.out.println("Не удается получить доступ к файлу: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Возникла непредвиденная ошибка при работе с файлом: " + ex.getMessage());
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return scanner != null && scanner.hasNext();
            }

            @Override
            public String next() {
                return scanner.nextLine();
            }
        };
    }
}
