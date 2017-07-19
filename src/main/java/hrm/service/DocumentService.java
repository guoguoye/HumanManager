package hrm.service;

import java.util.List;

import hrm.domain.Document;

/**
 * Document业务功能逻辑
 * @author www
 *
 */
public interface DocumentService {

	/**
	 * 根据id查找文档
	 * @param id
	 * @return Document对象
	 *
	 */
	Document findDocumentById(Integer id);
	
	/**
	 * 根据id删除文档
	 * @param id
	 */
	void removeDocumentWithId(Integer id);
	
	/**
	 * 修改文档
	 * @param document
	 */
	void modifyDocument(Document document);
	
	/**
	 * 添加 文档
	 * @param document
	 */
	void addDocument(Document document);
	
	/**
	 * 用户查询所有文档
	 * @return Document对象的List集合
	 */
	/*List<Document> fingAllDocument(Document document);*/
}
