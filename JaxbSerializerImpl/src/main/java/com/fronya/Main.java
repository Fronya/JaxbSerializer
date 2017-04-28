package com.fronya;


import com.fronya.model.Product;
import com.fronya.model.ProductType;
import com.fronya.model.Products;
import com.fronya.tools.Marshaling;
import com.fronya.tools.Unmarshalling;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        if(args.length < 2){
            System.err.println("Need in and out files");
            return;
        }

        String nameInputFile = args[0];
        Unmarshalling unmarshalling = new Unmarshalling(nameInputFile);
        Products products = unmarshalling.getProducts();
        showProducts(products);

        Product changeProduct = products.getProduct().get(0);
        changeProduct.setName("book 111 111");
        changeProduct.setPrice(new BigInteger(String.valueOf(25)));
        changeProduct.setDescription("222222");
        changeProduct.setAmount(new BigInteger(String.valueOf(123456)));
        changeProduct.setProductType(ProductType.UNSOUGHT);

        String nameOutputFile = args[1];
        Marshaling marshaling = new Marshaling(nameOutputFile);
        if(marshaling.toFile(products)){
            System.out.println("xml create");
        }else {
            System.out.println("error");
        }
    }

    private static void showProducts(Products products){
        for (Product p: products.getProduct()) {
            System.out.println(p.getName() + " " + p.getPrice() + " " + p.getAmount() + " "
                    + p.getDescription() + " " + p.getProductType());
        }
    }
}
