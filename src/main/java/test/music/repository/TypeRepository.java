package test.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import test.music.pojo.TypeInstruments;

@Repository
public interface TypeRepository extends JpaRepository<TypeInstruments, Long>{

		
		@Query("from TypeInstruments t where t.id = :typeid")
		public TypeInstruments findOneType(@Param("typeid") Long typeid);
}
