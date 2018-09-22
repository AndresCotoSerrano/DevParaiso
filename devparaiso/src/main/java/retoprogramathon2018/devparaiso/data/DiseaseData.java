package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Disease;

@Repository
public class DiseaseData {
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	

	 public  Disease Insert( Disease disease) throws SQLException {
	        Connection connection = dataSource.getConnection();
	        String sqlInsert = "{call DEV_ DiseaseInsert(?,?)}";

	        CallableStatement statement = connection.prepareCall(sqlInsert);

	        statement.registerOutParameter(1, Types.INTEGER);
	        statement.setString(2, disease.getDescriptionDisease());
	        statement.execute();
	        disease.setIdDisease(statement.getInt("id_disease"));
	        statement.close();
	        connection.close();
	        return disease;
	    }
}
