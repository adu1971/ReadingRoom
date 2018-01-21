package org.adu.cbl.service;

import java.util.List;

import org.adu.cbl.model.Document;

public interface DocumentService {
	
	List<Document> getDocumentList();
	void save(Document newDocument);

}
