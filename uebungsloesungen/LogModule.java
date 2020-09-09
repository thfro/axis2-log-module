package nrw.it.axis2.logmodule;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisDescription;
import org.apache.axis2.description.AxisModule;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.AxisServiceGroup;
import org.apache.axis2.modules.Module;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.neethi.Assertion;
import org.apache.neethi.Policy;

public class LogModule implements Module {

    private static final Log LOG = LogFactory.getLog(LogModule.class);

    @Override
	public void init(ConfigurationContext configContext, AxisModule module) throws AxisFault {
		LOG.info("soap-logger module initialized.");
	}

	@Override
	public void engageNotify(AxisDescription axisDescription) throws AxisFault {
		if (axisDescription instanceof AxisService) {
			AxisService service = (AxisService) axisDescription;
			LOG.info("soap-logger module engaged with service " + service.getName());
			
		} else if (axisDescription instanceof AxisOperation) {
			AxisOperation operation = (AxisOperation) axisDescription;
			LOG.info("soap-logger module engaged with operation " + operation.getName());
			
		} else if (axisDescription instanceof AxisServiceGroup) {
			AxisServiceGroup serviceGroup = (AxisServiceGroup) axisDescription;
			LOG.info("soap-logger module engaged with service group " + serviceGroup.getServiceGroupName());

		} else {
			LOG.info("soap-logger module engaged.");
		}
	}

	@Override
	public boolean canSupportAssertion(Assertion assertion) {
		return false;
	}

	@Override
	public void applyPolicy(Policy policy, AxisDescription axisDescription) throws AxisFault {
	}

	@Override
	public void shutdown(ConfigurationContext configurationContext) throws AxisFault {
		LOG.info("soap-logger module shut down.");
	}
}
