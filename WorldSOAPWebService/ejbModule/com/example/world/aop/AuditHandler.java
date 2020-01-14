package com.example.world.aop;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AuditHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext context) {
		//context.entrySet().forEach(System.out::println);
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		try {
			context.getMessage().writeTo(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			SOAPBody soapBody = context.getMessage().getSOAPBody();
			SOAPHeader soapHeader = context.getMessage().getSOAPHeader();
			context.getMessage().writeTo(System.err);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
