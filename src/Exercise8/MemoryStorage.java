package Exercise8;

import java.io.*;
import java.util.*;

// Define the DataStorage interface
interface DataStorage<T> {
    String store(T data); // return a unique ID for the stored data or the filename
    T retrieve(String source); // retrieve data from the specified source (like a file or database table or ID)
}


public class MemoryStorage<T> implements DataStorage<T> {
    private Map<String, T> dataMap;

    public MemoryStorage() {
        this.dataMap = new HashMap<>();
    }

    @Override


    public String store(T data) {
        return null;
    }


    @Override
    public T retrieve(String source) {
        // Retrieve the data from the map using the specified key
        return dataMap.get(source);
    }

    class FileStorage<T> implements DataStorage<T> {
        private String file;

        public FileStorage(String file) {
            this.file = file;

        }

        @Override
        public String store(T data) {
            try {
                File file = new File("C:\\Users\\kalas\\IdeaProjects\\lambda\\src\\Exercise8\\storage");
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }

                FileWriter writer = new FileWriter(file);
                writer.write(data.toString());
                writer.close();

                return "C:\\Users\\kalas\\IdeaProjects\\lambda\\src\\Exercise8\\storage";
            } catch (IOException e) {
                System.out.println("An error occurred while storing data.");
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public T retrieve(String source) {
            try {
                File myObj = new File("C:\\Users\\kalas\\IdeaProjects\\lambda\\src\\Exercise8\\storage");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            return null;
        }
    }
}




