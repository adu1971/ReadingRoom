package org.adu.cbl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.adu.cbl.model.Document;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DocumentRepositoryImpl implements DocumentRepository {
	
	@PersistenceContext
	EntityManager entityManager;
		
	@Override
	public List<Document> getDocumentList() {
		return entityManager.createQuery("from Document", Document.class).getResultList();
	}

	@Override
	public void save(Document document) {
		entityManager.persist(document);
	}

}
