package jmx.test;
/* This class contains utility methods to register and manage JMX beans
 * 
 * Author: Luca Roffia (luca.roffia@unibo.it)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class Beans {
	//Get the MBean server
	static final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    
	public static void registerMBean(final String mBeanObjectName,final Object mBean)
   {
      try
      {
         final ObjectName name = new ObjectName(mBeanObjectName);
         mbs.registerMBean(mBean, name);
      }
      catch (MalformedObjectNameException badObjectName)
      {
    	  Logging.logger.error(badObjectName.getMessage());
      }
      catch (InstanceAlreadyExistsException duplicateMBeanInstance)
      {
    	  Logging.logger.error(duplicateMBeanInstance.getMessage());
      }
      catch (MBeanRegistrationException mbeanRegistrationProblem)
      {
    	  Logging.logger.error(mbeanRegistrationProblem.getMessage());
      }
      catch (NotCompliantMBeanException badMBean)
      {
    	  Logging.logger.error(badMBean.getMessage());
      }
   }
}
