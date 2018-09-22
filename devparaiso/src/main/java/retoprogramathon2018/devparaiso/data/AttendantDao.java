package retoprogramathon2018.devparaiso.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import retoprogramathon2018.devparaiso.domain.Attendant;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendantDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    public Attendant Insert(Attendant attendant) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlInsert = "{call DEV_AttendantInsert(?,?,?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(sqlInsert);

        statement.registerOutParameter(1, Types.INTEGER);


        statement.setString(2, attendant.getAttendantFullName());
        statement.setString(3, attendant.getIdNumber());
        statement.setString(4, attendant.getPhoneNumber());
        statement.setString(5, attendant.getEmail());
        statement.setString(6, attendant.getPassword());
        statement.execute();
        attendant.setIdNumber(statement.getString("user_name"));
        statement.close();
        connection.close();
        return attendant;
    }

    public List<Attendant> Login(String email, String password){
        System.out.println(email);
        String sqlSelect = "Select *from Attendant";
        return jdbcTemplate.query(sqlSelect, new LoginExtract());
    }

    public static class LoginExtract implements ResultSetExtractor<List<Attendant>>{
        @Override
        public List<Attendant> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Attendant> map = new HashMap<Integer, Attendant>();
            Attendant attendant = null;
            while(rs.next()){
                Integer idUser = rs.getInt("id_user");
                attendant = map.get(idUser);

                if(attendant == null) {

                    attendant = new Attendant();
                    attendant.setIdUser(idUser);
                    attendant.setAttendantFullName(rs.getString("attendant_fullname"));
                    attendant.setIdNumber(rs.getString("id_number"));
                    attendant.setPhoneNumber(rs.getString("phone_number"));
                    attendant.setEmail(rs.getString("email"));
                    attendant.setPassword(rs.getString("password"));

                    map.put(idUser, attendant);
                }
            }

            return new ArrayList<Attendant>(map.values());
        }
    }

    public Boolean AttendantVerify(Attendant attendant) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sqlVerify = "{call DEV_AttendantVerify(?,?)}";
        CallableStatement statement = connection.prepareCall(sqlVerify);
        statement.setString(1, attendant.getEmail());
        statement.setString(2, attendant.getPassword());
        statement.execute();

        String email = statement.getString("email");
        String password = statement.getString("password");

        if(attendant.getEmail() == email && attendant.getPassword() == password){
            System.out.println("Attendant: " + attendant.getEmail() + "\nPassword: " + attendant.getPassword());
            return true;
        }
        statement.close();
        connection.close();

        return false;
    }
}
