package hrm.service;

import java.util.List;

import hrm.domain.Dept;

/**
 * Dept业务功能逻辑
 * @author www
 *
 */
public interface DeptService {

	/**
	 * 根据id查找部门
	 * @param id
	 * @return Dept对象
	 *
	 */
	Dept findDeptById(Integer id);
	
	/**
	 * 根据id删除部门
	 * @param id
	 */
	void removeDeptWithId(Integer id);
	
	/**
	 * 修改部门
	 * @param dept
	 */
	void modifyDept(Dept dept);
	
	/**
	 * 添加 部门
	 * @param dept
	 */
	void addDept(Dept dept);
	
	/**
	 * 用户查询所有部门
	 * @return Dept对象的List集合
	 */
	/*List<Dept> fingAllDept(Dept dept);*/
}
