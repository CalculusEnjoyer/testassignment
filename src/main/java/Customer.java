import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private double amountOfMoney;

    public Customer(String firstName, String lastName, double amountOfMoney){
        this.lastName = Objects.requireNonNull(lastName);
        this.firstName = Objects.requireNonNull(firstName);
        this.amountOfMoney = amountOfMoney;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName);
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.getAmountOfMoney(), getAmountOfMoney()) == 0 &&
                              getFirstName().equals(customer.getFirstName()) &&
                              getLastName().equals(customer.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAmountOfMoney());
    }
}
