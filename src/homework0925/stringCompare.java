package homework0925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王旻爽
 * 2020/9/27
 * @ClassName stringCompare.java
 */
public class stringCompare {

    public static void main(String[] args) {


    }

    private List<String> compare(String[] str){

        Map<String,String> map = new HashMap<>();



        for (int i = 0; i < str.length; i++) {

            String preStr = str[i].substring(0,3);
            String numStr = str[i].substring(3);
            if(!map.containsKey(preStr)){
                map.put(preStr,numStr);
            } else {
                if(numStr.compareTo(preStr) > 0){
                    map.replace(preStr,numStr);
                }
            }

        }
        List<String> stringList = new ArrayList<>(map.keySet());
        return stringList;
    }
}
