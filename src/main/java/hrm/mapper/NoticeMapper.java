package hrm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import hrm.domain.Notice;
import hrm.mapper.provider.NoticeDynaProvider;

public interface NoticeMapper {

	
	//根据Id查询部门
	@Select("select * from notice where id = #{id}")
	Notice selectById(Integer id);
	
	//根据id删除部门
	@Delete("delete from notice where id = #{id}")
	void deleteById(Integer id);
	
	//动态插入部门
	@SelectProvider(method = "insertNotice", type = NoticeDynaProvider.class)
	void insert(Notice notice);
	
	//动态修改部门
	@SelectProvider(method = "updateNotice", type = NoticeDynaProvider.class)
	void update(Notice notice);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = NoticeDynaProvider.class)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="createDate",property="createDate",javaType=java.util.Date.class),
		@Result(column="userid",property="user",one=@One(select="hrm.mapper.UserMapper.selectById",fetchType=FetchType.EAGER))
		
	})
	List<Notice> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = NoticeDynaProvider.class)
	Integer count(Map<String, Object> params);
}
