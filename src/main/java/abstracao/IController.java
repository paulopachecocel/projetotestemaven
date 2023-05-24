package abstracao;

import model.ModeloAbstrato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Paulo_Note
 */

public interface IController <T extends ModeloAbstrato>{
    public abstract boolean salvar(T modelo) throws SQLException;
    public abstract boolean alterar(T modelo) throws SQLException;
    public abstract boolean excluir(T modelo) throws SQLException;
    public abstract boolean buscar(T modelo) throws SQLException;
    public abstract List<T> buscarTodos() throws SQLException;
    
}
