package Utils;

import View.systemView;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Tools {
    /**
     * 判断是否输入为数字并返回该数字
     * @param str
     * @return
     */
    static public int getNum(String str){
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(str);
                return choice;
            } catch (Exception e) {
                systemView.viewOut("请输入正确的数字");
            }
        }
    }

    /**
     * 判断是否输入Double并返回小数至小数点后一位
     * @param str
     * @return
     */
    static public double getDouble(String str){
        while (true) {
            if (isDouble(str)) {
                BigDecimal bigDecimal = new BigDecimal(str);
                return Double.parseDouble(bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).toString());
            } else {
                System.out.println("请输入正确的小数");
            }
        }

    }

    static public boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d*)?|\\.\\d+$");
        return pattern.matcher(str).matches();
    }
}
