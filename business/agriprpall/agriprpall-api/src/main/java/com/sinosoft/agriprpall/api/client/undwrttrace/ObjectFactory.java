
package com.sinosoft.agriprpall.api.client.undwrttrace;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sinosoft.demo.core.webservice package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sinosoft.demo.core.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfXsdAnyType }
     * 
     */
    public ArrayOfXsdAnyType createArrayOfXsdAnyType() {
        return new ArrayOfXsdAnyType();
    }

    /**
     * Create an instance of {@link GetTraceInfoList }
     * 
     */
    public GetTraceInfoList createGetTraceInfoList() {
        return new GetTraceInfoList();
    }

    /**
     * Create an instance of {@link QueryUndwrtTraceInfoResponse }
     * 
     */
    public QueryUndwrtTraceInfoResponse createQueryUndwrtTraceInfoResponse() {
        return new QueryUndwrtTraceInfoResponse();
    }

    /**
     * Create an instance of {@link GetTraceInfoListResponse }
     * 
     */
    public GetTraceInfoListResponse createGetTraceInfoListResponse() {
        return new GetTraceInfoListResponse();
    }

    /**
     * Create an instance of {@link QueryUndwrtTraceInfo }
     * 
     */
    public QueryUndwrtTraceInfo createQueryUndwrtTraceInfo() {
        return new QueryUndwrtTraceInfo();
    }

}
