package com.hb.core;

import java.sql.ResultSet;

public interface RowMapper {
	Object mapRow(ResultSet rs) throws Exception;
}
