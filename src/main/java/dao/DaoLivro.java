package dao;

import abstracao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import model.Livro;

/**
 *
 * @author Paulo_Note
 */
public class DaoLivro implements IDao<Livro>{
    
    public boolean salvar(Livro modelo) throws SQLException {

            //Logger logger = Logger.getLogger(DaoLivro.class);

            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "INSERT INTO livro (issn, nome, resenha, editora, autor) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, modelo.getIssn());
            preparedStatement.setString(2, modelo.getNome());
            preparedStatement.setString(3, modelo.getResenha());
            preparedStatement.setString(4, modelo.getEditora());
            preparedStatement.setString(5, modelo.getAutor());
            //logger.info("String insert preparada: "+preparedStatement);
            int resultado = preparedStatement.executeUpdate();
            if (resultado > 0) {
                    return true;
            }else {
                    return false;
            }

    }

    public boolean alterar(Livro modelo) throws SQLException {
            //Logger logger = Logger.getLogger(DAOLivro.class);

            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "update livro set issn = ?, nome = ?, resenha = ?, editora = ?, autor = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, modelo.getIssn());
            preparedStatement.setString(2, modelo.getNome());
            preparedStatement.setString(3, modelo.getResenha());
            preparedStatement.setString(4, modelo.getEditora());
            preparedStatement.setString(5, modelo.getAutor());
            preparedStatement.setInt(6, modelo.getId());
            //logger.info("String update preparada: "+preparedStatement);
            int resultado = preparedStatement.executeUpdate();
            if (resultado > 0) {
                    return true;
            }else {
                    return false;
            }
    }

    public boolean excluir(Livro modelo) throws SQLException {
            //Logger logger = Logger.getLogger(DAOLivro.class);

            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "delete from livro where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, modelo.getId());
            //logger.info("String delete preparada: "+preparedStatement);
            int resultado = preparedStatement.executeUpdate();
            if (resultado > 0) {
                    return true;
            }else {
                    return false;
            }
    }

    public boolean buscar(Livro modelo) {
            return false;
    }

    public List<Livro> buscarTodos() throws SQLException {
            //Logger logger = Logger.getLogger(DAOLivro.class);

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from livro";
            List<Livro> livros = new ArrayList<Livro>();
            Livro livro;

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            //logger.info("Consulta executada: "+preparedStatement);

            while (resultSet.next()) {
                    livro = new Livro();
                    livro.setId(resultSet.getInt("id"));
                    livro.setIssn(resultSet.getInt("issn"));
                    livro.setNome(resultSet.getString("nome"));
                    livro.setResenha(resultSet.getString("resenha"));
                    livro.setEditora(resultSet.getString("editora"));
                    livro.setAutor(resultSet.getString("autor"));
                    livros.add(livro);
                    //logger.info("Livro adicionado: "+ livro.getNome());
            }

            //logger.info("Quantidade de livros: "+livros.size());

            return livros;
    }

    @Override
    public boolean salvar(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean alterar(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean buscar(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Livro> buscarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
