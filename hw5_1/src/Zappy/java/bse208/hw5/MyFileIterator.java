package Zappy.java.bse208.hw5;

import java.io.*;
import java.util.Iterator;

public class MyFileIterator implements Iterator<String>, AutoCloseable {

    private final BufferedReader bufferedReader;
    private String nextLine = null;

    public MyFileIterator(String pathToFile) throws SecurityException, FileNotFoundException {
        File iterableFile = new File(pathToFile);
        if (!iterableFile.exists() || !iterableFile.isFile()) {
            throw new FileNotFoundException(pathToFile + " - file not exits");
        }
        bufferedReader = new BufferedReader(new FileReader(iterableFile));
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
        System.out.println("Successfully closed file!");
    }

    @Override
    public boolean hasNext() {
        try {
            nextLine = bufferedReader.readLine();
            return nextLine != null;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public String next() {
        if (nextLine == null) {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        } else {
            String str = nextLine;
            nextLine = null;
            return str;
        }
    }
}
