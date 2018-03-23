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
	// 验证登录的账号是否为管理员
		// 管理员的用户名为admin,密码为123
		// 也可以为管理员建立一张表,到数据库中查询是否为管理员
		public boolean getAdmin(String username, String pwd) {
			boolean flag = false;
			if ("admin".equals(username) && "123".equals(pwd)) {
				flag = true;
			}
			return flag;
		}

		// 查看所有用户信息
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

		// 根据用户uid改变ubehave
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

		// 根据用户uid查看用户的详情
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

		// 根据用户id查询简历id
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

		// 根据uid获取用户的身份状态---0 个人 1 企业
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

		// 根据用户状态ubehave查询用户的信息 ---0 启用 1 禁用
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

		// 删除禁用用户---根据用户的禁用状态查询用户uid，然后删除---状态变成2 就表示已经删除
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

		// 添加新闻
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

		// 查看所有新闻信息
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

		// 分页展示新闻信息
		public PageList<News> pageListNews(PageList<News> page, int max)
				throws Exception {
			AdminDao dao = new AdminDao();
			try {
				// 获取到分页显示的简历列表
				// 获取当前页
				int beginPage = (page.getCurrentPage() - 1) * max;
				List<News> list = dao.pageGetNewsInfo(beginPage, max);
				page.setList(list);
				// 获取简历总条数
				int countResume = dao.selectCountNews();
				page.setTotalNum(countResume);
				// 计算总页数
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

		// 根据nid查看新闻详情
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

		// //根据nid修改新闻详情
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

		// 根据nid修改新闻详情
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

		// 根据nid删除新闻
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

		// 查看所有Feedback信息
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

		// 分页展示新闻信息
		public PageList<Feedback> pageListFeedback(PageList<Feedback> page, int max)
				throws Exception {
			AdminDao dao = new AdminDao();
			try {
				// 获取到分页显示的简历列表
				// 获取当前页
				int beginPage = (page.getCurrentPage() - 1) * max;
				List<Feedback> list = dao.pageGetFeedbackInfo(beginPage, max);
				page.setList(list);
				// 获取简历总条数
				int countResume = dao.selectCountFeedback();
				page.setTotalNum(countResume);
				// 计算总页数
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

		// 根据fid查看反馈信息详情
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

		// 根据fid删除反馈信息
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
