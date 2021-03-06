package org.adu.readingroom.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.adu.readingroom.model.Concept;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ConceptRepositoryImpl implements ConceptRepository {
	
	@PersistenceContext
	EntityManager entityManager;
		
	@Override
	public List<Concept> getConceptList() {
		return entityManager.createQuery("from Concept", Concept.class).getResultList();
	}

	@Override
	public Concept getById(String conceptId) {
		return entityManager.find(Concept.class, Integer.parseInt(conceptId));
	}

	@Override
	public void save(Concept newConcept) {
		entityManager.persist(newConcept);
	}

	@Override
	public void update(Concept concept) {
		entityManager.merge(concept);
	}

	@Override
	public void deleteById(String conceptId) {
		entityManager.remove(getById(conceptId));
	}


}
