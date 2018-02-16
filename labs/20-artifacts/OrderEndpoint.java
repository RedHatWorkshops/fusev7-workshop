package org.fusesource.camel.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.fusesource.camel.model.Order;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface OrderEndpoint {

  public String order(Order in);
}