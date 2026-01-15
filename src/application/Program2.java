package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Locale;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);
/*
        System.out.println("=== TEST 1: Department Insert ===");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Department inserted successfully, new id: " + newDepartment.getId());
        System.out.println();
*/
        System.out.println("=== TEST 2: Department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);
        System.out.println();

        System.out.println("=== TEST 3: Department Update ===");
        department = departmentDao.findById(3);
        department.setName("Market");
        departmentDao.update(department);
        System.out.println("Department updated successfully");

        /*
        System.out.println("=== TEST 4: Department DeleteById ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department deleted successfully");
*/
        System.out.println("=== TEST 4: Department findAll ===");
        departmentDao.findAll().forEach(System.out::println);
    }
}
