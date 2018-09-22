package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Treatment;
@Repository
public class TreatmentData {
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;
	private MedicinesData medicinesData;
	private PhysicalTreatmentData physicalTreatmentData;
	

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public Treatment Insert(Treatment treatment) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_TreatmentInsert(?,?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.registerOutParameter(1, Types.INTEGER);

        statement.setInt(2, medicinesData.Insert(treatment.getMedicines()).getIdMedicines());
        statement.setInt(3, physicalTreatmentData.Insert(treatment.getPhysicalTreatment()).getIdPhysicalTreatment());
        statement.execute();
        treatment.setIdTreatment(statement.getInt("id_treatment"));
        statement.close();
        connection.close();
        return treatment;
    }
}
