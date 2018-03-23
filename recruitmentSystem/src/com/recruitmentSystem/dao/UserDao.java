/**
 * 
 */
package com.recruitmentSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.entity.Delivery;
import com.recruitmentSystem.entity.Experience;
import com.recruitmentSystem.entity.Resume;
import com.recruitmentSystem.entity.User;

public class UserDao extends BaseDao{
	
	
	//向管理员反馈
	public void feedBack(int uid, String fname,String femail,String fmsg) throws Exception{
		openConnection();
		String sql="insert into feedback(u_id,f_name,f_email,f_msg) values(?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, uid);
		st.setString(2, fname);
		st.setString(3, femail);
		st.setString(4, fmsg);
		st.execute();
		st.close();
	}
	
	
	//根据rid查询delivery集合
	public List<Delivery> findDelivery(int rid) throws Exception{
		List<Delivery> list=new ArrayList<Delivery>();
		Delivery del = null;
		openConnection();
		String sql="select * from delivery where r_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, rid);
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			del= new Delivery();
			del.setPid(rs.getInt("p_id"));
			del.setRid(rid);
			del.setDstatus(rs.getInt("d_status"));
			list.add(del);
		}
		rs.close();
		st.close();
		return list;
		
	}
	
	//简历投递(1是用户投递，0是公司邀请)
	public void  addDelivery(int pid,int rid,int dstatus) throws Exception{
		openConnection();
		String sql="insert into delivery(p_id,r_id,d_status) values(?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, pid);
		st.setInt(2, rid);
		st.setInt(3, dstatus);
		st.execute();
		st.close();
	}
	
	//根据eid查询到指定工作经验
	public Experience selectOneExperienceByEid(int eid) throws Exception{
		Experience exp = null;
		openConnection();
		String sql="select *  from experience where e_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, eid);
		ResultSet rs = st.executeQuery();
        if(rs.next()){
        	exp = new Experience();
        	exp.setEid(eid);
        	exp.setRid(rs.getInt("r_id"));
        	exp.setEcompany(rs.getString("e_company"));
        	exp.setEtimes(rs.getString("e_times"));
        	exp.setEpost(rs.getString("e_post"));
        	exp.setEdes(rs.getString("e_des"));
        	
        }
        rs.close();
		st.close();
		return exp;
		
	}
	
	//根据eid修改工作经验
	public void updateExperience(int eid,String ecompany,String etimes,String epost,String edes) throws Exception{
		openConnection();
		//根据rid查询简历基本信息
		// 创建SQL语句
		String sql1 = "select * from experience where e_id=?";
		PreparedStatement st = conn.prepareStatement(sql1);
		st.setInt(1, eid);
		// 获取结果集
		ResultSet rs = st.executeQuery();
		// 处理结果集
		// 如果信息没有改变则不做任何操作
		// 如果信息发生改变则更新数据库
		if(rs.next()){
			//判断曾在公司名是否被更新
			if(ecompany.equals(rs.getString("e_company"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update experience set e_company=? where e_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, ecompany);
				 st.setInt(2, eid);
				 st.execute();
			}
			//判断曾在公司的任期是否被更新
			if(etimes.equals(rs.getString("e_times"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update experience set e_times=? where e_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, etimes);
				 st.setInt(2, eid);
				 st.execute();
			}
			if(epost.equals(rs.getString("e_post"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update experience set e_post=? where e_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, epost);
				 st.setInt(2, eid);
				 st.execute();
			}
			if(edes.equals(rs.getString("e_des"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update experience set e_des=? where e_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, edes);
				 st.setInt(2, eid);
				 st.execute();
			}
			
			
		}
		
	}
	
	//添加工作经验
	public void addExperience(int rid,String ecompany, String etimes,String epost,String edes) throws Exception{
		openConnection();
		String sql="insert into experience(r_id,e_company,e_times,e_post,e_des) values(?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, rid);
		st.setString(2, ecompany);
		st.setString(3, etimes);
		st.setString(4, epost);
		st.setString(5, edes);
		st.execute();
		st.close();
	}
	
	//删除工作经验
	public void deleteExperience(int eid) throws Exception{
		openConnection();
		String sql="delete from experience where e_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, eid);
		st.execute();
		st.close();
	}
	
	//刷新简历
	public void refreshResume(int rid,String time) throws Exception{
		openConnection();
		String sql="update resume set r_up=? where r_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, time);
		 st.setInt(2, rid);
		 st.execute();
		 st.close();
	}
	
	//修改个人简历的基本信息
	public void updateResume(int rid, String rname, String fileName,
			String rage, String rsex, String rphone, String remail,
			String reducation, String rwant,String time) throws Exception {
		refreshResume(rid,time);
		openConnection();
		//根据rid查询简历基本信息
		// 创建SQL语句
		String sql1 = "select * from resume where r_id=?";
		PreparedStatement st = conn.prepareStatement(sql1);
		st.setInt(1, rid);
		// 获取结果集
		ResultSet rs = st.executeQuery();
		// 处理结果集
		// 如果信息没有改变则不做任何操作
		// 如果信息发生改变则更新数据库
		while(rs.next()){
			//判断姓名是否被更新
			if(rname.equals(rs.getString("r_name"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_name=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, rname);
				 st.setInt(2, rid);
				 st.execute();
			}
			if(fileName.equals("")){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_pic=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, fileName);
				 st.setInt(2, rid);
				 st.execute();
			}
			if(rage.equals(rs.getString("r_age"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_age=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, rage);
				 st.setInt(2, rid);
				 st.execute();
			}
			if(rsex.equals(rs.getString("r_sex"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_sex=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, rsex);
				 st.setInt(2, rid);
				 st.execute();
			}
			if(rphone.equals(rs.getString("r_phone"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_phone=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, rphone);
				 st.setInt(2, rid);
				 st.execute();
			}
			if(remail.equals(rs.getString("r_email"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_email=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, remail);
				 st.setInt(2, rid);
				 st.execute();
			}
			
			if(reducation.equals(rs.getString("r_education"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_education=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, reducation);
				 st.setInt(2, rid);
				 st.execute();
			}
			
			if(rwant.equals(rs.getString("r_want"))){
				//没有更新，不做处理
			}else{
				//更新
				String sql2="update resume set r_want=? where r_id=? ";
				 st=conn.prepareStatement(sql2);
				 st.setString(1, rwant);
				 st.setInt(2, rid);
				 st.execute();
			}
			
		}
		
	}
	
	//根据rid查询基本信息
	public Resume selectUserInfo(int rid) throws Exception{
		Resume resume=null;
		openConnection();
		String sql="select * from resume where r_id=? ";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, rid);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			resume= new Resume();
			resume.setRid(rid);
			resume.setUid(rs.getInt("u_id"));
            resume.setRname(rs.getString("r_name"));
            resume.setRpic(rs.getString("r_pic"));
            resume.setRage(rs.getString("r_age"));
            resume.setRsex(rs.getString("r_sex"));
            resume.setRphone(rs.getString("r_phone"));
            resume.setRemail(rs.getString("r_email"));
            resume.setReducation(rs.getString("r_education"));
            resume.setRwant(rs.getString("r_want"));
		}
		rs.close();
		st.close();
		return resume;
		
	}
	
	//根据rid查询工作经验
	public List<Experience> selectUserExperience(int rid) throws Exception{
			List<Experience> list=new ArrayList<Experience>();
			Experience exp=null;
			openConnection();
			String sql="select * from experience where r_id=? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, rid);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				exp=new Experience();
				exp.setEid(rs.getInt("e_id"));
				exp.setRid(rid);
				exp.setEcompany(rs.getString("e_company"));
				exp.setEpost(rs.getString("e_post"));
				exp.setEtimes(rs.getString("e_times"));
				exp.setEdes(rs.getString("e_des"));
				list.add(exp);
			}
			rs.close();
			st.close();
			return list;
			
		}
	
	//根据uid查询到rid
	public int selectRidByUid(int uid) throws Exception{
			int rid=0;
			openConnection();
			String sql="select r_id from resume where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, uid);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				rid=rs.getInt("r_id");
			}
			rs.close();
			st.close();
			return rid;
			
		}
	
    //登录操作：查询用户名和密码是否存在数据库中
	public  User  findUserWhenLogin(String username,String password) throws Exception{
		User user= null;
		//打开连接
		openConnection();
		//判断用户登录方式
		    //用户使用 用户名名登录
			String sql1="select * from user where u_name=? and u_pwd=? ";
			//创建执行sql的Statement
			PreparedStatement st1=conn.prepareStatement(sql1);
			st1.setString(1, username);
			st1.setString(2, password);
			
			//获取结果集
			ResultSet rs=st1.executeQuery();
			//处理结果集
			if(rs.next()){
				user=new User();
				user.setUid(rs.getInt("u_id"));
				user.setUpwd(rs.getString("u_pwd"));
				user.setUname(rs.getString("u_name"));
				user.setUphone(rs.getString("u_phone"));
				user.setUstatus(rs.getString("u_status"));
				user.setUbehave(rs.getString("u_behave"));
			}else{//用户使用手机号登录
				String sql2="select * from user where u_phone=? and u_pwd=? ";
				PreparedStatement st2=conn.prepareStatement(sql2);
				st2.setString(1, username);
				st2.setString(2, password);
				rs=st2.executeQuery();
				if(rs.next()){
					user=new User();
					user.setUid(rs.getInt("u_id"));
					user.setUpwd(rs.getString("u_pwd"));
					user.setUname(rs.getString("u_name"));
					user.setUphone(rs.getString("u_phone"));
					user.setUstatus(rs.getString("u_status"));
					user.setUbehave(rs.getString("u_behave"));
				}
				//释放资源
				st2.close();
			}
		st1.close();
		rs.close();
		return user;
	}
	
	// 注册用户
	public void registerUser(String phone, String pwd, String status,String name,String ubehave)
			throws Exception {
		// 打开链接
		openConnection();
		String sql = "insert into user(u_phone,u_pwd,u_status,u_name,u_behave) values(?,?,?,?,?);";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, phone);
		st.setString(2, pwd);
		st.setString(3, status);
		st.setString(4, name);
		st.setString(5, ubehave);
		st.execute();
		// 释放资源
		st.close();
	}

	// 判断用户名是否重复
	public User selectByname(String name) throws Exception {
		User user = null;
		openConnection();
		String sql = "select * from user where u_name=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		// 处理结果集
		if (rs.next()) {
			user = new User();
			user.setUid(rs.getInt("u_id"));
			user.setUname(rs.getString("u_name"));
			user.setUphone(rs.getString("u_phone"));
			user.setUpwd(rs.getString("u_pwd"));
			user.setUstatus(rs.getString("u_status"));
			user.setUbehave(rs.getString("u_behave"));
		}
		rs.close();
		st.close();
		return user;
	}

	// 判断手机号是否重复
	public User selectByPhone(String phone) throws Exception {
			User user = null;
			openConnection();
			String sql = "select * from user where u_phone=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, phone);
			ResultSet rs = st.executeQuery();
			// 处理结果集
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("u_id"));
				user.setUname(rs.getString("u_name"));
				user.setUphone(rs.getString("u_phone"));
				user.setUpwd(rs.getString("u_pwd"));
				user.setUstatus(rs.getString("u_status"));
				user.setUbehave(rs.getString("u_behave"));
			}
			rs.close();
			st.close();
			return user;

		}
	

}
