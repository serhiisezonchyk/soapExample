//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.08 at 12:40:10 AM EET 
//


package com.sergey6ljava.car;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sergey6ljava.car package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sergey6ljava.car
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCarByIdResponse }
     * 
     */
    public GetCarByIdResponse createGetCarByIdResponse() {
        return new GetCarByIdResponse();
    }

    /**
     * Create an instance of {@link CarInfo }
     * 
     */
    public CarInfo createCarInfo() {
        return new CarInfo();
    }

    /**
     * Create an instance of {@link AddCarResponse }
     * 
     */
    public AddCarResponse createAddCarResponse() {
        return new AddCarResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link GetCarByIdRequest }
     * 
     */
    public GetCarByIdRequest createGetCarByIdRequest() {
        return new GetCarByIdRequest();
    }

    /**
     * Create an instance of {@link GetAllCarsRequest }
     * 
     */
    public GetAllCarsRequest createGetAllCarsRequest() {
        return new GetAllCarsRequest();
    }

    /**
     * Create an instance of {@link AddCarRequest }
     * 
     */
    public AddCarRequest createAddCarRequest() {
        return new AddCarRequest();
    }

    /**
     * Create an instance of {@link UpdateCarRequest }
     * 
     */
    public UpdateCarRequest createUpdateCarRequest() {
        return new UpdateCarRequest();
    }

    /**
     * Create an instance of {@link GetAllCarsResponse }
     * 
     */
    public GetAllCarsResponse createGetAllCarsResponse() {
        return new GetAllCarsResponse();
    }

    /**
     * Create an instance of {@link UpdateCarResponse }
     * 
     */
    public UpdateCarResponse createUpdateCarResponse() {
        return new UpdateCarResponse();
    }

    /**
     * Create an instance of {@link DeleteCarRequest }
     * 
     */
    public DeleteCarRequest createDeleteCarRequest() {
        return new DeleteCarRequest();
    }

    /**
     * Create an instance of {@link DeleteCarResponse }
     * 
     */
    public DeleteCarResponse createDeleteCarResponse() {
        return new DeleteCarResponse();
    }

}