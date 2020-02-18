package com._root.init;

import org.hibernate.dialect.SQLServer2012Dialect;

public class NewDialect extends SQLServer2012Dialect {
	
	@Override
	public String getTableTypeString() {
        return " CHARSET=utf8";
    }

}
