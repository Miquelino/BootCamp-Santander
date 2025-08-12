package service;

import dao.BasicBasketDAO;
import dao.model.StockInfo;
import dio.BasicBasket;
import dio.Box;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Stream;

public class BasicBasketService {

    private final BasicBasketDAO dao;
    private MoneyService moneyService;

    public BasicBasketService(BasicBasketDAO dao) {
        this.dao = dao;
    }

    public List<BasicBasket> receive(final Box box){
        var uniAmount = box.unitPrice();
        var finalPrice = uniAmount.add(uniAmount.multiply(new BigDecimal("0.20")));
        var baskets = Stream.generate(() -> new BasicBasket(box.validate(), finalPrice))
                .limit(box.amount())
                .toList();
        return dao.addBatch(baskets);
    }

    public BigDecimal sold(final int amount){
        var toSold = dao.remove(amount);
        var total = toSold.stream().map(BasicBasket::price).reduce(BigDecimal.ZERO, BigDecimal::add);
        moneyService.add(total);
        return total;
    }

    public StockInfo getInfo(){
        return dao.getInfo();
    }


    public List<BasicBasket> removeOutOfDate(){
        var outOfDate = dao.removeOutOfDate();
        var total = outOfDate.stream().map(BasicBasket::price).reduce(BigDecimal.ZERO, BigDecimal::add);
        moneyService.dec(total);
        return outOfDate;
    }
}
