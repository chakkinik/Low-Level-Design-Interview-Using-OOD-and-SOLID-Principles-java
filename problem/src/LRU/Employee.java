package LRU;

public class Employee extends Rank{
    String name;

    public Employee(String name,int rank) {
        super(rank);
        this.name = name;
    }
}
