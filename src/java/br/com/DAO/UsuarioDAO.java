/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.Model.Usuario;
import br.com.Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willian
 */
public class UsuarioDAO {

    //variável que vai receber uma conexão da ConnectionFactory

    private Connection con;
    /*Método construtor, toda vez que alguma classe invocar um
     novo objeto UsuarioDAO, esse método é chamado e pega uma 
     conexão e armazena na variavel local 'con'
     */

    public UsuarioDAO() throws Exception {
        try {
            this.con = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    /*metodo de retorno booleano, se cadastrar ele retorna
     verdadeiro e se der algum problema retorna falso pra quem 
     invocou esse método
     */

    public boolean cadastrar(Usuario usuario) {
        //objeto que prepara a string SQL e seus parâmetros
        PreparedStatement stmt = null;
        //String que recebe uma instrução SQL de inserção de dados na tabela
        String sql = "INSERT INTO usuario(nome_usuario, email_usuario, senha_usuario)"
                + "VALUES (?,?,?);";
        //bloco de testes
        try {
            //con prepara a string SQL para um objeto STMT
            stmt = con.prepareStatement(sql);
            //fazendo o vinculo dos parâmetros sql
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            //executando a string SQL com os parâmetros prontos
            stmt.execute();
            //caso a linha acima de certo, retorna verdadeiro
            return true;
            //bloco de captura de exceções
        } catch (Exception e) {
            /*envia uma mensagem no console do servidor
              junto com a mensagem de erro*/
            System.out.println("Problemas ao cadastrar usuário!!"
                    + e.getMessage());
            //retorna falso porque algo deu errado :(
            return false;
        } finally { /*é executado independente se der certo ou errado
            esse bloco fecha a conexão com o banco de dados para 
            evitar possiveis falhas de segurança 
            */
            try {
                ConnectionFactory.closeConnection(con, stmt);
            } catch (Exception e) {
                System.out.println("Problemas "
                        + "ao fechar conexão com o banco" + e.getMessage());
            }
        }
    }

    /*Método que retorna uma lista de usuários*/
    public List<Usuario> listar() {
        //Cria um objeto do tipo lista de usuários (vazio)
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        //objeto que armazena um resultado de uma consulta SQL
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select * from usuario order by id_usuario";
        try {
            stmt = con.prepareStatement(sql);
            //executando uma String SQL de consulta e armazenando o resultado na variavel RS
            rs = stmt.executeQuery();
            //enquanto houver registros na consulta...
            while (rs.next()) {
                /*a cada iteração no while
                cria-se umnovo objeto usuario
                e repassa as informações do banco para esse objeto*/
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                //pega o usuário completo e armazena na lista de usuários
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Problemas ao listar os usuários" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas "
                        + "ao fechar conexão com o banco" + e.getMessage());
            }
        }
        //retorna a lista de usuários da consulta do banco
        return usuarios;
    }
    // método que exclui uma tupla de usuário no banco
    public void excluir(int idUsuario) {
        PreparedStatement stmt = null;
        String sql = "delete from usuario where id_usuario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Problemas ao excluir"
                    + " usuário! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(con, stmt);
            } catch (Exception e) {
                System.out.println("Problemas "
                        + "ao fechar conexão com o banco" + e.getMessage());
            }
        }
    }
    //Metodo que retorna um usuário do banco de acordo com o seu ID
    public Usuario retornar(int idUsuario) {
        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from usuario where id_usuario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Problemas ao retornar usuário" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(con, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados" + e.getMessage());
                e.printStackTrace();
            }
        }

        return usuario;
    }
    
    //metódo que altera informações dos usuários no banco de dados
    //retorna verdadeiro se tudo der certo ou falso se algo der errado
    public boolean alterar(Usuario usuario) {
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario= ? WHERE id_usuario = ?;";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao alterar o usuário" + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(con, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão com o banco de dados" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //Método que retorna um usuário do banco caso o login e senha passados estejam corretos
    public Usuario logar(Usuario model) {
        PreparedStatement stmt = null;
        Usuario usuario = null;
        ResultSet rs = null;
        String sql = "select * from usuario where "
                + "email_usuario = ? and senha_usuario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, model.getEmailUsuario());
            stmt.setString(2, model.getSenhaUsuario());
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Problemas ao fazer login!!! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.close(con, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fazer conexão com o banco de dados!! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
