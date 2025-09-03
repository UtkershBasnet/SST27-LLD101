package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP instance;

    public EmployeeLDAPAdapter(EmployeeLDAP instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.get("uid");
    }

    @Override
    public String getFirstName() {
        return instance.get("givenName");
    }

    @Override
    public String getLastName() {
        return instance.get("sn");
    }

    @Override
    public String getEmail() {
        return instance.get("mail");
    }
}
