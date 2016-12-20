package net.member.db;

import java.sql.*;
import java.util.ArrayList;
public class MemberDAO {
	private final String driverClassName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3306/watch?useUnicode=true&characterEncoding=euckr";
	private final String username = "root";
	private final String password = "java0000";
	
	Connection conn= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Member member;
	int memberCount = 0;
	
	//ȸ�� ���� �޼���
	public int deleteMember(String m_id, String m_pw){
		System.out.println("06 deleteMember �޼��� ����");
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("DELETE FROM member WHERE m_id = ? AND m_pw = ?");
				stmt.setString(1, m_id);
				stmt.setString(2, m_pw);
				memberCount = stmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, null);
			}
		System.out.println("----------- deleteMember �޼��� �Ϸ�------------");
		return memberCount;
	}
	
	//ȸ�� �α��� �޼���
	public Member loginMember(String m_id){
		System.out.println("06 loginMember �޼��� ����");
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("SELECT m_pw,m_level FROM MEMBER WHERE m_id = ?");
				stmt.setString(1, m_id);
				rs = stmt.executeQuery();
				if(rs.next()){
					member = new Member();
					member.setM_id(m_id);
					member.setM_level(rs.getString("m_level"));
					member.setM_pw(rs.getString("m_pw"));
				}else{
					//���̵����
					return null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
		System.out.println("----------- loginMember �޼��� �Ϸ�------------");
		return member;
	}
	
	//ȸ�� ���� �޼���
	public int updateMember(Member member){
		System.out.println("05 updateMember �޼��� ����");
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("UPDATE member SET m_pw=?,m_name=?,m_phone=?,m_addr=?");
				stmt.setString(1, member.getM_pw());
				stmt.setString(2, member.getM_name());
				stmt.setString(3, member.getM_phone());
				stmt.setString(4, member.getM_addr());
				memberCount = stmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, null);
			}
		System.out.println("----------- updateMember �޼��� �Ϸ�------------");
		return memberCount;
	}
	
	//ȸ�� ���λ��� �޼���
	public Member detailMember(String m_id){
		System.out.println("04 detailMember �޼��� ����");
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("SELECT m_id, m_pw, m_name, m_phone, m_addr FROM MEMBER WHERE m_id=?");
				stmt.setString(1, m_id);
				rs = stmt.executeQuery();
				if(rs.next()){
					member = new Member();
					member.setM_id(rs.getString("m_id"));
					member.setM_pw(rs.getString("m_pw"));
					member.setM_name(rs.getString("m_name"));
					member.setM_phone(rs.getString("m_phone"));
					member.setM_addr(rs.getString("m_addr"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
		System.out.println("----------- detailMember �޼��� �Ϸ�------------");
		return member;
	}
	
	//ȸ�� ����Ʈ �޼���
	public ArrayList<Member> memberList(){
		System.out.println("03 memberList �޼��� ����");
		ArrayList<Member> memberList = new ArrayList<Member>();
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("SELECT * FROM member");
				rs= stmt.executeQuery();
				while(rs.next()){
					member = new Member();
					member.setM_id(rs.getString("m_id"));
					member.setM_pw(rs.getString("m_pw"));
					member.setM_name(rs.getString("m_name"));
					member.setM_level(rs.getString("m_level"));
					member.setM_phone(rs.getString("m_phone"));
					member.setM_addr(rs.getString("m_addr"));
					memberList.add(member);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
		System.out.println("----------- memberList �޼��� �Ϸ�------------");
		return memberList;
	}
	
	//ȸ������ �޼���
	public int addMember(Member dto){
		System.out.println("02 addMember �޼��� ����");
			try{
				conn = this.getConnection();
				stmt = conn.prepareStatement("INSERT INTO member(m_id,m_pw,m_name,m_phone,m_addr,m_level) VALUES(?,?,?,?,?,?)");
				System.out.println("stmt is" + stmt);
				stmt.setString(1, dto.getM_id());
				stmt.setString(2, dto.getM_pw());
				stmt.setString(3, dto.getM_name());
				stmt.setString(4, dto.getM_phone());
				stmt.setString(5, dto.getM_addr());
				stmt.setString(6, dto.getM_level());
				System.out.println("stmt2 is" + stmt);
				memberCount = stmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, stmt, rs);
			}
		System.out.println("----------- addMember �޼��� �Ϸ�------------");
		return memberCount;
	}
	
	//db���� �޼���
	private Connection getConnection(){	
		System.out.println("01 getConnection �޼��� ����");
		Connection conn = null;
		try{
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(conn + " : DB���Ἲ��!!");
		return conn;
	}
	
	//��ü close �޼���
	private void close(Connection conn, Statement stmt, ResultSet rs)  {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
