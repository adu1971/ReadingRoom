package org.adu.readingroom.service;

import java.util.List;

import org.adu.readingroom.model.Document;
import org.adu.readingroom.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentRepository documentRepository;

	@Override
	public List<Document> getDocumentList() {
		return documentRepository.getDocumentList();
	};
	
	@Transactional(readOnly=false)
	@Override
	public void save(Document newDocument) {
		documentRepository.save(newDocument);
	}

	@Override
	public Document getById(String documentId) {
		return documentRepository.getById(documentId);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Document document) {
		documentRepository.update(document);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteById(String documentId) {
		documentRepository.deleteById(documentId);
	}


}
