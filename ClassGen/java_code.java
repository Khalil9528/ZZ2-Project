Here is the Java class `Isima`:

```java
/**
 * This class represents a person's name.
 */
public class Isima {
    private String loic;
    private String susan;
    private String patrice;

    /**
     * Constructor for creating an instance of Isima.
     *
     * @param loic  the person's first name
     * @param susan the person's middle name
     * @param patrice the person's last name
     */
    public Isima(String loic, String susan, String patrice) {
        this.loic = loic;
        this.susan = susan;
        this.patrice = patrice;
    }

    /**
     * Gets the first name.
     *
     * @return the person's first name
     */
    public String getLoic() {
        return loic;
    }

    /**
     * Sets the first name.
     *
     * @param loic the new value for the first name
     */
    public void setLoic(String loic) {
        this.loic = loic;
    }

    /**
     * Gets the middle name.
     *
     * @return the person's middle name
     */
    public String getSusan() {
        return susan;
    }

    /**
     * Sets the middle name.
     *
     * @param susan the new value for the middle name
     */
    public void setSusan(String susan) {
        this.susan = susan;
    }

    /**
     * Gets the last name.
     *
     * @return the person's last name
     */
    public String getPatrice() {
        return patrice;
    }

    /**
     * Sets the last name.
     *
     * @param patrice the new value for the last name
     */
    public void setPatrice(String patrice) {
        this.patrice = patrice;
    }
}
```

This class has three private instance variables (loic, susan, and patrice), each with a corresponding getter method to get its value. There are also setter methods for setting the values of these variables.

You can compile and use this class as follows:

```java
public class Main {
    public static void main(String[] args) {
        // Create an instance of Isima
        Isima isima = new Isima("Jean", "Marie", "DUPONT");

        // Print the values
        System.out.println("First Name: " + isima.getLoic());
        System.out.println("Middle Name: " + isima.getSusan());
        System.out.println("Last Name: " + isima.getPatrice());

        // Update the middle name
        isima.setSusan("Alice");

        // Print the updated values
        System.out.println("\nUpdated Values:");
        System.out.println("First Name: " + isima.getLoic());
        System.out.println("Middle Name: " + isima.getSusan());
        System.out.println("Last Name: " + isima.getPatrice());
    }
}
```

This will output:

```
First Name: Jean
Middle Name: Marie
Last Name: DUPONT

Updated Values:
First Name: Jean
Middle Name: Alice
Last Name: DUPONT
```