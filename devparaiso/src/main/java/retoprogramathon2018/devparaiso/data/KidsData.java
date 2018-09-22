package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Kids;

@Repository
public class KidsData {
	
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;
	private RecordData recordData; 

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public Kids Insert(Kids kids) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_KidsInsert(?,?,?,?,?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.setString(1, kids.getidNumber());
        statement.setString(2, kids.getname());
        statement.setInt(3, kids.getage());
        statement.setString(4, kids.getgenre());
        statement.setString(5, kids.getethnic());
        statement.setString(6, kids.getkin());
        statement.setString(7, kids.getAttendant().getIdNumber());
        statement.setInt(8, recordData.Insert(kids.getRecord()).getIdRecord());
        statement.execute();
        kids.setidNumber(statement.getString("id_number"));
        statement.close();
        connection.close();
        return kids;
    }
	
	
}
