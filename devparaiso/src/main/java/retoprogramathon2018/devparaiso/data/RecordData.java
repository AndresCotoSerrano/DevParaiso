package retoprogramathon2018.devparaiso.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import retoprogramathon2018.devparaiso.domain.Kids;
import retoprogramathon2018.devparaiso.domain.Record;

@Repository
public class RecordData {

	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public Record Insert(Record record) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_KidsRecord(?,?,?,?,?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.setString(1, kids.getidNumber());
        statement.setString(2, kids.getname());
        statement.setInt(3, kids.getage());
        statement.setString(4, kids.getgenre());
        statement.setString(5, kids.getethnic());
        statement.setString(6, kids.getkin());
        statement.setString(7, kids.getAttendant().getIdNumber());
        statement.setInt(7, kids.getRecord().getIdRecord());
        statement.execute();
        kids.setidNumber(statement.getString("id_number"));
        statement.close();
        connection.close();
        return kids;
    }
	
}
