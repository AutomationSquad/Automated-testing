package entities;

import java.util.Objects;

public class User {
    private String login;
    private String password;

    private Double salaryRatePerHour;
    private Byte workingHours;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalaryRatePerHour() {
        return salaryRatePerHour;
    }

    public void setSalaryRatePerHour(Double salaryRatePerHour) {
        this.salaryRatePerHour = salaryRatePerHour;
    }

    public Byte getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Byte workingHours) {
        this.workingHours = workingHours;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
