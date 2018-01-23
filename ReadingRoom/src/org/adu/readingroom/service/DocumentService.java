package org.adu.readingroom.service;

import java.util.List;

import org.adu.readingroom.model.Document;

public interface DocumentService {
	
	List<Document> getDocumentList();
	void save(Document newDocument);
	Document getById(String documentId);
	void update(Document document);
	void deleteById(String documentId);

}
