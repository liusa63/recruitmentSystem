/**
 * 
 */
package com.recruitmentSystem.biz;

import java.util.List;




import com.recruitmentSystem.dao.ResumeDao;
import com.recruitmentSystem.entity.ResumeVo;
import com.recruitmentSystem.util.PageList;

/**
 * @author Administrator
 *
 */
public class ResumeBiz {
	//添加简历
	public void addResume( int uid, String rname, String rpic,
			String rage, String rsex, String rphone, String remail,
			String reducation,String rwant,String rup) throws Exception{
		ResumeDao dao=new ResumeDao();
		try {
			dao.addResume( uid, rname, rpic, rage, rsex, rphone, remail, reducation,rwant,rup);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}

	
	public PageList<ResumeVo> pageListResume(PageList<ResumeVo> page, int max,int uid) throws Exception {
          ResumeDao dao = new ResumeDao();
		try {
			//获取到分页显示的简历列表
			//获取当前页
			int beginPage=(page.getCurrentPage()-1)*max;
			List<ResumeVo> list=dao.pageGetResumeInfo(beginPage, max,uid);
			page.setList(list);
			//获取简历总条数
			int countResume=dao.selectCountResume();
			page.setTotalNum(countResume);
			//计算总页数
			int countPage = countResume%max==0?countResume/max:countResume/max+1;
			page.setCountPage(countPage);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return page;
	}
	

}
