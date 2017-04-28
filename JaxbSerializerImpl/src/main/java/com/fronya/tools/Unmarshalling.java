package com.fronya.tools;


import com.fronya.model.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Unmarshalling {
    private String nameFile;

    public Unmarshalling(String nameFile) {
        this.nameFile = nameFile;
    }

    public Products getProducts(){
        Products products = null;
        try{
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(nameFile);
            products = (Products) unmarshaller.unmarshal(fileReader);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
