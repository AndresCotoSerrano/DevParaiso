package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Medicines;
import retoprogramathon2018.devparaiso.domain.PhysicalTreatment;


@Repository
public class MedicinesData {
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public Medicines Insert(Medicines medicines) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_Medicines(?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, medicines.getName());
        statement.setDate(3, (Date) medicines.getdate());
        statement.setString(4, medicines.getduration());
        statement.execute();
        medicines.setduration(statement.getString("id"));
        statement.close();
        connection.close();
        return medicines;
    }
}
