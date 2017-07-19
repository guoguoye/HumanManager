package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.Document;
import hrm.mapper.DocumentMapper;
import hrm.service.DocumentService;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	private DocumentMapper documentMapper;
	
	@Transactional(readOnly=true)
	public Document findDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return documentMapper.selectById(id);
	}

	public void removeDocumentWithId(Integer id) {
		// TODO Auto-generated method stub
		documentMapper.deleteById(id);
	}

	public void modifyDocument(Document document) {
		// TODO Auto-generated method stub
		documentMapper.update(document);
	}

	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		documentMapper.insert(document);
	}

	/*public List<Document> fingAllDocument(Document document) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("document", document);
		List<Document> documents = documentMapper.selectByPage(params);
		return documents;
	}*/
	
}
