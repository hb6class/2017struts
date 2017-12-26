package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import com.hb.model.entity.GuestVo;

public class GuestDaoImpl implements GuestDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int maxSabun() throws SQLException{
		String sql="select max(sabun) as x from guest02";
		GuestVo bean = new GuestVo();
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("1");
			ResultSet rs= pstmt.executeQuery();
			System.out.println("2");
			if(rs.next()){
				return rs.getInt("x");
			}
		}
		return 0;
	}

	@Override
	public List<GuestVo> selectAll() throws Exception {
		String sql="SELECT * FROM GUEST02";
		List<GuestVo> list = new ArrayList<GuestVo>();
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(rs.getInt("sabun")
						, rs.getString("name")
						, rs.getTimestamp("nalja")
						, rs.getInt("pay")));
			}
		}
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws Exception {
		String sql="select * from guest02 where sabun=?";
		GuestVo bean = new GuestVo();
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			System.out.println("1");
			ResultSet rs= pstmt.executeQuery();
			System.out.println("2");
			if(rs.next()){
				System.out.println("3");
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getTimestamp("nalja"));
				bean.setPay(rs.getInt("pay"));
				System.out.println(bean);
			}
		}
		return bean;
	}

	@Override
	public void insertOne(GuestVo bean) throws Exception {
		String sql="insert into guest02 (name,nalja,pay) values (?,now(),?)";
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.executeUpdate();
		}

	}

	@Override
	public int updateOne(GuestVo bean) throws Exception {
		int result=0;
		String sql="update guest02 set name=?,pay=? where sabun=?";
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			result=pstmt.executeUpdate();
		}
		return result;
	}

	@Override
	public int deleteOne(int sabun) throws Exception {
		String sql="delete from guest02 where sabun=?";
		int result=0;
		
		try(Connection conn=dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			result=pstmt.executeUpdate();
		}
		return result;
	}

}















