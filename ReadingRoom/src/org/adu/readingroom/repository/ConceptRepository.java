package org.adu.readingroom.repository;

import java.util.List;

import org.adu.readingroom.model.Concept;

public interface ConceptRepository {

	List<Concept> getConceptList();
	Concept getById(String conceptId);
	void save(Concept concept);
	void update(Concept concept);
	void deleteById(String conceptId);
}
