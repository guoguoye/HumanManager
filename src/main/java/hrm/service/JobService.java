package hrm.service;

import java.util.List;

import hrm.domain.Job;

/**
 * Job业务功能逻辑
 * @author www
 *
 */
public interface JobService {

	/**
	 * 根据id查找工作
	 * @param id
	 * @return Job对象
	 *
	 */
	Job findJobById(Integer id);
	
	/**
	 * 根据id删除工作
	 * @param id
	 */
	void removeJobWithId(Integer id);
	
	/**
	 * 修改工作
	 * @param job
	 */
	void modifyJob(Job job);
	
	/**
	 * 添加 工作
	 * @param job
	 */
	void addJob(Job job);
	
	/**
	 * 用户查询所有工作
	 * @return Job对象的List集合
	 */
	/*List<Job> fingAllJob(Job job);*/
}
