package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Kids;
import retoprogramathon2018.devparaiso.domain.PhysicalTreatment;

@Repository
public class PhysicalTreatmentData {
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public PhysicalTreatment Insert(PhysicalTreatment physicalTreatment) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_PhysicalTreatmentDataInsert(?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, physicalTreatment.getdescription());
        statement.execute();
        physicalTreatment.setdescription(statement.getString("id_physical_treatment"));
        statement.close();
        connection.close();
        return physicalTreatment;
    }
}
