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
import retoprogramathon2018.devparaiso.domain.Record;

@Repository
public class RecordData {

	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;
	private TreatmentData treatmentData;
	private DiseaseData diseaseData;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	public Record Insert(Record record) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_RecordInsert(?,?,?)}";

    
        CallableStatement statement = connection.prepareCall(sqlInsert);
        
        statement.registerOutParameter(1, Types.INTEGER);
        statement.setInt(2, treatmentData.Insert(record.getTreatment()).getIdTreatment());
        statement.setInt(3, diseaseData.Insert(record.getDisease()).getIdDisease());
        statement.execute();
        record.setIdRecord(statement.getInt("id_record"));
        statement.close();
        connection.close();
        return record;
    }
	
}
