package com.digitalhouse.clinicaodontologicag6.dao.impl;

import com.digitalhouse.clinicaodontologicag6.dao.ConfigJDBC;
import com.digitalhouse.clinicaodontologicag6.dao.IDao;
import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import org.apache.log4j.Logger;

import java.sql.*;

public class PacienteDaoImpl implements IDao<PacienteEntity> {
    private ConfigJDBC configJDBC;
    final static Logger logger = Logger.getLogger(PacienteDaoImpl.class);
    private Connection connection = configJDBC.conectarBD();

    public PacienteDaoImpl(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public PacienteEntity create(PacienteEntity pacienteEntity) {
        Connection connection = configJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("INSERT INTO paciente(nome,sobrenome,documentoIdentificacao) VALUES('%s','%s','%s')",
                pacienteEntity.getNome(), pacienteEntity.getSobrenome(), pacienteEntity.getDocumentoIdentificacao());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pacienteEntity.setId(resultSet.getInt(1));
            }
            logger.debug("Salvando Paciente no sistema: " + pacienteEntity.toString());
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacienteEntity;
    }

    public void delete(int id) {
        Statement statement = null;
        String query = String.format("DELETE FROM paciente WHERE id = '%s'", id);

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            logger.debug("Paciente Deletado do sistema");
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PacienteEntity get(int id) {
        Connection connection = configJDBC.conectarBD();
        String query = "SELECT * FROM paciente WHERE id = ?";
        PacienteEntity paciente = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                paciente = new PacienteEntity(resultSet.getInt("id"), resultSet.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return paciente;

    }

    @Override
    public PacienteEntity update(int id) {
        Connection connection = configJDBC.conectarBD();
        Statement statement = null;
        PacienteEntity pacienteEntity = new PacienteEntity();
        String query = String.format("UPDATE INTO paciente(nome,sobrenome,documentoIdentificacao) VALUES('%s','%s','%s')",
                pacienteEntity.getNome(), pacienteEntity.getSobrenome(), pacienteEntity.getDocumentoIdentificacao(),
                " where id=%s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pacienteEntity.setId(resultSet.getInt(1));
            }
            logger.debug("Salvando Paciente no sistema: " + pacienteEntity.toString());
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacienteEntity;
    }
}