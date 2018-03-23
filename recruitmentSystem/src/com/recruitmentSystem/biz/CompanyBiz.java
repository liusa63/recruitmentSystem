/**
 * 
 */
package com.recruitmentSystem.biz;

import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.dao.CompanyDao;
import com.recruitmentSystem.entity.Company;
import com.recruitmentSystem.entity.News;
import com.recruitmentSystem.entity.Relation;
import com.recruitmentSystem.entity.RelationVo;
import com.recruitmentSystem.util.PageList;

/**
 * @author Administrator
 *
 */
public class CompanyBiz{
	
	
	//新闻版块
	public List<News> selectNews() throws Exception{
		List<News> list = new ArrayList<News>();
		 CompanyDao dao = new CompanyDao();
		try {
			list=dao.selectNews();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return list;
		
	}
	
	
	//查询我投递过简历或给我发送过邀请的公司
	 public List<RelationVo> selectComAboutMe(int rid) throws Exception{
		 
		 List<RelationVo> list = new ArrayList<RelationVo>();
		 CompanyDao dao = new CompanyDao();
			try {
				list=dao.selectComAboutMe(rid);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
		 return list;
	 }
	
	
	
	//模糊查询rpost
	public  List<RelationVo>  selectAboutType(int uid,String rpost,String search) throws Exception{
		List<RelationVo>  list=null;
		CompanyDao dao = new CompanyDao();
		try {
			list=dao.selectAboutType(uid, rpost,search);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return list;
	}
	
	//根据pid查到所有rid
		public List<Integer> selectAllRidByUid(int pid) throws Exception{
			List<Integer> list=null;
			CompanyDao dao = new CompanyDao();
			try {
				list=dao.selectAllRidByUid(pid);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			
			return list;
		}
	
	
	//查询企业的所有信息
	public List<Company> selectComList() throws Exception{
		List<Company> list=new ArrayList<Company>();
		CompanyDao dao = new CompanyDao();
		try {
			list=dao.selectComList();
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return list;
	}
	
	//根据uid获取cid
	public int selectCidByUid(int uid) throws Exception{
		int cid=0;
		CompanyDao dao=new CompanyDao();
		try {
			cid=dao.selectCidByUid(uid);
		} catch (Exception e) {
			throw e;
		}
	  return cid;
		
	}
	
	//修改企业的基本信息
	public void updateCompanyInfo(int uid, String cname, String caddress,String cintroduce, String cphone) throws Exception {
		CompanyDao dao=new CompanyDao();
		try {
			dao.updateCompanyInfo(uid, cname, caddress, cintroduce, cphone);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
	}
	//添加公司信息
	public void addCompany(int uid, String cname, String caddress,
			String cintroduce, String cphone) throws Exception {
		CompanyDao dao=new CompanyDao();
		try {
			dao.addCompany(uid, cname, caddress, cintroduce, cphone);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}

	}

	//按薪水高低搜索企业的招聘信息
	public List<RelationVo> selectCompanyBySalary(int uid) throws Exception {
		List<RelationVo> list = new ArrayList<RelationVo>();
		CompanyDao dao=new CompanyDao();
		try {
			list=dao.selectCompanyBySalary(uid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return list;
	}
	
   //根据发布时间新旧排列企业招聘信息
	public List<RelationVo> selectCompanyByTime(int uid) throws Exception {
			List<RelationVo> list = new ArrayList<RelationVo>();
			CompanyDao dao=new CompanyDao();
			try {
				list=dao.selectCompanyByTime(uid);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			return list;
		}
		
	//分页查询公司发布的招聘信息
	public PageList<RelationVo> pageListRelation(PageList<RelationVo> page, int max,int uid) throws Exception {
			CompanyDao dao = new CompanyDao();
			try {
				//获取到分页显示的简历列表
				//获取当前页
				int beginPage=(page.getCurrentPage()-1)*max;
				List<RelationVo> list=dao.pageGetCompanyInfo(beginPage, max, uid);
				page.setList(list);
				//获取简历总条数
				int countResume=dao.selectCountRelation();
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

    //根据uid查询企业信息
	public Company selectCompanyInfoByUid(int uid) throws Exception {
			Company com = null;
			CompanyDao dao = new CompanyDao();
			try {
				com = dao.selectCompanyInfoByUid(uid);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			return com;
			
		}

	//根据uid查询到公司发布的所有岗位
	public List<Relation> selectCompostByUid(int uid) throws Exception {
			List<Relation>  list=null;
			CompanyDao dao = new CompanyDao();
			try {
				int cid=dao.selectCidByUid(uid);
				list=dao.comPostList(cid);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			
			return list;
		
		}

	//根据pid删除指定岗位信息
	public void delPostByPid(int pid) throws Exception {
		CompanyDao dao = new CompanyDao();
		try {
			dao.delPostByCidAndRpost(pid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
	}

	//根据cid添加岗位
	public void addPost(int cid, String rpost, String rask,double rsalary, String rtimes) throws Exception {
			CompanyDao dao =new CompanyDao();
			try {
				dao.addPost(cid, rpost, rask, rsalary, rtimes);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
		}
	
	// 根据pid和获取职位信息
	public Relation selectPostInfoByPid(int pid) throws Exception{
		Relation relation=null;
		CompanyDao dao=new CompanyDao();
		try {
			relation=dao.selectPostInfoByCidAndRpost(pid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return relation;
	}

	//根据cid查询公司信息
	public Company selectCompanyInfoByCid(int cid) throws Exception {
		Company com= null;
		CompanyDao dao = new CompanyDao();
		try {
			com=dao.selectCompanyInfoByCid(cid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return com;
	}

}
