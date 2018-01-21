package org.adu.cbl.service;

import java.util.List;

import org.adu.cbl.model.Document;
import org.adu.cbl.repository.DocumentRepository;
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


}
