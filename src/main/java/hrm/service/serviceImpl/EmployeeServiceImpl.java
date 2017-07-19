package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.Employee;
import hrm.mapper.EmployeeMapper;
import hrm.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Transactional(readOnly=true)
	public Employee findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectById(id);
	}

	public void removeEmployeeWithId(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteById(id);
	}

	public void modifyEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.update(employee);
	}

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insert(employee);
	}

	/*public List<Employee> fingAllEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("employee", employee);
		List<Employee> employees = employeeMapper.selectByPage(params);
		return employees;
	}*/
	
}
