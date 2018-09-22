package retoprogramathon2018.devparaiso.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retoprogramathon2018.devparaiso.data.KidsData;
import retoprogramathon2018.devparaiso.domain.Kids;

@RestController
@RequestMapping("api/kids")
public class KidsController {
	private KidsData kidsData;

    @Autowired
    public void setKidsData(KidsData kidsData) {
        this.kidsData = kidsData;
    }

    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Kids> insertKids(@RequestBody final Kids kids){
    	Kids kidsCreated = null;
        try{
        	kidsCreated = kidsData.Insert(kids);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new ResponseEntity<Kids>(kidsCreated, HttpStatus.CREATED);
    }
}
