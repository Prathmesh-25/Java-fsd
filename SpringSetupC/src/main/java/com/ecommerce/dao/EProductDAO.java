package com.ecommerce.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.ecommerce.entity.EProduct;   

public class EProductDAO {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {    
        this.template = template;    
    }    

    public List<EProduct> getProducts(){    
        return template.query("select * from eproduct", new RowMapper<EProduct>(){    
            public EProduct mapRow(ResultSet rs, int row) throws SQLException {    
                EProduct e = new EProduct();    
                e.setID(rs.getInt("id"));    
                e.setName(rs.getString("name"));    
                e.setPrice(rs.getBigDecimal("price"));    
                e.setDateAdded(rs.getDate("date_added"));    
                return e;    
            }    
        });    
    }    
}
