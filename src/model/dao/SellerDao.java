package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;
//Interface que define o que pode ser feito com os vendedores
public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();

}
