package test.music.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.music.dao.TypeInstrumentDao;
import test.music.model.InetrumentType;
import test.music.pojo.TypeInstruments;



@RestController
@RequestMapping("/api")
public class TypeInstrumentController {
	
	private TypeInstruments typeinstr;
	private InetrumentType instrtype;
	
	@Autowired
	TypeInstrumentDao typeDao;
	
	/*save */
	
	@PostMapping("/type")
	public InetrumentType createType(@Valid @RequestBody InetrumentType type){
		typeinstr = new TypeInstruments();
		typeinstr.setNameType(type.getName());
		typeDao.createType(typeinstr);
		
		type = new InetrumentType(typeinstr.getId(), typeinstr.getNameType());		
		return type;
	}
	/*find all type instruments */
	@GetMapping("/alltypes")
	public ResponseEntity<List<TypeInstruments>> findAllTypeInstruments() {

		List<TypeInstruments> listType = null;

		listType = typeDao.findAllType();

		if (listType == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(listType);
		}

	}
	@GetMapping("/type/{id}")
	public ResponseEntity<InetrumentType> oneTypeInstr(@PathVariable("id") Long id) {
		
		typeinstr = typeDao.findOneType(id);
				
		if (typeinstr == null) {
			return ResponseEntity.notFound().build();
		} else {
			instrtype = new InetrumentType(typeinstr.getId(), typeinstr.getNameType());
			return ResponseEntity.ok().body(instrtype);
		}
	}
	
	/* update employee id*/
	@PutMapping("/type/{id}")
	public ResponseEntity<TypeInstruments> updateEmployee(@PathVariable(value="id") Long id, @Valid @RequestBody InetrumentType types){
		TypeInstruments ti = typeDao.findOneType(id);
		if(ti == null){
			return ResponseEntity.notFound().build();
		}
		
		ti.setNameType(types.getName());
		
		
		
		TypeInstruments updateType = typeDao.createType(ti);
		return ResponseEntity.ok().body(updateType);
	}
	
	@DeleteMapping("/type/{id}")
	public ResponseEntity<TypeInstruments> deletetype(@PathVariable(value="id") Long id){
		TypeInstruments ti = typeDao.findOneType(id);
		if(ti == null){
			return ResponseEntity.notFound().build();
		}
		typeDao.delete(ti);
		return ResponseEntity.ok().build();
	}
	
	
}
