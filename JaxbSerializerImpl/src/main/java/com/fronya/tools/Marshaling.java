package com.fronya.tools;

import com.fronya.model.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Marshaling {
    private String fileName;

    public Marshaling(String fileName) {
        this.fileName = fileName;
    }

    public boolean toFile(Products products){
        try{
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(products, new FileOutputStream(fileName));
            return true;
        } catch (JAXBException | FileNotFoundException  e) {
            e.printStackTrace();
            return false;
        }
    }
}
