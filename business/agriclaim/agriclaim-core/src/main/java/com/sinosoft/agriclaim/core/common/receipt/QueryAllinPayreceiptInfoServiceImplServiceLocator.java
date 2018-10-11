/**
 * QueryAllinPayreceiptInfoServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.agriclaim.core.common.receipt;

import javax.xml.ws.WebServiceClient;

@WebServiceClient
public class QueryAllinPayreceiptInfoServiceImplServiceLocator extends org.apache.axis.client.Service implements QueryAllinPayreceiptInfoServiceImplService {

    public QueryAllinPayreceiptInfoServiceImplServiceLocator() {
    }


    public QueryAllinPayreceiptInfoServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QueryAllinPayreceiptInfoServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QueryAllinPayreceiptInfo
    private String QueryAllinPayreceiptInfo_address = "http://9.0.2.157/payment-service/services/QueryAllinPayreceiptInfo";

    public String getQueryAllinPayreceiptInfoAddress() {
        return QueryAllinPayreceiptInfo_address;
    }

    // The WSDD service name defaults to the port name.
    private String QueryAllinPayreceiptInfoWSDDServiceName = "QueryAllinPayreceiptInfo";

    public String getQueryAllinPayreceiptInfoWSDDServiceName() {
        return QueryAllinPayreceiptInfoWSDDServiceName;
    }

    public void setQueryAllinPayreceiptInfoWSDDServiceName(String name) {
        QueryAllinPayreceiptInfoWSDDServiceName = name;
    }

    public QueryAllinPayreceiptInfoServiceImpl getQueryAllinPayreceiptInfo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QueryAllinPayreceiptInfo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQueryAllinPayreceiptInfo(endpoint);
    }

    public QueryAllinPayreceiptInfoServiceImpl getQueryAllinPayreceiptInfo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            QueryAllinPayreceiptInfoSoapBindingStub _stub = new QueryAllinPayreceiptInfoSoapBindingStub(portAddress, this);
            _stub.setPortName(getQueryAllinPayreceiptInfoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQueryAllinPayreceiptInfoEndpointAddress(String address) {
        QueryAllinPayreceiptInfo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (QueryAllinPayreceiptInfoServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                QueryAllinPayreceiptInfoSoapBindingStub _stub = new QueryAllinPayreceiptInfoSoapBindingStub(new java.net.URL(QueryAllinPayreceiptInfo_address), this);
                _stub.setPortName(getQueryAllinPayreceiptInfoWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("QueryAllinPayreceiptInfo".equals(inputPortName)) {
            return getQueryAllinPayreceiptInfo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://9.0.2.157/payment-service/services/QueryAllinPayreceiptInfo", "QueryAllinPayreceiptInfoServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://9.0.2.157/payment-service/services/QueryAllinPayreceiptInfo", "QueryAllinPayreceiptInfo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("QueryAllinPayreceiptInfo".equals(portName)) {
            setQueryAllinPayreceiptInfoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
