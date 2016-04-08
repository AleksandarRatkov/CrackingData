package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.model.Season;

@Repository
public interface SeasonRepository extends MongoRepository<Season,String>{

}
