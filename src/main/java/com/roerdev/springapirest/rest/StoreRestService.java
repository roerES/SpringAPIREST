package com.roerdev.springapirest.rest;

import com.roerdev.springapirest.model.InventoryProduct;
import com.roerdev.springapirest.model.Store;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreRestService {

    Logger logger = LoggerFactory.getLogger(StoreRestService.class);

    @Autowired
    private Store store;

    @Operation(summary = "Welcome", description = "Welcome to Spring Store Demo", tags = {"StoreRestService"})
    @GetMapping("/welcome")
    public @ResponseBody String welcome() {
        logger.debug("Rest service: /welcome");

        return "***** WELCOME TO SPRING STORE DEMO *****";
    }

    @Operation(summary = "AllProducts", description = "Return All Products", tags = {"StoreRestService"})
    @GetMapping("/allProducts")
    public ResponseEntity<List<InventoryProduct>> getAllProducts() {
        List<InventoryProduct> list = store.getProductList();

        return Optional.ofNullable(list).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "SaveProduct", description = "Save a product", tags = {"StoreRestService"})
    @PutMapping("/saveProduct")
    public void saveProduct(@RequestBody InventoryProduct bean) {
        logger.info("Save Product: " + bean);
        store.addProduct(bean);
    }

    @Operation(summary = "SaveProduct", description = "Save a product", tags = {"StoreRestService"})
    @PutMapping("/saveAllProduct")
    public void saveAllProduct(@RequestBody List<InventoryProduct> bean) {
        logger.info("Save Product: " + bean);
        store.addAllProduct(bean);
    }
}
