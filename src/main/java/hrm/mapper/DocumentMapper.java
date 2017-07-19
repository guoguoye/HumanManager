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

import hrm.domain.Document;
import hrm.mapper.provider.DocumentDynaProvider;

public interface DocumentMapper {

	
	//根据Id查询
	@Select("select * from document where id = #{id}")
	Document selectById(Integer id);
	
	//根据id删除
	@Delete("delete from document where id = #{id}")
	void deleteById(Integer id);
	
	//动态插入
	@SelectProvider(method = "insertDocument", type = DocumentDynaProvider.class)
	void insert(Document document);
	
	//动态修改
	@SelectProvider(method = "updateDocument", type = DocumentDynaProvider.class)
	void update(Document document);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = DocumentDynaProvider.class)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="createDate",property="createDate",javaType=java.util.Date.class),
		@Result(column="userid",property="user",one=@One(select="hrm.mapper.UserMapper.selectById",fetchType=FetchType.EAGER))
		
	})
	List<Document> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = DocumentDynaProvider.class)
	Integer count(Map<String, Object> params);
}
