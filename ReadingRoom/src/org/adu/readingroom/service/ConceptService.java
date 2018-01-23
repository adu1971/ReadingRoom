package org.adu.readingroom.service;

import java.util.List;

import org.adu.readingroom.model.Concept;

public interface ConceptService {
	
	public List<Concept> getConceptList();
	public Concept getById(String conceptId);
	public void save(Concept concept);
	public void update(Concept concept);
	public void deleteById(String conceptId);

}
