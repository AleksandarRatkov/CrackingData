package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.model.CrackedData;

@Repository
public interface CrackedDataRepository extends MongoRepository<CrackedData, String>{

}
