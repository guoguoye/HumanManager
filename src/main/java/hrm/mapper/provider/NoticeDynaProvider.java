package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Notice;

public class NoticeDynaProvider {

	//动态插入
	public String insertNotice(final Notice notice){
		return new SQL(){
			{
				INSERT_INTO("notice");
				if(notice.getTitle()!=null && !notice.getTitle().equals("")){
					VALUES("title","#{title}");
				}
				if(notice.getContent()!=null && !notice.getContent().equals("")){
					VALUES("content","#{content}");
				}
				if(notice.getUser()!=null && notice.getUser().getId()!=null){
					VALUES("userid","#{user.id}");
				}
				
			}
		}.toString();
	}
	
	//动态更新
	public String updateNotice(final Notice notice){
		return new SQL(){
			{
				UPDATE("notice");
				if(notice.getTitle()!=null && !notice.getTitle().equals("")){
					SET(" title = #{title}");
				}
				if(notice.getContent()!=null && !notice.getContent().equals("")){
					SET(" content = #{content}");
				}
				if(notice.getUser()!=null && notice.getUser().getId()!=null){
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
					FROM("notice");
					if(params.get("notice")!=null){
						Notice notice = (Notice) params.get("notice");
						if(notice.getTitle()!=null && !notice.getTitle().equals("")){
							WHERE(" title LIKE CONCAT ('%',#{notice.title},'%')");
						}
						if(notice.getContent()!=null && !notice.getContent().equals("")){
							WHERE(" content LIKE CONCAT ('%',#{notice.content},'%')");
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
					FROM("notice");
					if(params.get("notice")!=null){
						Notice notice = (Notice) params.get("notice");
						if(notice.getTitle()!=null && !notice.getTitle().equals("")){
							WHERE(" title LIKE CONCAT ('%',#{notice.title},'%')");
						}
						if(notice.getContent()!=null && !notice.getContent().equals("")){
							WHERE(" content LIKE CONCAT ('%',#{notice.content},'%')");
						}
					}
				}
			}.toString();
		}
	
}
