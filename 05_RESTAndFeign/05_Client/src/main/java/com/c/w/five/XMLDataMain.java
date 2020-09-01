package com.c.w.five;


import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * @author C
 */
public class XMLDataMain {

    public static void main(String[] args) {

        JAXBContextFactory jaxbContextFactory = new JAXBContextFactory.Builder().build();
        Client client  = Feign.builder()
                .encoder(new JAXBEncoder(jaxbContextFactory))
                .decoder(new JAXBDecoder(jaxbContextFactory))
                .target(Client.class,"http://localhost:8080");
        Client.Result result = client.xmlData();
        System.out.println(result.average);

    }

}
