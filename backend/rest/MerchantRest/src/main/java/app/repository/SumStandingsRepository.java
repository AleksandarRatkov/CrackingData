package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.SumStandings;

public interface SumStandingsRepository extends MongoRepository<SumStandings, String> {

	public SumStandings findSumStandingsByName(String name);

}
