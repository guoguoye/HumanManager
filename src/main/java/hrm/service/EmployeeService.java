package hrm.service;

import java.util.List;

import hrm.domain.Employee;

/**
 * Employee业务功能逻辑
 * @author www
 *
 */
public interface EmployeeService {

	/**
	 * 根据id查找员工
	 * @param id
	 * @return Employee对象
	 *
	 */
	Employee findEmployeeById(Integer id);
	
	/**
	 * 根据id删除员工
	 * @param id
	 */
	void removeEmployeeWithId(Integer id);
	
	/**
	 * 修改员工
	 * @param employee
	 */
	void modifyEmployee(Employee employee);
	
	/**
	 * 添加 员工
	 * @param employee
	 */
	void addEmployee(Employee employee);
	
	/**
	 * 用户查询所有员工
	 * @return Employee对象的List集合
	 */
	/*List<Employee> fingAllEmployee(Employee employee);*/
}
