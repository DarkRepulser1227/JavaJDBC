package Utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesTools {

    public static String getValue(String key){
        /**
         * 该方法的作用是读取配置文件中的KEY并返回.利用IO流.
         * creater:GJM
         * @param key
         * @return
         */
        String val="";
        try {
            Properties prop=new Properties();
            InputStream in=new PropertiesTools().getClass().
                    getResourceAsStream("Appcon.Properties");
            prop.load(in);
            val=prop.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
