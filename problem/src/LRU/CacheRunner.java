package LRU;

public class CacheRunner {

    public static void main(String[] args) {


        Cache<String,String> lruCache = new LruCache<>(4);
        lruCache.put("swati","puru");
        System.out.println("head==1"+lruCache.gethead().key);
        System.out.println("tail==1"+lruCache.getTail().key);

        lruCache.put("atul","anam");
        System.out.println("head==2"+lruCache.gethead().key);
        System.out.println("tail==2"+lruCache.getTail().key);

        lruCache.put("rahul","neha");

        lruCache.get("swati");

        System.out.println("head==3"+lruCache.gethead().key);
        System.out.println("tail==3"+lruCache.getTail().key);


        lruCache.put("ansu","priyanka");

        lruCache.get("rahul");

    /*    RankBasedCache rankBasedCache = new RankBasedCache(3);

        Employee employee1 = new Employee("swati",1);
        Employee employee2 = new Employee("puru",2);
        Employee employee5 = new Employee("dudu",3);
        Employee employee6 = new Employee("chikki",4);
        Employee employee22 = new Employee("abhi",5);
        Employee employee3 = new Employee("uttam",6);
        Employee employee4 = new Employee("atul",7);

        rankBasedCache.put("swati",employee1);
        rankBasedCache.put("puru",employee2);
        rankBasedCache.put("abhi",employee22);
        rankBasedCache.put("uttam",employee3);
        rankBasedCache.put("atul",employee4);

        List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4, employee22, employee5, employee6);


        Cache concurrent = new ConcurrentRankBasedCache<>(3);
        AtomicInteger at = new AtomicInteger();

        Runnable me = new Runnable() {
            @Override
            public void run() {
                while(at.get()<list.size()){
                    Employee employee = list.get(at.getAndIncrement());
                    System.out.println(employee.name);
                    concurrent.put(employee.name,employee);
                    concurrent.gethead();

                }

            }
        };

        Thread t1= new Thread(me);
        Thread t2 = new Thread(me);

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(at.get()<=list.size()){
                    concurrent.gethead();
                }


            }
        });
       // t3.start();

        t1.start();
        t2.start();

*/














    }
}
