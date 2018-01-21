package org.adu.cbl.repository;

import java.util.List;

import org.adu.cbl.model.Concept;

public interface ConceptRepository {

	List<Concept> getConcepts();
	Concept getById(String conceptId);
	void save(Concept concept);
	void update(Concept concept);
	void deleteById(String conceptId);
}
