import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessarDB {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connection conexao = null;
		try {
			conexao = FabricaConexoes.getConection();
			System.out.println("Conectado");
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao se conectar com o BD");
		}
		
		String sql = "INSERT INTO principal.usuario "+"(id, nome) "+ "VALUES (?, ?)";
		
		PreparedStatement gravarDados = null;
		
		if(conexao != null) {
			try {
				gravarDados = conexao.prepareStatement(sql);//A classe PreparedStatement
				//é responsavel por gravar os dados no banco de dados, o metodo prepareStatement, que está
				//presente na classe Connection, atribui uma query de inserção ao meu gravarDados.
			}
			catch(SQLException e) {
				System.out.println("Não possivel gravar os dados para a inserção.");
			}
		}
		
		if(gravarDados != null) {
			try {
				gravarDados.setInt(1, 3);
				gravarDados.setString(2, "Tarcisio de Sousa Neto");//Através da classe PreparedStatement, com o
				//método setString, é possivel colocar uma string a minha coluna na query(que será executada).
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao referenciar uma string ao meu gravarDados.");
			}
		}
		
		try {
			gravarDados.execute();//Através do método execute, é executado a query de inserção, adicionado
			//os dados no banco de dados.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			gravarDados.close();//É nescessario fechar a variavel que gravou as informações no bnaco de dados.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi possivel fechar a variavel que grava as informações no banco de dados.");
		}
		
		try {
			conexao.close();//Método que fecha a conexão com o banco de dados.
			System.out.println("Conexão fechada.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi possivel fechar a conexão com o banco de dados.");
		}
		
	}

}
