package hrm.service;

import java.util.List;

import hrm.domain.Notice;

/**
 * Notice业务功能逻辑
 * @author www
 *
 */
public interface NoticeService {

	/**
	 * 根据id查找公告
	 * @param id
	 * @return Notice对象
	 *
	 */
	Notice findNoticeById(Integer id);
	
	/**
	 * 根据id删除公告
	 * @param id
	 */
	void removeNoticeWithId(Integer id);
	
	/**
	 * 修改公告
	 * @param notice
	 */
	void modifyNotice(Notice notice);
	
	/**
	 * 添加 公告
	 * @param notice
	 */
	void addNotice(Notice notice);
	
	/**
	 * 用户查询所有公告
	 * @return Notice对象的List集合
	 */
	/*List<Notice> fingAllNotice(Notice notice);*/
}
