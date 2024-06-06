package project.shoppingmall.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import project.shoppingmall.domain.entity.Product;

import java.util.List;

@Repository
public class DatabaseProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DatabaseProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public Product add(Product product){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);

        namedParameterJdbcTemplate.update("INSERT INTO products (productName, productPrice, productAmount) values (:productName, :productPrice, :productAmount)",
                namedParameter, keyHolder);

        Long GeneratedId = keyHolder.getKey().longValue();
        //product.setId(GeneratedId);

        return product;
    }

    public Product findById(Long id){
        return null;
    }

    public List<Product> findAll(){
        return null;
    }

    public List<Product> findByName(String name){
        return null;
    }

    public Product update(Product product){
        return null;
    }

    public void delete(Long id){

    }
}
