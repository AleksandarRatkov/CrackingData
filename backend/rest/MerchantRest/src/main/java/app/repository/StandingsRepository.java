package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.model.Standings;

@Repository
public interface StandingsRepository extends MongoRepository<Standings, String> {

	public Standings findStandingsByName(String name);
}
