
package com.sinosoft.agriclaim.core.common.undwrtClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sinosoft.agriclaim.core.common.undwrtClient package. 
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

    private final static QName _Fault_QNAME = new QName("http://server.webservice.indiv.sinosoft.com", "fault");
    private final static QName _ExceptionMessage_QNAME = new QName("http://service.client.sinosoft.com", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sinosoft.agriclaim.core.common.undwrtClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ReCaseSubmit }
     * 
     */
    public ReCaseSubmit createReCaseSubmit() {
        return new ReCaseSubmit();
    }

    /**
     * Create an instance of {@link ClaimPaySubmit }
     * 
     */
    public ClaimPaySubmit createClaimPaySubmit() {
        return new ClaimPaySubmit();
    }

    /**
     * Create an instance of {@link PrepaySubmit }
     * 
     */
    public PrepaySubmit createPrepaySubmit() {
        return new PrepaySubmit();
    }

    /**
     * Create an instance of {@link QueryCommonTraceInfoResponse }
     * 
     */
    public QueryCommonTraceInfoResponse createQueryCommonTraceInfoResponse() {
        return new QueryCommonTraceInfoResponse();
    }

    /**
     * Create an instance of {@link CompensateSubmitResponse }
     * 
     */
    public CompensateSubmitResponse createCompensateSubmitResponse() {
        return new CompensateSubmitResponse();
    }

    /**
     * Create an instance of {@link ReCaseSubmitResponse }
     * 
     */
    public ReCaseSubmitResponse createReCaseSubmitResponse() {
        return new ReCaseSubmitResponse();
    }

    /**
     * Create an instance of {@link QueryCommonTraceInfo }
     * 
     */
    public QueryCommonTraceInfo createQueryCommonTraceInfo() {
        return new QueryCommonTraceInfo();
    }

    /**
     * Create an instance of {@link UnderwriteSubmit }
     * 
     */
    public UnderwriteSubmit createUnderwriteSubmit() {
        return new UnderwriteSubmit();
    }

    /**
     * Create an instance of {@link UnderwriteSubmitResponse }
     * 
     */
    public UnderwriteSubmitResponse createUnderwriteSubmitResponse() {
        return new UnderwriteSubmitResponse();
    }

    /**
     * Create an instance of {@link PrepaySubmitResponse }
     * 
     */
    public PrepaySubmitResponse createPrepaySubmitResponse() {
        return new PrepaySubmitResponse();
    }

    /**
     * Create an instance of {@link ClaimPaySubmitResponse }
     * 
     */
    public ClaimPaySubmitResponse createClaimPaySubmitResponse() {
        return new ClaimPaySubmitResponse();
    }

    /**
     * Create an instance of {@link CompensateSubmit }
     * 
     */
    public CompensateSubmit createCompensateSubmit() {
        return new CompensateSubmit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.indiv.sinosoft.com", name = "fault")
    public JAXBElement<Exception> createFault(Exception value) {
        return new JAXBElement<Exception>(_Fault_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.client.sinosoft.com", name = "message", scope = Exception.class)
    public JAXBElement<String> createExceptionMessage(String value) {
        return new JAXBElement<String>(_ExceptionMessage_QNAME, String.class, Exception.class, value);
    }

}
