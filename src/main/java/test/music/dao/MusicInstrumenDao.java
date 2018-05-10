package test.music.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.music.pojo.MusicalInstruments;
import test.music.repository.MusicalInstrumentsRepository;

@Service
public class MusicInstrumenDao {

	@Autowired
	MusicalInstrumentsRepository instrumentsRepository;
	
	/*save instrument*/
	public MusicalInstruments createInstuments(MusicalInstruments instrumnet){
		return instrumentsRepository.save(instrumnet);
	}
	
	/*all list instrument*/
	public List<MusicalInstruments> findAllInstruments(){
		return instrumentsRepository.findAll();
	}
	
	/*get one instrument*/
	public MusicalInstruments findOneInstrument(Long id){
		//return instrumentsRepository.getOne(id);
		return instrumentsRepository.findOneInstrument(id);
	}
	
	/*delete  instument*/
	public void delete(MusicalInstruments instrument){
		instrumentsRepository.delete(instrument);
		
	}
	
	public void deleteInstrument(Long id){
		instrumentsRepository.deletInstrument(id);
	}
}
