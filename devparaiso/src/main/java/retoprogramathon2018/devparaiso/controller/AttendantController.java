package retoprogramathon2018.devparaiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retoprogramathon2018.devparaiso.data.AttendantDao;
import retoprogramathon2018.devparaiso.domain.Attendant;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AttendantController {
    private AttendantDao attendantDao;

    @Autowired
    public void setAttendantDao(AttendantDao attendantDao) {
        this.attendantDao = attendantDao;
    }

    @PutMapping(value = "/login/{email}/{password}")
    public ResponseEntity<Attendant> loginAttendant(@PathVariable("email") final String email, @PathVariable("password") final String password){
        Attendant attendantUser = new Attendant();
        attendantUser.setEmail(email);
        attendantUser.setPassword(password);
        try{
            attendantDao.AttendantVerify(attendantUser);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attendant> insertAttendant(@RequestBody final Attendant attendant){
        Attendant attendantCreated = null;
        try{
            attendantCreated = attendantDao.Insert(attendant);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new ResponseEntity<Attendant>(attendantCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{Email}/{Password}")
    public ResponseEntity<List<Attendant>> Validate(@PathVariable("Email")final String emailUser, @PathVariable("Password")final String passwordUser){
        System.out.println(emailUser);
        List<Attendant> result = attendantDao.Login(emailUser, passwordUser);
        return new ResponseEntity<List<Attendant>>(result, HttpStatus.OK);
    }
}

