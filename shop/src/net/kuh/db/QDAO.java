package net.kuh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.member.db.Member;

public class QDAO {
	private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/watch?useUnicode=true&characterEncoding=euckr";
    private final String username = "root";
    private final String password = "java0000";
    Connection connection = null;
    PreparedStatement statement = null;
    



private Connection getConnection() {
    try {
        Class.forName(this.driverClassName);
        connection = DriverManager.getConnection(this.url, this.username, this.password);
    } catch(Exception e) {
        e.printStackTrace();
    }
    return connection;
}

private void close(Connection connection, Statement statement, ResultSet resultset) {
    if(resultset != null) {
        try {
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if(statement != null) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if(connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


public int selectTotalBoardCount() {
    int rowCount = 0;
    ResultSet resultset = null;
    String sql = "SELECT COUNT(*) FROM qna";
    try {
        connection = this.getConnection();
        statement = connection.prepareStatement(sql);
        resultset = statement.executeQuery();
        if(resultset.next()) {
            rowCount = resultset.getInt(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.close(connection, statement, resultset);
    }
    return rowCount;
}

	public int updateQna(QnaDTO dto) {
		System.out.println("updateQna 메서드 실행");
	    int rowCount = 0;
	    String sql = "UPDATE qna SET q_category=?, q_title=?, q_detail=? WHERE q_num=?";
	    try {
	        connection = this.getConnection();
	        System.out.println("DB 연결됨");
	        statement = connection.prepareStatement(sql);
	        statement.setString(1,dto.getQ_category());
	        statement.setString(2,dto.getQ_title());
	        statement.setString(3,dto.getQ_detail());
	        statement.setInt(4,dto.getQ_num());
	        rowCount = statement.executeUpdate();
	        System.out.println("여기까지");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        this.close(connection, statement, null);
	    }
	    return rowCount;
	}

public QnaDTO QnAViewDao(int q_num) {
    System.out.println("QnAViewDao 메서드 실행");
	QnaDTO qnadto = null;
    ResultSet resultset = null;
    String sql = "SELECT q_category, q_title, q_detail FROM qna WHERE q_num=?";
    try {
        connection = this.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, q_num);
        resultset = statement.executeQuery();
        if(resultset.next()) {
        	qnadto = new QnaDTO();
        	qnadto.setQ_num(q_num);
        	qnadto.setQ_category(resultset.getString("q_category"));
        	qnadto.setQ_title(resultset.getString("q_title"));
        	qnadto.setQ_detail(resultset.getString("q_detail"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.close(connection, statement, resultset);
    }
    return qnadto;
}

public int insertQna(QnaDTO qnadto) {
	System.out.println("insertQna DAO");
    int rowCount = 0;
    String sql = "INSERT INTO qna(q_category, q_title, q_detail, m_name, q_date) values(?,?,?,?,now())";
    try {
        connection = this.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1,qnadto.getQ_category());
        statement.setString(2,qnadto.getQ_title());
        statement.setString(3,qnadto.getQ_detail());
        statement.setString(4,qnadto.getM_name());
        rowCount = statement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.close(connection, statement, null);
    }
    return rowCount;
}

public Member selectMname(String m_id){
	System.out.println("selectMname 메서드 실행");
	Member member = null;
	ResultSet rs = null;
	String sql = "SELECT m_name FROM member WHERE m_id=?";
	try{
		connection = this.getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, m_id);
		rs = statement.executeQuery();
		if(rs.next()){
			member = new Member();
			member.setM_id(m_id);
			member.setM_name(rs.getString("m_name"));
		}
	}catch (Exception e){
		e.printStackTrace();
	}finally{
		this.close(connection, statement, rs);
	}
	return member;
}



public List<QnaDTO> selectQnaListPerPage(int beginRow, int pagePerRow) {
	System.out.println("selectQnaListPerPage 메서드 실행");
	List<QnaDTO> list = new ArrayList<QnaDTO>();
    ResultSet resultset = null;
    String sql = "SELECT q_num, q_category, q_title, m_name, q_date FROM qna ORDER BY q_num DESC LIMIT ?, ?";
    try {
        connection = this.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, beginRow);
        statement.setInt(2, pagePerRow);
        System.out.println("stmt is " + statement);
        resultset = statement.executeQuery();
        while(resultset.next()) {
        	QnaDTO qnadto = new QnaDTO();
        	qnadto.setQ_num(resultset.getInt("q_num"));
        	qnadto.setQ_category(resultset.getString("q_category"));
        	qnadto.setQ_title(resultset.getString("q_title"));
        	qnadto.setM_name(resultset.getString("m_name"));        	
        	qnadto.setQ_date(resultset.getString("q_date"));
        	
            list.add(qnadto);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.close(connection, statement, resultset);
    }
    return list;
}

}