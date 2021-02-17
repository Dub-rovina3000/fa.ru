public class HourlyRatedEmp extends Employee {

    private double rate;
    private double salary;

    public HourlyRatedEmp(int id, String name, int rate) {
        super(id, name);
        this.rate = rate;
        countSalary();
    }

    /**
     *
     */

    @Override
    void countSalary() {
        salary = 20.8*8*rate;
    }

    /**
     *
     * @return double salary
     */
    @Override
    public double getSalary() {
        return salary;
    }
}
