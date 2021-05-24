package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ReaderFileJson {

    private ReaderFileJson() {
    }

    private static String readFile(String path) {
        try (InputStream fis = ReaderFileJson.class.getClassLoader().getResourceAsStream("testData\\"+path)) {
            StringBuilder S = new StringBuilder();
            Scanner sc = new Scanner(fis);
            while (sc.hasNext()) {
                S.append(sc.nextLine());
            }
            fis.close();
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
