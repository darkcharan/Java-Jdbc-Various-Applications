package com.product.query;

public interface QueryConstants {
	
	String INSERT_QUERY="insert into product values(?,?,?,?)";
	String SELECT_QUERY="select * from product";
	String SELECT_SPECIFICQUERY="select * from product where pno=?";
	String SELECT_DELETE="delete product where pno=?";

}
