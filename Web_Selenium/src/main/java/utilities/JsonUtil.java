package utilities;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonUtil {

    public static <T> T gsonToType(String filePath, Type type) {
        Gson gson = new Gson();
        T ret = null;
        try {
            FileReader reader = new FileReader(filePath);
            ret = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ret;
    }
}

