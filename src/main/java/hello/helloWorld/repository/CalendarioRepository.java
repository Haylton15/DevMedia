package hello.helloWorld.repository;

import hello.helloWorld.bean.Calendario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Haylton
 */

@Repository
public interface CalendarioRepository extends CrudRepository<Calendario, Integer>{
    
}
