package br.org.sesisp.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Aluno;
 
public class CrudDAO {
	//crud C-create R-read U-update D-delete
	//creat(inserir dados)
	public void create(Aluno aluno) {
		String sql = "INSERT INTO alunos(nome, idade) VALUE (?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}//fim CREATE
	//************************************************
	//metodo U-update
	public void update(Aluno aluno) {
		String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE ra = ? ";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.setInt(3, aluno.getRa());
			p.execute();//"grava" dados no banco
			JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso");
			System.out.println("Dados atualizados com sucesso");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}//fim Update
	//************************************************
	//metodo R-read
	public List<Aluno> read() {
		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			resultado = p.executeQuery();
			while(resultado.next()) {
				Aluno var_aluno = new Aluno();
				//recuperar ra
				var_aluno.setRa(resultado.getInt("ra"));
				//recuperar nome
				var_aluno.setNome(resultado.getString("Nome"));
				//recuperar idade
				var_aluno.setIdade(resultado.getInt("Idade"));
				alunos.add(var_aluno);
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
			}finally {
				try {
					if(p != null);
					p.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			return alunos;
	}//fim Read
	//************************************************
	//metodo D-delete
	public boolean delete(int ra) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setInt(1, ra);
			p.execute();
			JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso");
			System.out.println("Dados atualizados com sucesso");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}//fim Delete 
}//fim classe CrudDAO