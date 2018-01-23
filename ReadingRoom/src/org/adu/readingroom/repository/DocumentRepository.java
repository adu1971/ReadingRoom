package org.adu.readingroom.repository;

import java.util.List;

import org.adu.readingroom.model.Document;

public interface DocumentRepository {
	List<Document> getDocumentList();
	void save(Document newDocument);
	Document getById(String documentId);
	void update(Document document);
	void deleteById(String documentId);
}
