package org.example.shopping.dao.impl;

import org.example.shopping.bean.InitShop;
import org.example.shopping.bean.ShopCart;
import org.example.shopping.bean.Shops;
import org.example.shopping.bean.Specification;
import org.example.shopping.dao.ShopDao;
import org.example.shopping.mapper.ShopCartMapper;
import org.example.shopping.mapper.ShopMapper;
import org.example.shopping.mapper.SpecificationMapper;
import org.example.shopping.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {

    private final ShopMapper shopMapper;
    private final SpecificationMapper specificationMapper;
    private final StockMapper stockMapper;
    private final ShopCartMapper shopCartMapper;

    @Autowired
    public ShopDaoImpl(ShopMapper shopMapper, SpecificationMapper specificationMapper, StockMapper stockMapper, ShopCartMapper shopCartMapper) {
        this.shopMapper = shopMapper;
        this.specificationMapper = specificationMapper;
        this.stockMapper = stockMapper;
        this.shopCartMapper = shopCartMapper;
    }

    @Override
    public List<Shops> selectShopList(int cid, int s, int e) {
        return shopMapper.selectShopList(cid, s, e);
    }

    @Override
    public Shops findShopById(int id) {
        return shopMapper.findShopById(id);
    }

    @Override
    public List<Specification> selectInEdition(String id) {
        return specificationMapper.selectInEdition(id);
    }

    @Override
    public InitShop initShopAndEdCr(int did, int eid, int cid){
        return shopMapper.initShopAndEdCr(did, eid, cid);
    }

    @Override
    public int selectStockByEid(Long did, String eid) {
        return stockMapper.selectStockByEid(did, eid);
    }

    @Override
    public Float selectPriceByEid(Long did, String eid) {
        return specificationMapper.selectPriceByEid(did, eid);
    }

    @Override
    public Long selectIdByEid(Long did, String eid) {
        return stockMapper.selectIdByEid(did, eid);
    }

    @Override
    public int insertShopCart(ShopCart shopCart) {
        return shopCartMapper.insertShopCart(shopCart);
    }

    @Override
    public ShopCart isSetShopCart(String username, Long did, Long eid, Long cid, Integer state) {
        return shopCartMapper.isSetShopCart(username, did, eid, cid, state);
    }

    @Override
    public int incShopCartNumber(Float price, int num, Long id) {
        return shopCartMapper.incShopCartNumber(price, num, id);
    }
}
