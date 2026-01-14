package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;

//Cria e retorna um obj SellerDaoJDBC
public class DaoFactory {

    /*
SellerDaoJDBC → é a classe que sabe conversar com o banco de dados (via JDBC).

DB → é a classe que sabe abrir uma conexão com o banco MySQL.

DaoFactory → é a “fábrica” que cria objetos DAO prontos para uso.

    */

    public static SellerDao createSellerDao() {
        //DB.getConnection() Abre ou reutiliza uma conexão com o banco de dados
        //new SellerDaoJDBC cria um DAO passando essa conexão
        return new SellerDaoJDBC(DB.getConnection());
    }
}
