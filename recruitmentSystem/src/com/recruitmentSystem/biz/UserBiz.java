/**
 * 
 */
package com.recruitmentSystem.biz;

import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.dao.UserDao;
import com.recruitmentSystem.entity.Delivery;
import com.recruitmentSystem.entity.Experience;
import com.recruitmentSystem.entity.Resume;
import com.recruitmentSystem.entity.User;

public class UserBiz {
	
	//�����Ա����
	public void feedBack(int uid, String fname,String femail,String fmsg) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.feedBack(uid, fname, femail, fmsg);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}
	
	
	
	//����rid��ѯdelivery����
	public List<Delivery> findDelivery(int rid) throws Exception{
		UserDao dao = new UserDao();
		List<Delivery> list = null;
		try {
			list=dao.findDelivery(rid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return list;
		
	}
	
	//����Ͷ��
	public void  addDelivery(int pid,int rid,int dstatus) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.addDelivery(pid, rid, dstatus);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
	}
	
	
	//����eid��ѯ��ָ����������
	public Experience selectOneExperienceByEid(int eid) throws Exception{
		Experience exp = null;
		UserDao dao = new UserDao();
		try {
			exp=dao.selectOneExperienceByEid(eid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return exp;
		
	}
	
	//����eid�޸Ĺ�������
	public void updateExperience(int eid,String ecompany,String etimes,String epost,String edes) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.updateExperience(eid, ecompany, etimes, epost, edes);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}
	
	//��ӹ�������
	public void addExperience(int rid,String ecompany, String etimes,String epost,String edes) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.addExperience(rid, ecompany, etimes, epost, edes);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
	}
	
	//����eidɾ����������
	public void deleteExperience(int eid) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.deleteExperience(eid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}
	
	//����rid��ѯ������Ϣ
	public Resume selectUserInfo(int rid) throws Exception{
		Resume resume=null;
		UserDao dao = new UserDao();
		try {
			resume=dao.selectUserInfo(rid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return resume;
		
	}
	
	//����rid��ѯ��������
	public List<Experience>  selectUserExperience(int rid) throws Exception{
		List<Experience> list=new ArrayList<Experience>();
		UserDao dao = new UserDao();
		try {
			list=dao.selectUserExperience(rid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
		return list;
	}
	
	//����uid��ѯ��rid
	public int selectRidByUid(int uid) throws Exception{
		int rid=0;
		UserDao dao = new UserDao();
		try {
			rid=dao.selectRidByUid(uid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		return rid;
		
	}
	
	//��¼��������ѯ�û����������Ƿ�������ݿ���
	public  User  findUserWhenLogin(String username,String password) throws Exception{
		User user= null;
		UserDao dao = new  UserDao();
		try {
			user=dao.findUserWhenLogin(username, password);
		} catch (Exception e) {
			throw e;
		}finally{
			//�ر�����
			dao.closeConnection();
		}
		
		return user;
		
	}

	// ע���û�
	public void registerUser(String phone, String pwd, String status,String name,String ubehave)
			throws Exception {
		UserDao dao = new UserDao();
		try {
			dao.registerUser(phone, pwd, status, name,ubehave);
		} catch (Exception e) {
			throw e;
		} finally {
			// �ر����ݿ������
			dao.closeConnection();
		}
	}

	// �ж��û����Ƿ��ظ�
	public User selectByName(String name) throws Exception {
		User user = null;
		UserDao dao = new UserDao();
		try {
			user = dao.selectByname(name);
		} catch (Exception e) {
			throw e;
		} finally {
			dao.closeConnection();
		}
		return user;

	}

	// �ж��ֻ����Ƿ��ظ�
	public User selectByphone(String phone) throws Exception {
			User user = null;
			UserDao dao = new UserDao();
			try {
				user = dao.selectByPhone(phone);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return user;

		}

	//���¸��˼����Ļ�����Ϣ
	public void updateResume(int rid, String rname, String fileName,String rage, String rsex, String rphone, String remail,String reducation, String rwant,String time) throws Exception {
		UserDao dao = new UserDao();
		try {
			dao.updateResume(rid, rname, fileName, rage, rsex, rphone, remail, reducation, rwant,time);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeConnection();
		}
		
	}
	//ˢ�¼���
		public void refreshResume(int rid,String time) throws Exception{
			UserDao dao = new UserDao();
			try {
				dao.refreshResume(rid, time);
			} catch (Exception e) {
				throw e;
			}finally{
				dao.closeConnection();
			}
			
		}

		
}
