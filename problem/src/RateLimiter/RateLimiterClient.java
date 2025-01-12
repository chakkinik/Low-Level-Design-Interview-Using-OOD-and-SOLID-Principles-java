package RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterClient {


    private int limit = 20;
    private long duration = 1000;



    private Map<String, List<Long>> map = new ConcurrentHashMap<>();

    public boolean rateLimite(String user) {

        long l = System.currentTimeMillis();
        if (map.containsKey(user)) {
            List<Long> arr = map.get(user);
            arr.add(l);
            long l1 = l - duration;
            // we can do use binary search since it sorted..

            for (int i = 0; i < arr.size(); i++) {
                Long curr = arr.get(i);
                if (curr < l1) {
                    arr.remove(curr);
                }
            }

            if (arr.size() > limit) {
                return false;
            }


        } else {
            List<Long> list = new ArrayList<>();
            list.add(l);
            map.put(user, list);
        }

        return true;

    }

    public static void main(String[] args) throws InterruptedException {

        RateLimiterClient rlc = new RateLimiterClient();
      int   i=0;
        while(true){

            boolean u1 = rlc.rateLimite("u1");
            System.out.println("==="+u1);


            if(i==30 || i==90){
                Thread.sleep(1000);
            }


            if(i==100){
                break;
            }

            i++;
        }

    }

}
