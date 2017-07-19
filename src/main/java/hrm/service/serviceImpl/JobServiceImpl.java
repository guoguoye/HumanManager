package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.Job;
import hrm.mapper.JobMapper;
import hrm.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService{

	@Autowired
	private JobMapper jobMapper;
	
	@Transactional(readOnly=true)
	public Job findJobById(Integer id) {
		// TODO Auto-generated method stub
		return jobMapper.selectById(id);
	}

	public void removeJobWithId(Integer id) {
		// TODO Auto-generated method stub
		jobMapper.deleteById(id);
	}

	public void modifyJob(Job job) {
		// TODO Auto-generated method stub
		jobMapper.update(job);
	}

	public void addJob(Job job) {
		// TODO Auto-generated method stub
		jobMapper.insert(job);
	}

	/*public List<Job> fingAllJob(Job job) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("job", job);
		List<Job> jobs = jobMapper.selectByPage(params);
		return jobs;
	}*/
	
}
