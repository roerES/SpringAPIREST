package com.roerdev.springapirest.model;

import com.roerdev.springapirest.rest.StoreRestService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@ToString
@Data
@EqualsAndHashCode
@Component
public class Store implements Serializable {

    Logger logger = LoggerFactory.getLogger(StoreRestService.class);

    @Autowired
    private List<InventoryProduct> productList;

    public List<InventoryProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<InventoryProduct> productList) {
        this.productList = productList;
    }

    public void addProduct(InventoryProduct bean){
        productList.add(bean);
    }

    public void addAllProduct(List<InventoryProduct> bean){
        for (InventoryProduct ip: bean) {
            productList.add(ip);
        }
    }
}
