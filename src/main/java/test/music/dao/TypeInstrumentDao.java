package test.music.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.music.pojo.TypeInstruments;
import test.music.repository.TypeRepository;

@Service
public class TypeInstrumentDao {
	@Autowired
	TypeRepository repository;
	
	/*save type*/
	public TypeInstruments createType(TypeInstruments type){
		return repository.save(type);
	}
	
	/*all list type*/
	public List<TypeInstruments> findAllType(){
		return repository.findAll();
	}
	
	/*get one type*/
	public TypeInstruments findOneType(Long id){
		//return repository.getOne(id);
		return repository.findOneType(id);
	}
	
	/*delete type instuments*/
	public void delete(TypeInstruments type){
		repository.delete(type);
	}
}
