package com.yedam.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.product.service.ProductService;
import com.yedam.product.vo.ProductVO;

public class ProductserviceImpl extends DAO implements ProductService {
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	// cart 정보 추가하는 메소드 
	public void addCart(String id, String item, int qty) {
		sql="insert into cart values(?,?,?)";
		
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, item);
			psmt.setInt(3, qty);
			int r = psmt.executeUpdate();
			System.out.println(r+"건이 정상적으로 저장되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	} 
	
	// 회원별 장바구니 상품 갯수 
	public int getCountCart(String id) {
		sql ="select count(*) cnt from cart where user_id=?";
		int rCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				rCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return rCnt;
	}
	
	@Override
	public List<ProductVO> ProductSelectList() {
		// 전체조회
		sql ="select * from product order by 1";
		List<ProductVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	

	@Override
	public ProductVO ProductSelect(ProductVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<ProductVO> CartSelect(ProductVO vo) {
		sql = "select c.ITEM_CODE,c.ITEM_QTY, p.ITEM_DESC, p.ITEM_NAME,p.ITEM_IMAGE\r\n"
				+ "from cart c, PRODUCT p \r\n"
				+ "where user_id=? and c.ITEM_CODE = p.ITEM_CODE";
		
		List<ProductVO> list = new ArrayList<>();

		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemQty(rs.getInt("item_qty"));
				vo.setItemName(rs.getString("item_name"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemDesc(rs.getString("item_Desc"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		// 삽입
		return 0;
	}

	@Override
	public int updateProduct(ProductVO vo) {
		// 수정
		return 0;
	}

	@Override
	public int deleteProduct(ProductVO vo) {
		// 삭제
		return 0;
	}
	
	private void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	

}
