import java.util.Objects;

public final class Person {
    private final long id;
    private final String lastName;
    private final String firstName;

    public Person(long ID, String lastName, String firstName) {
        this.id = ID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getID() {
        return this.id;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + this.id +
                ", lastName='" + this.lastName + '\'' +
                ", firstName='" + this.firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Person person)
                && (person.id == this.id)
                && (person.firstName.equals(this.firstName))
                && (person.lastName.equals(this.lastName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.lastName, this.firstName);
    }

}