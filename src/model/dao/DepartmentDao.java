package model.dao;

import model.entities.Department;

import java.util.List;
//Interface que define o que pode ser feito com os departamentos
public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
