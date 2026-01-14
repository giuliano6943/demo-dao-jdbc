package model.entities;

import java.io.Serializable;
import java.util.Date;
//Tabela dos vendedores
//Guardam dados e tem getters e setters
public class Seller implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private Date Birthday;
    private Double baseSalary;
    private Department department;

    public Seller(){}

    public Seller(Integer id, String name, String email, Date birthday, Double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        Birthday = birthday;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;
        return id.equals(seller.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Birthday=" + Birthday +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }


}
