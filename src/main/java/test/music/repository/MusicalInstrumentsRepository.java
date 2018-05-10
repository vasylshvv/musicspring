package test.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.music.pojo.MusicalInstruments;


@Repository
public interface MusicalInstrumentsRepository extends JpaRepository<MusicalInstruments, Long>{
	@Query("from MusicalInstruments m where m.id = :musid")
	public MusicalInstruments findOneInstrument(@Param("musid") Long musid);
	
	@Modifying
    @Transactional
    @Query("delete from MusicalInstruments m where m.id = ?1")
	public  void deletInstrument(Long id);
}
