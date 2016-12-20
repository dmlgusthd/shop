package goods.service;

import java.sql.*;
import java.util.ArrayList;

public class GoodsDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int resultRow = 0;
	
	//상품리스트
	public ArrayList<Goods> List(int currentPage,int pagePerRow){
		ArrayList<Goods> arr = new ArrayList<Goods>();
		conn=Dao.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from goods");
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getRow()+"<--가져온 수");
				Goods g = new Goods();
				g.setgCode(rs.getInt("g_code"));
				g.setgName(rs.getString("g_name"));
				g.setgPrice(rs.getInt("g_price"));
				g.setgStock(rs.getInt("g_stock"));
				g.setgColor(rs.getString("g_color"));
				g.setgCategory(rs.getString("g_category"));
				g.setgImgsrc(rs.getString("g_img"));
				g.setgThumb(rs.getString("g_thumb"));
				arr.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	//전체행의수
	public int totalRow(){
		int totalRow = 0;
		conn=Dao.getConnection();
		try {
			pstmt=conn.prepareStatement("select COUNT(*) from goods");
			rs=pstmt.executeQuery();
			totalRow=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dao.close(rs, pstmt, conn);
		}

		return totalRow;
	}
	//상품등록
	public int addGoods(Goods g){
		conn = Dao.getConnection();
		try {
			pstmt = conn.prepareStatement("INSERT INTO goods(g_name,g_price,g_stock,g_color,g_category,g_img,g_thumb) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, g.getgName());
			pstmt.setInt(2,g.getgPrice());
			pstmt.setInt(3,g.getgStock());
			pstmt.setString(4, g.getgColor());
			pstmt.setString(5, g.getgCategory());
			pstmt.setString(6, g.getgImgsrc());
			pstmt.setString(7, g.getgThumb());
			
			resultRow = pstmt.executeUpdate();
			System.out.println("입력성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dao.close(rs, pstmt, conn);
		}
		
		
		return resultRow;	
	}
	

}
