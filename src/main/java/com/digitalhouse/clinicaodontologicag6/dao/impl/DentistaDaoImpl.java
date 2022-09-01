package com.digitalhouse.clinicaodontologicag6.dao.impl;

import com.digitalhouse.clinicaodontologicag6.dao.ConfigJDBC;
import com.digitalhouse.clinicaodontologicag6.dao.IDao;
import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import org.apache.log4j.Logger;

import java.sql.*;

public class DentistaDaoImpl implements IDao<DentistaEntity> {
    private ConfigJDBC configJDBC;
    final static Logger logger = Logger.getLogger(DentistaDaoImpl.class);
    private Connection connection = configJDBC.conectarBD();

    public DentistaDaoImpl(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }
    @Override
    public DentistaEntity create(DentistaEntity dentistaEntity) {
        Connection connection = configJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("INSERT INTO dentista(nome,sobrenome,matricula) VALUES('%s','%s','%s')",
                dentistaEntity.getNome(), dentistaEntity.getSobrenome(), dentistaEntity.getMatricula());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                dentistaEntity.setId(resultSet.getInt(1));
            }
            logger.debug("Salvando Dentista no sistema: " + dentistaEntity.toString());
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dentistaEntity;
    }

    public void delete (int id){
        Statement statement = null;
        String query = String.format("DELETE FROM dentista WHERE id = '%s'", id);

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            logger.debug("Dentista Deletado do sistema");
            this.connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DentistaEntity get(int id) {
        Connection connection = configJDBC.conectarBD();
        String query = "SELECT * FROM dentista WHERE id = ?";
        DentistaEntity dentista = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                dentista = new DentistaEntity(resultSet.getInt("id"), resultSet.getString("nome"));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return dentista;

    }

    @Override
    public DentistaEntity update(int id) {
        Connection connection = configJDBC.conectarBD();
        Statement statement = null;
        DentistaEntity dentistaEntity = new DentistaEntity();
        String query = String.format("UPDATE INTO dentista(nome,sobrenome,matricula) VALUES('%s','%s','%s')",
                dentistaEntity.getNome(), dentistaEntity.getSobrenome(), dentistaEntity.getMatricula(),
                " where id=%s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                dentistaEntity.setId(resultSet.getInt(1));
            }
            logger.debug("Salvando Dentista no sistema: " + dentistaEntity.toString());
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dentistaEntity;
    }
}
