// MODEL: Employee

package org.nikadisplay.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="salary")
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
