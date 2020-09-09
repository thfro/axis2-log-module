package nrw.it.axis2.logmodule;

import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.HandlerDescription;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogHandler extends AbstractHandler {

    private static final Log LOG = LogFactory.getLog(LogHandler.class);

    @Override
    public void init(HandlerDescription handlerdesc) {
        this.handlerDesc = handlerdesc;
    }

    @Override
    public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {
		SOAPEnvelope env = msgContext.getEnvelope();
		LOG.info(handlerDesc.getName() + ": " + env.toString());
		return InvocationResponse.CONTINUE;
	}
}