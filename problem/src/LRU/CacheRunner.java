package LRU;

public class CacheRunner {

    public static void main(String[] args) {


      /*  Cache<String,String> lruCache = new LruCache<>(4);
        lruCache.put("swati","puru");
        System.out.println("head==1"+lruCache.gethead());
        System.out.println("tail==1"+lruCache.getTail());

        lruCache.put("atul","anam");
        System.out.println("head==2"+lruCache.gethead().key);
        System.out.println("tail==2"+lruCache.getTail().key);

        lruCache.put("rahul","neha");

        lruCache.get("swati");

        System.out.println("head==3"+lruCache.gethead());
        System.out.println("tail==3"+lruCache.getTail());


        lruCache.put("ansu","priyanka");

        lruCache.get("rahul");*/

        RankBasedCache rankBasedCache = new RankBasedCache(3);

        Employee employee1 = new Employee("swati",1);
        Employee employee2 = new Employee("puru",1);
        Employee employee22 = new Employee("abhi",2);
        Employee employee3 = new Employee("uttam",3);
        Employee employee4 = new Employee("atul",4);

        rankBasedCache.put("swati",employee1);
        rankBasedCache.put("puru",employee2);
        rankBasedCache.put("abhi",employee22);
        rankBasedCache.put("uttam",employee3);
        rankBasedCache.put("atul",employee4);









    }
}
