package DAO;

import anotations.*;
import conexao.Conexao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {
    private Connection con;

    public GenericDAO() throws SQLException, ClassNotFoundException {
        this.con = Conexao.getConexao();
    }
    private boolean ePersistido(T objeto) {
        return null != objeto.getClass().getDeclaredAnnotation(Entity.class);
    }

    private boolean ePersistido(Field atributo) {
        return null == atributo.getDeclaredAnnotation(Transient.class);
    }

    private boolean aceitaNulo(Field atributo) {
        return null == atributo.getDeclaredAnnotation(NotNull.class);
    }
    public void criarTabelaSeNaoExistir(T objeto)
            throws IllegalArgumentException,
            IllegalAccessException,
            SQLException {
        if(!ePersistido(objeto)) {
            throw new IllegalArgumentException("A classe deste objeto n�o � uma entidade!");
        }

        String instrucaoSQL = "CREATE TABLE IF NOT EXISTS " + getNomeTabela(objeto) + " ( ";
        Field[] atributos = objeto.getClass().getDeclaredFields();
        for(Field atributo: atributos) {
            if(!ePersistido(atributo)) {
                continue;
            }
            instrucaoSQL += getNomeColuna(atributo) + " ";
            if(eId(atributo)) {
                instrucaoSQL += "SERIAL PRIMARY KEY NOT NULL ";
            } else {
                if(atributo.getType().getSimpleName().equals("String")) {
                    instrucaoSQL += " VARCHAR(255)";
                } else if(atributo.getType().getSimpleName().equals("int") || atributo.getType().getSimpleName().equals("Integer")) {
                    instrucaoSQL += " INTEGER";
                } else if(atributo.getType().getSimpleName().equalsIgnoreCase("double")) {
                    instrucaoSQL += " REAL ";
                }
                if(!aceitaNulo(atributo)) {
                    instrucaoSQL += "NOT NULL";
                }
            }
            instrucaoSQL += ", ";
        }
        instrucaoSQL = instrucaoSQL.substring(0, instrucaoSQL.length() - 2) + ")";
        PreparedStatement sql = con.prepareStatement(instrucaoSQL);
        System.out.println(instrucaoSQL);
        sql.execute();
    }
    private String getNomeTabela(T objeto) {
        Table table = objeto.getClass().getDeclaredAnnotation(Table.class);
        if(null == table || table.name().equals(Constants.NO_NAME)) {
            return "_" + objeto.getClass().getSimpleName().toLowerCase();
        }
        return table.name();
    }
    private String getNomeColuna(Field atributo) {
        Column column = atributo.getDeclaredAnnotation(Column.class);
        if(null == column || column.name().equals(Constants.NO_NAME)) {
            return atributo.getName().toLowerCase();
        }
        return column.name();
    }
    private boolean eId(Field atributo) {
        return null != atributo.getDeclaredAnnotation(Id.class);
    }

    private Field getId(Object objeto) {
        Field[] atributos = objeto.getClass().getDeclaredFields();
        for(Field atributo: atributos) {
            if(eId(atributo)) {
                return atributo;
            }
        }
        return null;
    }
    public void create(T entidade) throws SQLException, IllegalAccessException {

            if(!ePersistido(entidade)) {
                throw new IllegalArgumentException("A classe deste objeto não é uma entidade!");
            }

            criarTabelaSeNaoExistir(entidade);

            String instrucaoSQL = "INSERT INTO " + getNomeTabela(entidade) + "(";

            String fimSQL = " VALUES(";
            Field[] atributos = entidade.getClass().getDeclaredFields();
            for(Field atributo: atributos) {
                if(eId(atributo) || !ePersistido(atributo)) {
                    continue;
                }
                instrucaoSQL += getNomeColuna(atributo) + ", ";
                fimSQL += "?, ";
            }

            instrucaoSQL = instrucaoSQL.substring(0, instrucaoSQL.length() - 2) + ")";
            fimSQL = fimSQL.substring(0, fimSQL.length() - 2) + ")";
            instrucaoSQL += fimSQL;

            PreparedStatement sql = con.prepareStatement(instrucaoSQL);
            int numeroInterrogacao = 1;
            for(Field atributo: atributos) {
                if(eId(atributo) || !ePersistido(atributo)) {
                    continue;
                }

                atributo.setAccessible(true);
                sql.setObject(numeroInterrogacao++, atributo.get(entidade));
                atributo.setAccessible(false);
            }
            sql.execute();
    }
    public List<T> getAll(T objeto)
            throws IllegalArgumentException,
            IllegalAccessException,
            SQLException,
            InstantiationException,
            InvocationTargetException,
            NoSuchMethodException,
            SecurityException {

        if (!ePersistido(objeto)) {
            throw new IllegalArgumentException("A classe deste objeto n�o � uma entidade!");
        }

        criarTabelaSeNaoExistir(objeto);

        String instrucaoSQL = "SELECT ";

        Field[] atributos = objeto.getClass().getDeclaredFields();
        for (Field atributo : atributos) {
            if (!ePersistido(atributo)) {
                continue;
            }
            instrucaoSQL += getNomeColuna(atributo) + ", ";
        }

        instrucaoSQL = instrucaoSQL.substring(0, instrucaoSQL.length() - 2);
        instrucaoSQL += " FROM " + getNomeTabela(objeto);

        PreparedStatement sql = con.prepareStatement(instrucaoSQL);

        ResultSet resultado = sql.executeQuery();
        List<T> listaRetorno = new ArrayList<>();
        while (resultado.next()) {

            T retorno = (T) objeto.getClass().getConstructor().newInstance();
            for (Field atributo : atributos) {
                if (!ePersistido(atributo)) {
                    continue;
                }

                atributo.setAccessible(true);
                if (atributo.getType().getSimpleName().equals("String")) {
                    atributo.set(retorno, resultado.getString(getNomeColuna(atributo)));
                } else if (atributo.getType().getSimpleName().equals("int") || atributo.getType().getSimpleName().equals("Integer")) {
                    atributo.set(retorno, resultado.getInt(getNomeColuna(atributo)));
                } else if (atributo.getType().getSimpleName().equalsIgnoreCase("long")) {
                    atributo.set(retorno, resultado.getLong(getNomeColuna(atributo)));
                } else if (atributo.getType().getSimpleName().equalsIgnoreCase("double")) {
                    atributo.set(retorno, resultado.getDouble(getNomeColuna(atributo)));
                }
                atributo.setAccessible(false);
            }

            listaRetorno.add(retorno);

        }
        return listaRetorno;
    }
    public void delete(T objeto)
            throws IllegalArgumentException,
            IllegalAccessException,
            SQLException {

        if(!ePersistido(objeto)) {
            throw new IllegalArgumentException("A classe deste objeto não é uma entidade!");
        }

        criarTabelaSeNaoExistir(objeto);

        String instrucaoSQL = "DELETE FROM " + getNomeTabela(objeto);

        Field id = getId(objeto);
        instrucaoSQL += " WHERE " + getNomeColuna(id) + "=?";

        PreparedStatement sql = con.prepareStatement(instrucaoSQL);
        id.setAccessible(true);
        sql.setObject(1, id.get(objeto));
        id.setAccessible(false);
        sql.execute();
    }

}


