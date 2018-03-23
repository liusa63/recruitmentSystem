/**
 * 
 */
package com.recruitmentSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.entity.Feedback;
import com.recruitmentSystem.entity.News;
import com.recruitmentSystem.entity.User;

/**
 * @author Administrator
 *
 */
public class AdminDao extends BaseDao{
	// 查看所有用户信息
		public List<User> selectAllUser() throws Exception {
			List<User> list = new ArrayList<User>();
			openConnection();
			String sql = "select * from user";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("u_id"));
				user.setUname(rs.getString("u_name"));
				user.setUbehave(rs.getString("u_behave"));
				user.setUphone(rs.getString("u_phone"));
				user.setUstatus(rs.getString("u_status"));
				list.add(user);

			}
			rs.close();
			st.close();
			return list;
		}

		// 根据用户uid改变ubehave
		public void updateUserBehave(int uid, String ubehave) throws Exception {
			openConnection();
			String sql = "update user set u_behave=? where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, ubehave);
			st.setInt(2, uid);
			st.execute();
			st.close();
		}

		// 根据用户uid查看用户的详情
		public User selectUserByUid(int uid) throws Exception {
			User user = new User();
			openConnection();
			String sql = "select * from user where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setUid(rs.getInt("u_id"));
				user.setUname(rs.getString("u_name"));
				user.setUbehave(rs.getString("u_behave"));
				user.setUphone(rs.getString("u_phone"));
				user.setUstatus(rs.getString("u_status"));
			}
			rs.close();
			st.close();
			return user;

		}

		// 根据uid获取用户的身份状态---0 个人 1 企业
		public String selectUstatusByUid(int uid) throws Exception {
			String ustatus = null;
			openConnection();
			String sql = "select u_status from user where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				ustatus = rs.getString("u_status");
			}
			rs.close();
			st.close();
			return ustatus;
		}

		// // 根据用户uid查询用户的状态ubehave ---0 启用 1 禁用
		// public String selectUbehaveByUid(int uid) throws Exception {
		// String ubehave = null;
		// openConnection();
		// String sql = "select u_behave from user where u_id=?";
		// PreparedStatement st = conn.prepareStatement(sql);
		// st.setInt(1, uid);
		// ResultSet rs = st.executeQuery();
		// if (rs.next()) {
		// ubehave = rs.getString("u_behave");
		// }
		// rs.close();
		// st.close();
		// return ubehave;
		// }

		// 根据ubehav查看用户的信息
		public List<User> selectUserByUbehave() throws Exception {
			List<User> ulist = new ArrayList<User>();
			User user = null;
			openConnection();
			String sql = "select * from user where u_behave='1'";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("u_id"));
				user.setUname(rs.getString("u_name"));
				user.setUbehave(rs.getString("u_behave"));
				user.setUphone(rs.getString("u_phone"));
				user.setUstatus(rs.getString("u_status"));
				ulist.add(user);
			}
			rs.close();
			st.close();
			return ulist;
		}

		// // 删除禁用用户---根据用户的禁用状态查询用户uid，然后根据用户uid删除该用户
		// public int selectUidByUbehave() throws Exception{
		// int uid=0;
		// openConnection();
		// String sql = "select u_id from user where u_behave='1'";
		// PreparedStatement st = conn.prepareStatement(sql);
		// ResultSet rs = st.executeQuery();
		// if (rs.next()) {
		// uid=rs.getInt("u_id");
		// }
		// rs.close();
		// st.close();
		// return uid;
		//
		// }
		// 然后根据用户uid删除该用户---修改用户的状态，2 代表已经修改
		public void delUserByUid(int uid) throws Exception {
			openConnection();
			String sql = "update user set u_behave='2' where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			st.execute();
			st.close();
		}

		// 添加新闻
		public void addNews(String ntitle, String ncontect, String nimg,
				String ntimes) throws Exception {
			openConnection();
			String sql = "insert into news(n_title,n_content,n_img,n_times) values(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, ntitle);
			st.setString(2, ncontect);
			st.setString(3, nimg);
			st.setString(4, ntimes);
			st.execute();
			st.close();
		}

		// 查看所有新闻信息
		public List<News> selectAllNews() throws Exception {
			List<News> nlist = new ArrayList<News>();
			openConnection();
			String sql = "select * from news";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				News n = new News();
				n.setNcontent(rs.getString("n_content"));
				n.setNid(rs.getInt("n_id"));
				n.setNimg(rs.getString("n_img"));
				n.setNtimes(rs.getDate("n_times"));
				n.setNtitle(rs.getString("n_title"));
				nlist.add(n);
			}
			rs.close();
			st.close();
			return nlist;
		}

		// 分页查询数据库中新闻信息
		public List<News> pageGetNewsInfo(int beginPage, int max) throws Exception {
			List<News> list = new ArrayList<News>();
			openConnection();
			String sql = "select * from news limit ?,?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, beginPage);
			st.setInt(2, max);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				News n = new News();
				n.setNcontent(rs.getString("n_content"));
				n.setNid(rs.getInt("n_id"));
				n.setNimg(rs.getString("n_img"));
				n.setNtimes(rs.getDate("n_times"));
				n.setNtitle(rs.getString("n_title"));
				list.add(n);
			}
			rs.close();
			st.close();
			return list;
		}

		// 查询新闻的总条数
		public int selectCountNews() throws Exception {
			int count = 0;
			openConnection();
			String sql = "select count(*) from news";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			st.close();
			return count;
		}

		// 根据nid查看新闻详情
		public News selectNewsByNid(int nid) throws Exception {
			News n = new News();
			openConnection();
			String sql = "select * from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				n.setNcontent(rs.getString("n_content"));
				n.setNid(rs.getInt("n_id"));
				n.setNimg(rs.getString("n_img"));
				n.setNtimes(rs.getDate("n_times"));
				n.setNtitle(rs.getString("n_title"));
			}
			rs.close();
			st.close();
			return n;
		}

		// 根据nid修改新闻详情
		public void updateNewsByNid(int nid, String ntitle, String ncontent,
				String nimg, String ntimes) throws Exception {
			
			openConnection();
			// 根据nid查询新闻信息
			// 创建SQL语句
			String sql1 = "select * from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setInt(1, nid);
			// 获取结果集
			ResultSet rs = st.executeQuery();
			// 处理结果集
			// 如果信息没有改变则不做任何操作
			// 如果信息发生改变则更新数据库
			while (rs.next()) {
				// 判断新闻标题是否被更新
				if (ntitle.equals(rs.getString("n_title"))) {
					// 没有更新，不做处理
				} else {
					// 更新
					String sql2 = "update news set n_title=? where n_id=? ";
					st = conn.prepareStatement(sql2);
					st.setString(1, ntitle);
					st.setInt(2, nid);
					st.execute();
				}
				if (ncontent.equals(rs.getString("n_content"))) {
					// 没有更新，不做处理
				} else {
					// 更新
					String sql3 = "update news set n_content=? where n_id=? ";
					st = conn.prepareStatement(sql3);
					st.setString(1, ncontent);
					st.setInt(2, nid);
					st.execute();
				}
				if (nimg.equals(rs.getString("n_img"))) {
					// 没有更新，不做处理
				} else {
					// 更新
					String sql4 = "update news set n_ims=? where n_id=? ";
					st = conn.prepareStatement(sql4);
					st.setString(1, nimg);
					st.setInt(2, nid);
					st.execute();
				}
				if (ntimes.equals(rs.getString("n_times"))) {
					// 没有更新，不做处理
				} else {
					// 更新
					String sql5 = "update news set n_times=? where n_id=? ";
					st = conn.prepareStatement(sql5);
					st.setString(1, ntimes);
					st.setInt(2, nid);
					st.execute();
				}
			}
			st.close();
		}

		// 根据nid修改新闻详情
		public News updateNewsByNid(int nid) throws Exception {
			News n = new News();
			openConnection();
			String sql = "select * from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				n.setNcontent(rs.getString("n_content"));
				n.setNid(rs.getInt("n_id"));
				n.setNimg(rs.getString("n_img"));
				n.setNtimes(rs.getDate("n_times"));
				n.setNtitle(rs.getString("n_title"));
			}
			rs.close();
			st.close();
			return n;
		}

		// 根据nid删除新闻
		public void delNewsByRid(int nid) throws Exception {
			openConnection();
			String sql = "delete from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nid);
			st.execute();
			st.close();
		}

		// 查看所有Feedback信息
		public List<Feedback> selectAllFeedback() throws Exception {
			List<Feedback> list = new ArrayList<Feedback>();
			openConnection();
			String sql = "select * from feedback";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Feedback fb = new Feedback();
				fb.setFemail(rs.getString("f_email"));
				fb.setFid(rs.getInt("f_id"));
				fb.setFmsg(rs.getString("f_msg"));
				fb.setFname(rs.getString("f_name"));
				fb.setUid(rs.getInt("u_id"));
				list.add(fb);

			}
			rs.close();
			st.close();
			return list;
		}

		// 根据fid查看反馈信息详情
		public Feedback selectFeedbackByFid(int fid) throws Exception {
			Feedback fb = new Feedback();
			openConnection();
			String sql = "select * from feedback where f_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, fid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				fb.setFemail(rs.getString("f_email"));
				fb.setFid(rs.getInt("f_id"));
				fb.setFmsg(rs.getString("f_msg"));
				fb.setFname(rs.getString("f_name"));
				fb.setUid(rs.getInt("u_id"));
			}
			rs.close();
			st.close();
			return fb;
		}

		// 根据fid删除反馈信息
		public void delFeedbackByRid(int fid) throws Exception {
			openConnection();
			String sql = "delete from feedback where f_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, fid);
			st.execute();
			st.close();
		}

		// 分页查询数据库中反馈信息
		public List<Feedback> pageGetFeedbackInfo(int beginPage, int max) throws Exception {
			List<Feedback> list = new ArrayList<Feedback>();
			openConnection();
			String sql = "select * from feedback limit ?,?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, beginPage);
			st.setInt(2, max);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Feedback fb = new Feedback();
				fb.setFemail(rs.getString("f_email"));
				fb.setFid(rs.getInt("f_id"));
				fb.setFmsg(rs.getString("f_msg"));
				fb.setFname(rs.getString("f_name"));
				fb.setUid(rs.getInt("u_id"));
				list.add(fb);
			}
			rs.close();
			st.close();
			return list;
		}

		// 查询反馈信息的总条数
		public int selectCountFeedback() throws Exception {
			int count = 0;
			openConnection();
			String sql = "select count(*) from feedback";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			st.close();
			return count;
		}
	

}
