package Zappy.java.bse208.hw5;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        new MyFileIterator(path).forEach(System.out::println);
    }
}
