public class FixedRatedEmp extends Employee {

    private double rate;
    private double salary;

    public FixedRatedEmp(int id, String name, double rate) {
        super(id, name);
        this.rate = rate;
        countSalary();
    }

    @Override
    void countSalary() {
        salary = rate;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
