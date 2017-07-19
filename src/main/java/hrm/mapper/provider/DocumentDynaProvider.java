package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Document;

public class DocumentDynaProvider {

	//动态插入
	public String insertDocument(final Document document){
		return new SQL(){
			{
				INSERT_INTO("document");
				if(document.getTitle()!=null && !document.getTitle().equals("")){
					VALUES("title","#{title}");
				}
				if(document.getFilename()!=null && !document.getFilename().equals("")){
					VALUES("filename","#{filename}");
				}
				if(document.getDescription()!=null && !document.getDescription().equals("")){
					VALUES("description","#{description}");
				}
				if(document.getUser()!=null && document.getUser().getId()!=null){
					VALUES("userid","#{user.id}");
				}
				
			}
		}.toString();
	}
	
	//动态更新
	public String updateDocument(final Document document){
		return new SQL(){
			{
				UPDATE("document");
				if(document.getTitle()!=null && !document.getTitle().equals("")){
					SET(" title = #{title}");
				}
				if(document.getFilename()!=null && !document.getFilename().equals("")){
					SET(" filename = #{filename}");
				}
				if(document.getDescription()!=null && !document.getDescription().equals("")){
					SET(" description = #{description}");
				}
				if(document.getUser()!=null && document.getUser().getId()!=null){
					SET(" userid = #{user.id}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
	//动态分页查询
		public String selectWithParams(final Map<String, Object> params){
			String sql= new SQL(){
				{
					SELECT("*");
					FROM("document");
					if(params.get("document")!=null){
						Document document = (Document) params.get("document");
						if(document.getTitle()!=null && !document.getTitle().equals("")){
							WHERE(" title LIKE CONCAT ('%',#{document.title},'%')");
						}
					}
				}
			}.toString();
			if(params.get("pageModel")!=null){
				sql+= " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
			}
			return sql;
		}
		
		//动态查询总数量
		public String count(final Map<String, Object> params){
			return new SQL(){
				{
					SELECT("count(*)");
					FROM("document");
					if(params.get("document")!=null){
						Document document = (Document) params.get("document");
						if(document.getTitle()!=null && !document.getTitle().equals("")){
							WHERE(" title LIKE CONCAT ('%',#{document.title},'%')");
						}
					}
				}
			}.toString();
		}
	
}
