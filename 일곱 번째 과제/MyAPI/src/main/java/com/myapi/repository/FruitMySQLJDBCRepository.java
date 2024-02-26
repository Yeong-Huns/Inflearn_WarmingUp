package com.myapi.repository;

import com.myapi.dto.fruit.request.SoldFruitInfoRequest;
import com.myapi.dto.fruit.response.SalesAmountResponse;
import com.myapi.entity.FruitInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class FruitMySQLJDBCRepository implements FruitJDBCRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void saveFruitInfo(FruitInfoEntity fruitInfoEntity){
        String sql = "INSERT INTO inflearn.fruit (name, price, stocked_date, sold_out) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, fruitInfoEntity.getName(), fruitInfoEntity.getPrice(), fruitInfoEntity.getStockedDate(), fruitInfoEntity.isSoldOut());
    }
    @Override
    public void soldFruitInfo(SoldFruitInfoRequest soldFruitInfoRequest){ //없는 ID값에 접근하려하면 IllegalArgumentException
        String idCheck = "SELECT sold_out FROM fruit WHERE id=?";
        List<Boolean> isNotExist = jdbcTemplate.query(idCheck, (rs, rowNum)->rs.getBoolean("sold_out"), soldFruitInfoRequest.getId());
        if(isNotExist.isEmpty() || isNotExist.get(0)) throw new IllegalArgumentException("존재하지 않거나 이미 팔린 상품입니다.");
        String sql = "UPDATE inflearn.fruit SET sold_out=1 WHERE id=?";
        jdbcTemplate.update(sql, soldFruitInfoRequest.getId());
    }
    @Override
    public SalesAmountResponse salesAmount(String name){
        String salesAmountsql = "SELECT sum(price) FROM fruit WHERE sold_out = 1 AND name=? GROUP BY name";
        String notSalesAmountsql = "SELECT sum(price) FROM fruit WHERE sold_out = 0 AND name=? GROUP BY name";

        List<Long> salesAmount = jdbcTemplate.query(salesAmountsql, (rs, rowNum)-> rs.getLong("sum(price)"), name);
        List<Long> notsalesAmount = jdbcTemplate.query(notSalesAmountsql, (rs, rowNum)-> rs.getLong("sum(price)"), name);
        if(salesAmount.isEmpty() && notsalesAmount.isEmpty()) throw new IllegalArgumentException("존재하지 않는 과일입니다.");
        long sales = salesAmount.isEmpty()?0:salesAmount.get(0);
        long notsales = notsalesAmount.isEmpty()?0:notsalesAmount.get(0);

        return new SalesAmountResponse(sales, notsales);
    }
}
