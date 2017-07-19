package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.Dept;
import hrm.mapper.DeptMapper;
import hrm.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Transactional(readOnly=true)
	public Dept findDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptMapper.selectById(id);
	}

	public void removeDeptWithId(Integer id) {
		// TODO Auto-generated method stub
		deptMapper.deleteById(id);
	}

	public void modifyDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.update(dept);
	}

	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.insert(dept);
	}

	/*public List<Dept> fingAllDept(Dept dept) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("dept", dept);
		List<Dept> depts = deptMapper.selectByPage(params);
		return depts;
	}*/
	
}
