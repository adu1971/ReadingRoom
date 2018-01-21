package org.adu.cbl.repository;

import java.util.List;

import org.adu.cbl.model.Document;

public interface DocumentRepository {
	List<Document> getDocumentList();
	void save(Document newDocument);
}
