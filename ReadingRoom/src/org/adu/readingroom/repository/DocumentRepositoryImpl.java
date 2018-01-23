package org.adu.readingroom.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.adu.readingroom.model.Document;
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
	public void save(Document newDocument) {
		entityManager.persist(newDocument);
	}

	@Override
	public Document getById(String documentId) {
		return entityManager.find(Document.class, Integer.parseInt(documentId));
	}

	@Override
	public void update(Document document) {
		entityManager.merge(document);		
	}

	@Override
	public void deleteById(String documentId) {
		System.out.println(getById(documentId));
		entityManager.remove(getById(documentId));
	}

}
