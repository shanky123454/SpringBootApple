package com.connectionpool.jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSet.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class rowset {

	public static void main(String[] args) {
		
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			JdbcRowSet jrs= rfs.createJdbcRowSet();
			CachedRowSet crs = rfs.createCachedRowSet();
			WebRowSet wrs = rfs.createWebRowSet();
			FilteredRowSet frs = rfs.createFilteredRowSet();
			JoinRowSet jnrs = rfs.createJoinRowSet();
			
			
			System.out.println("==================================");
			
			
			System.out.println(jrs.getClass().getName());
			System.out.println(crs.getClass().getName());
			System.out.println(wrs.getClass().getName());
			System.out.println(frs.getClass().getName());
			System.out.println(jnrs.getClass().getName());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
