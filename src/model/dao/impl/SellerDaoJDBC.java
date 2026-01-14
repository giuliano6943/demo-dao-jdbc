package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Classe que vai implementar de verdade os métodos da interface SellerDao
public class SellerDaoJDBC implements SellerDao {

    //Criando a conexão com o Banco de dados
    private Connection conn;
    //Construtor que tras essa conexão vinda da classe DB
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //Montando uma querySQL que busca o vendedor pelo ID
            //O ? é substituido pelo valor do parametro no setInt
            st = conn.prepareStatement(
                        "SELECT seller.*,department.Name as DepName\n" +
                            "FROM seller INNER JOIN department\n" +
                            "ON seller.DepartmentId = department.Id\n" +
                            "WHERE seller.Id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            //Verificando se existe algum registro retornado
            if(rs.next()){
                //Convertendo o resultado da consulta em objetos Java, Department e Seller
                //Está dizendo que basicamente altere o Id e o nome do objeto dep pelo Id e Name da tabela.
                //E a mesma coisa com Seller
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    //Criação do metodo instantiateSeller que traz todos os dados da tabela do sql
    //Transformando esses dados em variaveis da classe Seller
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj =new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthday(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "ORDER BY Name");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public List<Seller> findByDepartment(Department department) {
    //Objetivo: declarar variáveis para o comando SQL (st) e o resultado da consulta (rs).
    //Por que: você precisa fechá-las no finally, então declara fora do try.

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //Query SQL que busca todos os vendedores ligados a um departamento específico
            //Esse departamento é passado em DepartmentId = ?
            // ? é substituido pelo departamento passado como parâmetro
            //se você passar Department(2, null), ele vai buscar todos os vendedores do departamento com ID = 2.
            st = conn.prepareStatement(
                    "   SELECT seller.*,department.Name as DepName\n" +
                            "FROM seller INNER JOIN department\n" +
                            "ON seller.DepartmentId = department.Id\n" +
                            "WHERE DepartmentId = ?\n" +
                            "ORDER BY Name");
            //Substituir o ? pelo ID do departamento recebido como parâmetro
            st.setInt(1,department.getId());
            //Executa a consulta e armazena todas as linhas de vendedores desse departamento
            rs = st.executeQuery();



            //Lista criada para armazenar todos os vendedores encontrados
            List<Seller> list = new ArrayList<>();
            //Map criado para evitar criar objetos Department repetidos
            //Ou seja, se vários vendedores pertencem ao mesmo departamento, você reaproveita o mesmo objeto Department—isso economiza memória e mantém consistência.
            //👉 Se 10 vendedores forem do mesmo departamento, você reaproveita o mesmo objeto Department.
            Map<Integer,Department> map = new HashMap<>();
            //Percorre cada linha retornada pela consulta
            while(rs.next()){
                //Pega o valor da coluna DepartmentId da linha atual
                //Usa esse valor para procurar no map se já existe um Department criado por esse ID
                //Caso não encontre esse departmentId ele vai retornar um null para a variável dep
                Department dep = map.get(rs.getInt("DepartmentId"));
                //Verifica se já existe um Department no map
                //Se nao existir cria um novo com instantiateDepartment(rs) e guarda no map
                if(dep == null){
                    //Se ainda não tiver esse department no map, crie ele, e atribua a variável dep
                    //Esse metodo lê os dados da linha (DepartmentId e DepName) e monta o objeto Department
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                //Cria um seller passando o departamento correto
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
