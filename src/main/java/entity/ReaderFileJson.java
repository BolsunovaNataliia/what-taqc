package entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jws.soap.SOAPBinding;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReaderFileJson {

    private ReaderFileJson() {
    }

    private static String readFile(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            StringBuilder S = new StringBuilder();
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNext()) {
                S.append(sc.nextLine());
            }
            fileReader.close();
            return S.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> readFileJsonListUser(String path){
        String json = readFile(path);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, new TypeReference<List<User>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User readFileJsonUser(String path){
        String json = readFile(path);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
