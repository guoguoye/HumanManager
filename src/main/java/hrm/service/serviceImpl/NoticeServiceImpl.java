package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.Notice;
import hrm.mapper.NoticeMapper;
import hrm.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Transactional(readOnly=true)
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeMapper.selectById(id);
	}

	public void removeNoticeWithId(Integer id) {
		// TODO Auto-generated method stub
		noticeMapper.deleteById(id);
	}

	public void modifyNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.update(notice);
	}

	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.insert(notice);
	}

	/*public List<Notice> fingAllNotice(Notice notice) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("notice", notice);
		List<Notice> notices = noticeMapper.selectByPage(params);
		return notices;
	}*/
	
}
