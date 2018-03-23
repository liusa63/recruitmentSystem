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
	// �鿴�����û���Ϣ
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

		// �����û�uid�ı�ubehave
		public void updateUserBehave(int uid, String ubehave) throws Exception {
			openConnection();
			String sql = "update user set u_behave=? where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, ubehave);
			st.setInt(2, uid);
			st.execute();
			st.close();
		}

		// �����û�uid�鿴�û�������
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

		// ����uid��ȡ�û������״̬---0 ���� 1 ��ҵ
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

		// // �����û�uid��ѯ�û���״̬ubehave ---0 ���� 1 ����
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

		// ����ubehav�鿴�û�����Ϣ
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

		// // ɾ�������û�---�����û��Ľ���״̬��ѯ�û�uid��Ȼ������û�uidɾ�����û�
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
		// Ȼ������û�uidɾ�����û�---�޸��û���״̬��2 �����Ѿ��޸�
		public void delUserByUid(int uid) throws Exception {
			openConnection();
			String sql = "update user set u_behave='2' where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			st.execute();
			st.close();
		}

		// �������
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

		// �鿴����������Ϣ
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

		// ��ҳ��ѯ���ݿ���������Ϣ
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

		// ��ѯ���ŵ�������
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

		// ����nid�鿴��������
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

		// ����nid�޸���������
		public void updateNewsByNid(int nid, String ntitle, String ncontent,
				String nimg, String ntimes) throws Exception {
			
			openConnection();
			// ����nid��ѯ������Ϣ
			// ����SQL���
			String sql1 = "select * from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setInt(1, nid);
			// ��ȡ�����
			ResultSet rs = st.executeQuery();
			// ��������
			// �����Ϣû�иı������κβ���
			// �����Ϣ�����ı���������ݿ�
			while (rs.next()) {
				// �ж����ű����Ƿ񱻸���
				if (ntitle.equals(rs.getString("n_title"))) {
					// û�и��£���������
				} else {
					// ����
					String sql2 = "update news set n_title=? where n_id=? ";
					st = conn.prepareStatement(sql2);
					st.setString(1, ntitle);
					st.setInt(2, nid);
					st.execute();
				}
				if (ncontent.equals(rs.getString("n_content"))) {
					// û�и��£���������
				} else {
					// ����
					String sql3 = "update news set n_content=? where n_id=? ";
					st = conn.prepareStatement(sql3);
					st.setString(1, ncontent);
					st.setInt(2, nid);
					st.execute();
				}
				if (nimg.equals(rs.getString("n_img"))) {
					// û�и��£���������
				} else {
					// ����
					String sql4 = "update news set n_ims=? where n_id=? ";
					st = conn.prepareStatement(sql4);
					st.setString(1, nimg);
					st.setInt(2, nid);
					st.execute();
				}
				if (ntimes.equals(rs.getString("n_times"))) {
					// û�и��£���������
				} else {
					// ����
					String sql5 = "update news set n_times=? where n_id=? ";
					st = conn.prepareStatement(sql5);
					st.setString(1, ntimes);
					st.setInt(2, nid);
					st.execute();
				}
			}
			st.close();
		}

		// ����nid�޸���������
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

		// ����nidɾ������
		public void delNewsByRid(int nid) throws Exception {
			openConnection();
			String sql = "delete from news where n_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nid);
			st.execute();
			st.close();
		}

		// �鿴����Feedback��Ϣ
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

		// ����fid�鿴������Ϣ����
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

		// ����fidɾ��������Ϣ
		public void delFeedbackByRid(int fid) throws Exception {
			openConnection();
			String sql = "delete from feedback where f_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, fid);
			st.execute();
			st.close();
		}

		// ��ҳ��ѯ���ݿ��з�����Ϣ
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

		// ��ѯ������Ϣ��������
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
