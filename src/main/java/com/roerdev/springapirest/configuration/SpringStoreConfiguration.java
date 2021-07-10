package com.roerdev.springapirest.configuration;

import com.roerdev.springapirest.model.InventoryProduct;
import com.roerdev.springapirest.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringStoreConfiguration {

    @Bean("ProducList")
    public List<InventoryProduct> getProductList(){
        return new ArrayList<InventoryProduct>();
    }
}
