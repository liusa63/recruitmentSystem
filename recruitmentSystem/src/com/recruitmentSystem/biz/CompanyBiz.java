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
	
	
	//���Ű��
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
	
	
	//��ѯ��Ͷ�ݹ���������ҷ��͹�����Ĺ�˾
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
	
	
	
	//ģ����ѯrpost
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
	
	//����pid�鵽����rid
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
	
	
	//��ѯ��ҵ��������Ϣ
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
	
	//����uid��ȡcid
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
	
	//�޸���ҵ�Ļ�����Ϣ
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
	//��ӹ�˾��Ϣ
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

	//��нˮ�ߵ�������ҵ����Ƹ��Ϣ
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
	
   //���ݷ���ʱ���¾�������ҵ��Ƹ��Ϣ
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
		
	//��ҳ��ѯ��˾��������Ƹ��Ϣ
	public PageList<RelationVo> pageListRelation(PageList<RelationVo> page, int max,int uid) throws Exception {
			CompanyDao dao = new CompanyDao();
			try {
				//��ȡ����ҳ��ʾ�ļ����б�
				//��ȡ��ǰҳ
				int beginPage=(page.getCurrentPage()-1)*max;
				List<RelationVo> list=dao.pageGetCompanyInfo(beginPage, max, uid);
				page.setList(list);
				//��ȡ����������
				int countResume=dao.selectCountRelation();
				page.setTotalNum(countResume);
				//������ҳ��
				int countPage = countResume%max==0?countResume/max:countResume/max+1;
				page.setCountPage(countPage);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			return page;
		}

    //����uid��ѯ��ҵ��Ϣ
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

	//����uid��ѯ����˾���������и�λ
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

	//����pidɾ��ָ����λ��Ϣ
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

	//����cid��Ӹ�λ
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
	
	// ����pid�ͻ�ȡְλ��Ϣ
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

	//����cid��ѯ��˾��Ϣ
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
