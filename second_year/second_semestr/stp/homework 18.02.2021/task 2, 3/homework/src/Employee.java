abstract public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * @return int id of the employee
     */
    public int getId() {
        return id;
    }

    /**
     * @return String name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * @param id id of the employee
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    abstract void countSalary();

    abstract double getSalary();
}
