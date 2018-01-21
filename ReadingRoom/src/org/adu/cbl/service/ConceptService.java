package org.adu.cbl.service;

import java.util.List;

import org.adu.cbl.model.Concept;

public interface ConceptService {
	
	public List<Concept> getConcepts();
	public Concept getById(String conceptId);
	public void save(Concept concept);
	public void update(Concept concept);
	public void deleteById(String conceptId);

}
