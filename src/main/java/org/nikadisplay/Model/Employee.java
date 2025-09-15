// MODEL: Employee

package org.nikadisplay.Model;

public class Employee {

    private Long id;
    private String name;
    private int salary;

    public Employee() {} // Empty constructor needed for JSON parsing?

    public Employee(Long id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long newId) { this.id = newId; }

    public String getName() { return name; }
    public void setName(String newName) { this.name = newName; }

    public int getSalary() { return salary; }
    public void setSalary(int newSalary ) { this.salary = newSalary; }
}
