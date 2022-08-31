package com.digitalhouse.clinicaodontologicag6.dao.impl;

import com.digitalhouse.clinicaodontologicag6.dao.ConfigJDBC;
import com.digitalhouse.clinicaodontologicag6.dao.IDao;
import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DentistaDaoImpl implements IDao<DentistaEntity> {
    private ConfigJDBC configJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);
    private Connection connection = configJDBC.conectarBD();

    public DentistaDaoImpl(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }
    @Override
    public DentistaEntity create(DentistaEntity dentistaEntity) {
        Connection connection = configJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("INSERT INTO dentistaEntity(nome,sobrenome,matricula) VALUES('%s','%s','%s','%s')",
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
        String query = String.format("DELETE FROM dentistaEntity WHERE id = '%s'"), id);

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
}
