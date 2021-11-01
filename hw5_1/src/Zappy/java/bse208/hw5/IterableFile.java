package Zappy.java.bse208.hw5;

import java.io.*;
import java.util.Iterator;

public class IterableFile implements Iterable<String> {

    private BufferedReader bufferedReader;

    public IterableFile(String pathToFile) throws FileNotFoundException, SecurityException {
        File iterableFile = new File(pathToFile);
        if (!iterableFile.exists() || !iterableFile.isFile()) {
            throw new FileNotFoundException(pathToFile + " - file not exits");
        }
        bufferedReader = new BufferedReader(new FileReader(iterableFile));
    }

    public void close() {
        try {
            bufferedReader.close();
            bufferedReader = null;
        } catch (IOException ex) {
            System.out.println("Error - " + ex.getMessage());
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                try {
                    bufferedReader.mark(1);
                    if (bufferedReader.read() < 0) {
                        return false;
                    }
                    bufferedReader.reset();
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            }

            @Override
            public String next() {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    return null;
                }
            }
        };
    }
}
