package test.music.controller;

import java.util.ArrayList;
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

import test.music.dao.MusicInstrumenDao;
import test.music.dao.TypeInstrumentDao;

import test.music.model.InfoInstruments;
import test.music.model.MusicInstrument;
import test.music.pojo.MusicalInstruments;
import test.music.pojo.TypeInstruments;

@RestController
@RequestMapping("/api")
public class MusicInstrumentController {
	
	private InfoInstruments infoInstrument;
	
	private MusicalInstruments musicInstrument;
	
	private TypeInstruments typeInstr;
	
	@Autowired
	TypeInstrumentDao typeDao;
	
	@Autowired
	MusicInstrumenDao instrumenDao;
	
	
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	
	/*save */
	
	@PostMapping("/music")
	public  InfoInstruments createInstrument(@Valid @RequestBody MusicInstrument mus){
		
		typeInstr = typeDao.findOneType(mus.getTypeId());
		
		musicInstrument = new MusicalInstruments();
		musicInstrument.setNameInstruments(mus.getName());
		musicInstrument.setPrice(mus.getPrice());
		musicInstrument.setReleaseYear(mus.getYear());
		musicInstrument.setTypeInstr(typeInstr);		
		instrumenDao.createInstuments(musicInstrument);
		
		
		
		infoInstrument = new InfoInstruments(musicInstrument.getId(), musicInstrument.getNameInstruments(), typeInstr.getNameType(), musicInstrument.getPrice(), musicInstrument.getReleaseYear());
		
		return infoInstrument;
	}
	
	@GetMapping("/allmusic")
	public ResponseEntity<List<InfoInstruments>> findAllMusicInstruments() {

		List<MusicalInstruments> instruments = null;

		instruments = instrumenDao.findAllInstruments();
		List<InfoInstruments> listInfo = new ArrayList<InfoInstruments>();
		
		
		if (instruments == null) {
			return ResponseEntity.notFound().build();
		} else {
		
			for (MusicalInstruments mi : instruments) {
				typeInstr = typeDao.findOneType(mi.getTypeInstr().getId());
				infoInstrument = new InfoInstruments(mi.getId(), mi.getNameInstruments(), typeInstr.getNameType(), mi.getPrice(), mi.getReleaseYear());
				listInfo.add(infoInstrument);
			}
			
			
			return ResponseEntity.ok().body(listInfo);
		}

	}
	
	@GetMapping("/music/{id}")
	public ResponseEntity<InfoInstruments> oneInfoInstr(@PathVariable("id") Long id) {
		
		musicInstrument = instrumenDao.findOneInstrument(id);
				
		if (musicInstrument == null) {
			return ResponseEntity.notFound().build();
		} else {
			typeInstr = typeDao.findOneType(musicInstrument.getTypeInstr().getId());
			infoInstrument = new InfoInstruments(musicInstrument.getId(), musicInstrument.getNameInstruments(), typeInstr.getNameType(), musicInstrument.getPrice(), musicInstrument.getReleaseYear());
			return ResponseEntity.ok().body(infoInstrument);
		}
	}
	
	/* update employee id*/
	@PutMapping("/music/{id}")
	public ResponseEntity<MusicalInstruments> updateEmployee(@PathVariable(value="id") Long id, @Valid @RequestBody MusicInstrument mus){
		
		
		MusicalInstruments mi = instrumenDao.findOneInstrument(id);
		
		if(mi == null){
			return ResponseEntity.notFound().build();
		}
		
		typeInstr = typeDao.findOneType(mus.getTypeId());
		
		mi.setNameInstruments(mus.getName());
		mi.setPrice(mus.getPrice());
		mi.setReleaseYear(mus.getYear());
		mi.setTypeInstr(typeInstr);
		
		MusicalInstruments updateInstrument = instrumenDao.createInstuments(mi);
		return ResponseEntity.ok().body(updateInstrument);
	}
	
	
	@DeleteMapping("/music/{id}")
	public ResponseEntity<MusicalInstruments> deletetype(@PathVariable(value="id") Long id){
		MusicalInstruments mi = instrumenDao.findOneInstrument(id);
		if(mi == null){
			return ResponseEntity.notFound().build();
		} else {
			instrumenDao.deleteInstrument(mi.getId());
			return ResponseEntity.ok().build();
		}
	}
	
}
