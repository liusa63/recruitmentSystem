/**
 * 
 */
package com.recruitmentSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.recruitmentSystem.entity.Company;
import com.recruitmentSystem.entity.News;
import com.recruitmentSystem.entity.Relation;
import com.recruitmentSystem.entity.RelationVo;

/**
 * @author Administrator
 *
 */
public class CompanyDao extends BaseDao {
	
	//���Ű��
	public List<News> selectNews() throws Exception{
		News news= null;
		List<News> list = new ArrayList<News>();
		openConnection();
		String sql="select * from news order by n_times desc limit 3";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			news= new News();
			news.setNid(rs.getInt("n_id"));
			news.setNtitle(rs.getString("n_title"));
			news.setNcontent(rs.getString("n_content"));
			news.setNimg(rs.getString("n_img"));
			news.setNtimes(rs.getDate("n_times"));
			list.add(news);
		}
		rs.close();
		st.close();
		return list;
		
	}
	
	
	
	//ģ����ѯrpost
	public  List<RelationVo>  selectAboutType(int uid,String searchtype,String search) throws Exception {
		RelationVo relationVo=null;
		List<RelationVo> list = new ArrayList<RelationVo>();
		openConnection();
		if(searchtype.equals("r_post")){
			String sql="select * from relation  where r_post like  ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,"%"+search+"%");
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				relationVo = new RelationVo();
				relationVo.setPid(rs.getInt("p_id"));
				relationVo.setCid(rs.getInt("c_id"));
				relationVo.setRask(rs.getString("r_ask"));
				relationVo.setRpost(rs.getString("r_post"));
				relationVo.setRsalary(rs.getDouble("r_salary"));
				relationVo.setRtimes(rs.getDate("r_times"));
				
				//��˾����
				String sql2 = "select * from companyinformation where c_id=?";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.setInt(1, rs.getInt("c_id"));
				ResultSet rs2 = st2.executeQuery();
				if(rs2.next()){
					relationVo.setCname(rs2.getString("c_name"));
				}
				
				//��˾����
				
				//Ͷ��״̬
				String sql3 = "select d_status from delivery where p_id=? and r_id in (select r_id from resume where u_id=?)";
				PreparedStatement st3 = conn.prepareStatement(sql3);
				st3.setInt(1, rs.getInt("p_id"));
				st3.setInt(2, uid);
				ResultSet rs3 = st3.executeQuery();
				if(rs3.next()){
					relationVo.setDstatus(rs3.getInt("d_status"));
				}
				
				//Ͷ��״̬
				
				list.add(relationVo);
			}
		}else{
			String sql="select * from companyinformation  where "+searchtype+" like  ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,"%"+search+"%");
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				relationVo = new RelationVo();
				//��˾����	
				relationVo.setCname(rs.getString("c_name"));
				//��˾����
				//��ȡ��˾id
				relationVo.setCid(rs.getInt("c_id"));
					String sql2="select * from relation  where c_id like  ?";
					PreparedStatement st2 = conn.prepareStatement(sql2);
					st2.setInt(1, rs.getInt("c_id"));
					ResultSet rs2= st2.executeQuery();
					while(rs2.next()){
						//��˾�µ����и�λ
						relationVo.setPid(rs2.getInt("p_id"));
						relationVo.setRask(rs2.getString("r_ask"));
						relationVo.setRpost(rs2.getString("r_post"));
						relationVo.setRsalary(rs2.getDouble("r_salary"));
						relationVo.setRtimes(rs2.getDate("r_times"));
						//Ͷ��״̬
						String sql3 = "select d_status from delivery where p_id=? and r_id in (select r_id from resume where u_id=?)";
						PreparedStatement st3 = conn.prepareStatement(sql3);
						st3.setInt(1, rs2.getInt("p_id"));
						st3.setInt(2, uid);
						ResultSet rs3 = st3.executeQuery();
						if(rs3.next()){
							relationVo.setDstatus(rs3.getInt("d_status"));
						}
						
					}
					
				   list.add(relationVo);
			}
		}
		
		return list;
		
	}
	
	//����pid�鵽����rid����ҵ�յ��ļ�����
	public List<Integer> selectAllRidByUid(int pid) throws Exception{
		List<Integer> ridList=new ArrayList<Integer>();
		openConnection();
		String sql="select r_id from delivery where p_id=? and d_status=1";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, pid);
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			ridList.add(rs.getInt("r_id"));
		}
		rs.close();
		st.close();
		return ridList;
		
	}
	
	//��ѯ��ҵ��������Ϣ
	public List<Company> selectComList() throws Exception{
		
		List<Company> list = new ArrayList<Company>();
		Company com = null;
		openConnection();
		String sql="select * from companyinformation ";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			com = new Company();
			com.setCid(rs.getInt("c_id"));
			com.setUid(rs.getInt("u_id"));
			com.setCname(rs.getString("c_name"));
			com.setCaddress(rs.getString("c_address"));
			com.setCphone(rs.getString("c_phone"));
			com.setCintroduce(rs.getString("c_introduce"));
		}
		rs.close();
		st.close();
		return list;
	}
	
	//����cid��ѯ��˾��Ϣ
	public Company selectCompanyInfoByCid(int cid) throws Exception {
		Company com= null;
		openConnection();
		String sql="select * from companyinformation where c_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, cid);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			com = new Company();
			com.setCid(rs.getInt("c_id"));
			com.setUid(rs.getInt("u_id"));
			com.setCname(rs.getString("c_name"));
			com.setCaddress(rs.getString("c_address"));
			com.setCphone(rs.getString("c_phone"));
			com.setCintroduce(rs.getString("c_introduce"));
		}
		rs.close();
		st.close();
		return com;
	}
	
	// ����pid��ȡְλ��Ϣ
	public Relation selectPostInfoByCidAndRpost(int pid) throws Exception{
		Relation relation=null;
		openConnection();
		String sql="select * from relation where p_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, pid);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			relation=new Relation();
			relation.setPid(pid);
			relation.setCid(rs.getInt("c_id"));
			relation.setRpost(rs.getString("r_post"));
			relation.setRask(rs.getString("r_ask"));
			relation.setRsalary(rs.getDouble("r_salary"));
			relation.setRtimes(rs.getDate("r_times"));
		}
		rs.close();
		st.close();
		return relation;
	}
	
	//����cid��Ӹ�λ
	public void addPost(int cid, String rpost, String rask,double rsalary, String rtimes) throws Exception {
		openConnection();
		String sql="insert into relation(c_id,r_post,r_ask,r_salary,r_times) values(?,?,?,?,?);";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, cid);
		st.setString(2, rpost);
		st.setString(3, rask);
		st.setDouble(4, rsalary);
		st.setString(5, rtimes);
		st.execute();
		st.close();
	}
	
	//����pidɾ��ָ����λ��Ϣ
	public void delPostByCidAndRpost(int pid) throws Exception {
		openConnection();
		String sql="delete from relation where p_id=?";
		String sql2="delete from delivery where p_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		PreparedStatement st2 = conn.prepareStatement(sql2);
		st.setInt(1,pid);
		st2.setInt(1,pid);
		st.execute();
		st2.execute();
		st.close();
		st2.close();
	}
	
	//����uid��ѯ��cid
	public int selectCidByUid(int uid) throws Exception {
		int cid=0;
		openConnection();
		String sql="select c_id from companyinformation where u_id=?";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1, uid);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			cid=rs.getInt("c_id");
		}
		rs.close();
		st.close();
		return cid;
	}
	
	//����cid ��ѯ��˾�����ĸ�λ��Ϣ
	public List<Relation> comPostList(int cid) throws Exception{
		List<Relation> list = new ArrayList<Relation>();
		Relation rel=null;
		openConnection();
		String sql="select * from relation where c_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, cid);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			rel=new Relation();
			rel.setPid(rs.getInt("p_id"));
			rel.setCid(rs.getInt("c_id"));
			rel.setRpost(rs.getString("r_post"));
			rel.setRask(rs.getString("r_ask"));
			rel.setRsalary(rs.getDouble("r_salary"));
			rel.setRtimes(rs.getDate("r_times"));
			list.add(rel);
			
		}
		return list;
		
	}
	
	//�޸���ҵ�Ļ�����Ϣ
	public void updateCompanyInfo(int uid, String cname, String caddress,String cintroduce, String cphone) throws Exception {
			openConnection();
			//�����û�id��ѯ��ҵ��Ϣ
			// ����SQL���
			String sql1 = "select * from companyinformation where u_id=?";
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setInt(1, uid);
			// ��ȡ�����
			ResultSet rs = st.executeQuery();
			// ��������
			// �����Ϣû�иı������κβ���
			// �����Ϣ�����ı���������ݿ�
			while(rs.next()){
				//�жϹ�˾���Ƿ񱻸���
				if(cname.equals(rs.getString("c_name"))){
					//û�и��¹�˾������������
				}else{
					//���¹�˾����
					String sql2="update companyinformation set c_name=? where u_id=? ";
					 st=conn.prepareStatement(sql2);
					 st.setString(1, cname);
					 st.setInt(2, uid);
					 st.execute();
				}
				//�жϹ�˾��ַ�Ƿ񱻸���
				if(caddress.equals(rs.getString("c_address"))){
					//û�и��¹�˾��ַ����������
				}else{
					//���¹�˾��ַ
					String sql2="update companyinformation set c_address=? where u_id=? ";
					 st=conn.prepareStatement(sql2);
					 st.setString(1, caddress);
					 st.setInt(2, uid);
					 st.execute();
				}
				//�жϹ�˾�����Ƿ񱻸���
				if(cintroduce.equals(rs.getString("c_introduce"))){
					//û�и��¹�˾���ܣ���������
				}else{
					//���¹�˾����
					String sql2="update companyinformation set c_introduce=? where u_id=? ";
					 st=conn.prepareStatement(sql2);
					 st.setString(1, cintroduce);
					 st.setInt(2, uid);
					 st.execute();
				}
				//�жϹ�˾�绰�Ƿ񱻸���
				if(cphone.equals(rs.getString("c_phone"))){
					//û�и��¹�˾�绰����������
				}else{
					//���¹�˾�绰
					String sql2="update companyinformation set c_phone=? where u_id=? ";
					 st=conn.prepareStatement(sql2);
					 st.setString(1, cphone);
					 st.setInt(2, uid);
					 st.execute();
				}
				
			}
			rs.close();
			st.close();
		    
		}

	//�����ҵ��Ϣ
	public void addCompany( int uid, String cname, String caddress,
			String cintroduce, String cphone) throws Exception {
		openConnection();
		String sql="insert into companyinformation(u_id,c_name,c_address,c_introduce,c_phone) values(?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1, uid);
		st.setString(2, cname);
		st.setString(3, caddress);
		st.setString(4, cintroduce);
		st.setString(5, cphone);
		st.execute();
		st.close();
	}

	 //����uid��ѯ��ҵ��Ϣ
	 public Company selectCompanyInfoByUid(int uid) throws Exception {
		Company com = null;
		openConnection();
		String sql="select * from companyinformation where u_id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, uid);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			com = new Company();
			com.setCid(rs.getInt("c_id"));
			com.setUid(rs.getInt("u_id"));
			com.setCname(rs.getString("c_name"));
			com.setCaddress(rs.getString("c_address"));
			com.setCphone(rs.getString("c_phone"));
			com.setCintroduce(rs.getString("c_introduce"));
		}
		rs.close();
		st.close();
		return com;
		
	}
	 
	 //��ѯ��Ͷ�ݹ���������ҷ��͹�����Ĺ�˾
	 public List<RelationVo> selectComAboutMe(int rid) throws Exception{
		 RelationVo relationVo=null;
		 List<RelationVo> list = new ArrayList<RelationVo>();
		 openConnection();
		 String sql="select * from delivery where r_id=?";
		 PreparedStatement st = conn.prepareStatement(sql);   
		 st.setInt(1, rid);
		 ResultSet rs= st.executeQuery();
		 //��ȡ��pid��dstatus
		 while(rs.next()){
			 relationVo = new RelationVo();
			 relationVo.setPid(rs.getInt("p_id"));
			 relationVo.setDstatus(rs.getInt("d_status"));
			 //��λ��Ϣ
			 String sql2="select * from relation where p_id=?";
			 PreparedStatement st2 = conn.prepareStatement(sql2);
			 st2.setInt(1, rs.getInt("p_id"));
			 ResultSet rs2= st2.executeQuery();
			 if(rs2.next()){
				 relationVo.setCid(rs2.getInt("c_id"));
				 relationVo.setRask(rs2.getString("r_ask"));
				 relationVo.setRpost(rs2.getString("r_post"));
				 relationVo.setRsalary(rs2.getDouble("r_salary"));
				 relationVo.setRtimes(rs2.getDate("r_times"));
			 }
		   //��˾����
			String sql3 = "select c_name from companyinformation where c_id=?";
			PreparedStatement st3 = conn.prepareStatement(sql3);
			st3.setInt(1, rs2.getInt("c_id"));
			ResultSet rs3 = st3.executeQuery();
			if(rs3.next()){
				relationVo.setCname(rs3.getString("c_name"));
			}
			rs3.close();
			st3.close();
			 list.add(relationVo);
		 }
		 rs.close();
		 st.close();
		 return list;
	 }
	 
	 //����нˮ����������ҵ��Ƹ��Ϣ
	public List<RelationVo> selectCompanyBySalary(int uid) throws Exception {
		RelationVo relationVo=null;
		List<RelationVo> list = new ArrayList<RelationVo>();
		openConnection();
		String sql="select * from relation order by r_salary desc limit 5";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			relationVo = new RelationVo();
			relationVo.setPid(rs.getInt("p_id"));
			relationVo.setCid(rs.getInt("c_id"));
			relationVo.setRask(rs.getString("r_ask"));
			relationVo.setRpost(rs.getString("r_post"));
			relationVo.setRsalary(rs.getDouble("r_salary"));
			relationVo.setRtimes(rs.getDate("r_times"));
			
			//��˾����
			String sql2 = "select c_name from companyinformation where c_id=?";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setInt(1, rs.getInt("c_id"));
			ResultSet rs2 = st2.executeQuery();
			if(rs2.next()){
				relationVo.setCname(rs2.getString("c_name"));
			}
			rs2.close();
			st2.close();
			//��˾����
			
			//Ͷ��״̬
			String sql3 = "select d_status from delivery where p_id=? and r_id in (select r_id from resume where u_id=?)";
			PreparedStatement st3 = conn.prepareStatement(sql3);
			st3.setInt(1, rs.getInt("p_id"));
			st3.setInt(2, uid);
			ResultSet rs3 = st3.executeQuery();
			if(rs3.next()){
				relationVo.setDstatus(rs3.getInt("d_status"));
			}
			rs3.close();
			st3.close();
			//Ͷ��״̬
			
			list.add(relationVo);
		}
		return list;
	}
	
    //���ݷ���ʱ���¾�������ҵ��Ƹ��Ϣ
	public List<RelationVo> selectCompanyByTime(int uid) throws Exception {
		RelationVo relationVo=null;
		List<RelationVo> list = new ArrayList<RelationVo>();
		openConnection();
		String sql="select * from relation order by r_times desc limit 5";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			relationVo = new RelationVo();
			relationVo.setPid(rs.getInt("p_id"));
			relationVo.setCid(rs.getInt("c_id"));
			relationVo.setRask(rs.getString("r_ask"));
			relationVo.setRpost(rs.getString("r_post"));
			relationVo.setRsalary(rs.getDouble("r_salary"));
			relationVo.setRtimes(rs.getDate("r_times"));
			//��˾����
			String sql2 = "select c_name from companyinformation where c_id=?";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setInt(1, rs.getInt("c_id"));
			ResultSet rs2 = st2.executeQuery();
			if(rs2.next()){
				relationVo.setCname(rs2.getString("c_name"));
			}
			rs2.close();
			st2.close();
			//��˾����
			
			//Ͷ��״̬
			String sql3 = "select d_status from delivery where p_id=? and r_id in (select r_id from resume where u_id=?)";
			PreparedStatement st3 = conn.prepareStatement(sql3);
			st3.setInt(1, rs.getInt("p_id"));
			st3.setInt(2, uid);
			ResultSet rs3 = st3.executeQuery();
			if(rs3.next()){
				relationVo.setDstatus(rs3.getInt("d_status"));
			}
			rs3.close();
			st3.close();
			//Ͷ��״̬
			
			list.add(relationVo);
		}
		return list;
	}
   
	//��ҳ��ѯ���ݿ������й�˾��Ƹ��relation����Ϣ
	public List<RelationVo> pageGetCompanyInfo(int beginPage, int max,int uid) throws Exception {
		List<RelationVo> list=new ArrayList<RelationVo>();
		RelationVo relationVo=null;
		 openConnection();
         String sql="select * from relation r limit ?,?";
         PreparedStatement st=conn.prepareStatement(sql);
         st.setInt(1,beginPage);
         st.setInt(2, max);
         ResultSet rs=st.executeQuery();
         while(rs.next()){
        	 relationVo = new RelationVo();
        	 relationVo.setPid(rs.getInt("p_id"));
        	 relationVo.setCid(rs.getInt("c_id"));
        	 relationVo.setRask(rs.getString("r_ask"));
        	 relationVo.setRpost(rs.getString("r_post"));
        	 relationVo.setRsalary(rs.getDouble("r_salary"));
        	 relationVo.setRtimes(rs.getDate("r_times"));
 			//��˾����
			String sql2 = "select c_name from companyinformation where c_id=?";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setInt(1, rs.getInt("c_id"));
			ResultSet rs2 = st2.executeQuery();
			if(rs2.next()){
				relationVo.setCname(rs2.getString("c_name"));
			}
			rs2.close();
			st2.close();
			//��˾����
			//Ͷ��״̬
			String sql3 = "select d_status from delivery where p_id=? and r_id in (select r_id from resume where u_id=?)";
			PreparedStatement st3 = conn.prepareStatement(sql3);
			st3.setInt(1, rs.getInt("p_id"));
			st3.setInt(2, uid);
			ResultSet rs3 = st3.executeQuery();
			if(rs3.next()){
				relationVo.setDstatus(rs3.getInt("d_status"));
			}
			rs3.close();
			st3.close();
			//Ͷ��״̬
			list.add(relationVo);
 			
         }
		rs.close();
		st.close();
		return list;
	}
	
	//��ѯ��Ƹ��Ϣ��������
	public int selectCountRelation() throws Exception {
			int count=0;
			openConnection();
			String sql="select count(*) from relation";
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
