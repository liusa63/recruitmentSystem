/**
 * 
 */
package com.recruitmentSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.entity.ResumeVo;

public class ResumeDao extends BaseDao{
	
	
	//添加简历基本信息
	public void addResume(int uid, String rname, String rpic,
			String rage, String rsex, String rphone, String remail,
			String reducation,String rwant,String rup) throws Exception {
	   openConnection();
	   String sql="insert into resume(u_id,r_name,r_pic,r_age,r_sex,r_phone,r_email,r_education,r_want,r_up) values(?,?,?,?,?,?,?,?,?,?)";
	   PreparedStatement st=conn.prepareStatement(sql);
	   st.setInt(1, uid);
	   st.setString(2, rname);
	   st.setString(3, rpic);
	   st.setString(4, rage);
	   st.setString(5, rsex);
	   st.setString(6, rphone);
	   st.setString(7, remail);
	   st.setString(8, reducation);
	   st.setString(9, rwant);
	   st.setString(10, rup);
	   st.execute();
	   st.close();
   }

	
	//分页查询数据库中求职（简历）信息
	public List<ResumeVo> pageGetResumeInfo(int beginPage, int max,int uid) throws Exception {
		List<ResumeVo> list=new ArrayList<ResumeVo>();
		 openConnection();
         String sql="select r.* from resume r,user u where u.u_id=r.u_id and u.u_behave!=2 order by r.r_up desc limit ?,? ";
         PreparedStatement st=conn.prepareStatement(sql);
         st.setInt(1,beginPage);
         st.setInt(2, max);
         ResultSet rs=st.executeQuery();
         while(rs.next()){
        	 ResumeVo r= new ResumeVo();
        	 r.setRid(rs.getInt("r_id"));
        	 r.setUid(rs.getInt("u_id"));
        	 r.setRname(rs.getString("r_name"));
        	 r.setRpic(rs.getString("r_pic"));
        	 r.setRage(rs.getString("r_age"));
        	 r.setRsex(rs.getString("r_sex"));
        	 r.setRphone(rs.getString("r_phone"));
        	 r.setRemail(rs.getString("r_email"));
        	 r.setReducation(rs.getString("r_education"));
        	 r.setRwant(rs.getString("r_want"));
        	//获取cid
        	 String sql2="select  c_id from companyinformation where u_id=?";
        	 PreparedStatement st2=conn.prepareStatement(sql2);
        	 st2.setInt(1, uid);
        	 ResultSet  rs2=st2.executeQuery();
        	 int cid=0;
        	 if(rs2.next()){
        		  cid=rs2.getInt("c_id");
        	 }
        	 //获取状态
        	 String sql3="select  d_status from delivery where r_id=? and p_id in (select p_id from relation where c_id=?)";
        	 PreparedStatement st3=conn.prepareStatement(sql3);
        	 st3.setInt(1, rs.getInt("r_id"));
        	 st3.setInt(2, cid);
        	 ResultSet  rs3=st3.executeQuery();
        	 if(rs3.next()){
        		 r.setDstatus(rs3.getInt("d_status"));
        	 }
        	 list.add(r);
         }
		rs.close();
		st.close();
		return list;
	}

	
	//查询简历的总条数
	public int selectCountResume() throws Exception {
		int count=0;
		openConnection();
		String sql="select count(*) from resume where u_id not in (select u_id from user where u_behave='2')";
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		if (rs.next()) {
			count=rs.getInt(1);
		}
		rs.close();
		st.close();
		return count;
		
	}
}

