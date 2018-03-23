/**
 * 
 */
package com.recruitmentSystem.biz;

import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.dao.AdminDao;
import com.recruitmentSystem.dao.UserDao;
import com.recruitmentSystem.entity.Feedback;
import com.recruitmentSystem.entity.News;
import com.recruitmentSystem.entity.User;
import com.recruitmentSystem.util.PageList;

/**
 * @author Administrator
 *
 */
public class AdminBiz {
	// ��֤��¼���˺��Ƿ�Ϊ����Ա
		// ����Ա���û���Ϊadmin,����Ϊ123
		// Ҳ����Ϊ����Ա����һ�ű�,�����ݿ��в�ѯ�Ƿ�Ϊ����Ա
		public boolean getAdmin(String username, String pwd) {
			boolean flag = false;
			if ("admin".equals(username) && "123".equals(pwd)) {
				flag = true;
			}
			return flag;
		}

		// �鿴�����û���Ϣ
		public List<User> selectAllUser() throws Exception {
			List<User> list = new ArrayList<User>();
			AdminDao dao = new AdminDao();
			try {
				list = dao.selectAllUser();
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return list;

		}

		// �����û�uid�ı�ubehave
		public void updateUserBehave(int uid, String ubehave) throws Exception {
			AdminDao dao = new AdminDao();
			try {
				dao.updateUserBehave(uid, ubehave);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
		}

		// �����û�uid�鿴�û�������
		public User selectUserByUid(int uid) throws Exception {
			AdminDao dao = new AdminDao();
			User user = new User();
			try {
				user = dao.selectUserByUid(uid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return user;

		}

		// �����û�id��ѯ����id
		public int selectRidByUid(int uid) throws Exception {
			int rid = 0;
			UserDao dao = new UserDao();
			try {
				rid = dao.selectRidByUid(uid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return rid;
		}

		// ����uid��ȡ�û������״̬---0 ���� 1 ��ҵ
		public String selectUstatusByUid(int uid) throws Exception {
			String ustatus = null;
			AdminDao dao = new AdminDao();
			try {
				ustatus = dao.selectUstatusByUid(uid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return ustatus;

		}

		// �����û�״̬ubehave��ѯ�û�����Ϣ ---0 ���� 1 ����
		public List<User> selectUserByUbehave() throws Exception {
			List<User> ulist = null;
			AdminDao dao = new AdminDao();
			try {
				ulist = dao.selectUserByUbehave();
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return ulist;
		}

		// ɾ�������û�---�����û��Ľ���״̬��ѯ�û�uid��Ȼ��ɾ��---״̬���2 �ͱ�ʾ�Ѿ�ɾ��
		public void delUserByUbahaveAndUid(int uid) throws Exception {
			AdminDao dao = new AdminDao();
			try {
				dao.delUserByUid(uid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
		}

		// �������
		public void addNews(String ntitle, String ncontect, String npic,
				String ntimes) throws Exception {
			AdminDao dao = new AdminDao();
			try {
				dao.addNews(ntitle, ncontect, npic, ntimes);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
		}

		// �鿴����������Ϣ
		public List<News> selectAllNews() throws Exception {
			List<News> list = new ArrayList<News>();
			AdminDao dao = new AdminDao();
			try {
				list = dao.selectAllNews();
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return list;

		}

		// ��ҳչʾ������Ϣ
		public PageList<News> pageListNews(PageList<News> page, int max)
				throws Exception {
			AdminDao dao = new AdminDao();
			try {
				// ��ȡ����ҳ��ʾ�ļ����б�
				// ��ȡ��ǰҳ
				int beginPage = (page.getCurrentPage() - 1) * max;
				List<News> list = dao.pageGetNewsInfo(beginPage, max);
				page.setList(list);
				// ��ȡ����������
				int countResume = dao.selectCountNews();
				page.setTotalNum(countResume);
				// ������ҳ��
				int countPage = countResume % max == 0 ? countResume / max
						: countResume / max + 1;
				page.setCountPage(countPage);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return page;
		}

		// ����nid�鿴��������
		public News selectNewsByNid(int nid) throws Exception {
			News news = new News();
			AdminDao dao = new AdminDao();
			try {
				news = dao.selectNewsByNid(nid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return news;
		}

		// //����nid�޸���������
		// public void updateNewsByNid(int nid, String ntitle, String ncontent,
		// String nimg, String ntimes ) throws Exception {
		// AdminDao dao=new AdminDao();
		// try {
		// dao.updateNewsByNid(nid, ntitle, ncontent, nimg, ntimes);
		// } catch (Exception e) {
		// throw e;
		// }finally{
		// dao.closeConnection();
		// }
		// }

		// ����nid�޸���������
		public News updateNewsByNid(int nid) throws Exception {
			News news = new News();
			AdminDao dao = new AdminDao();
			try {
				news = dao.updateNewsByNid(nid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return news;
		}

		// ����nidɾ������
		public void delNewsByNid(int nid) throws Exception {
			AdminDao dao = new AdminDao();
			try {
				dao.delNewsByRid(nid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
		}

		// �鿴����Feedback��Ϣ
		public List<Feedback> selectAllFeedback() throws Exception {
			List<Feedback> list = new ArrayList<Feedback>();
			AdminDao dao = new AdminDao();
			try {
				list = dao.selectAllFeedback();
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return list;
		}

		// ��ҳչʾ������Ϣ
		public PageList<Feedback> pageListFeedback(PageList<Feedback> page, int max)
				throws Exception {
			AdminDao dao = new AdminDao();
			try {
				// ��ȡ����ҳ��ʾ�ļ����б�
				// ��ȡ��ǰҳ
				int beginPage = (page.getCurrentPage() - 1) * max;
				List<Feedback> list = dao.pageGetFeedbackInfo(beginPage, max);
				page.setList(list);
				// ��ȡ����������
				int countResume = dao.selectCountFeedback();
				page.setTotalNum(countResume);
				// ������ҳ��
				int countPage = countResume % max == 0 ? countResume / max
						: countResume / max + 1;
				page.setCountPage(countPage);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return page;
		}

		// ����fid�鿴������Ϣ����
		public Feedback selectFeedbackByFid(int fid) throws Exception {
			Feedback fb = new Feedback();
			AdminDao dao = new AdminDao();
			try {
				fb = dao.selectFeedbackByFid(fid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
			return fb;
		}

		// ����fidɾ��������Ϣ
		public void delFeedbackByRid(int fid) throws Exception {
			AdminDao dao = new AdminDao();
		
			try {
				dao.delFeedbackByRid(fid);
			} catch (Exception e) {
				throw e;
			} finally {
				dao.closeConnection();
			}
		}

}
