package org.adu.readingroom.service;

import java.util.List;

import org.adu.readingroom.model.Concept;
import org.adu.readingroom.repository.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class ConceptServiceImpl implements ConceptService {

	@Autowired
	ConceptRepository conceptRepository;
	
	@Override
	public List<Concept> getConceptList() {
		return conceptRepository.getConceptList();
	}
	
	@Override
	public Concept getById(String conceptId) {
		return conceptRepository.getById(conceptId);
	}

	@Override
	@Transactional(readOnly=false)
	public void save(Concept concept) {
		conceptRepository.save(concept);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Concept concept) {
		conceptRepository.update(concept);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteById(String conceptId) {
		conceptRepository.deleteById(conceptId);		
	}


}
