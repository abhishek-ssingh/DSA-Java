import java.util.*;

public class countFreqOfEle {


    public static void main(String[] args) {

        int[] arr1 = new int[]{4,41,2,1,4,4,7,1,3,5,2};

//        need hashmap to set each value
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int key: arr1){
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key,1);
            }

        }


    }
}
