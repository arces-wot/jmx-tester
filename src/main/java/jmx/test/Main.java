package jmx.test;
/* 
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

public class Main implements MainMBean {
	private final static String version = "0.11.2023.06.07";
	
	private Boolean sync = Boolean.FALSE; 

	public Main(String[] args) throws InterruptedException {
		System.out.println("##########################################################################################");
		System.out.println("#                           ____  _____ ____   _                                         #");
		System.out.println("#                          / ___|| ____|  _ \\ / \\                                        #");
		System.out.println("#                          \\___ \\|  _| | |_) / _ \\                                       #");
		System.out.println("#                           ___) | |___|  __/ ___ \\                                      #");
		System.out.println("#                          |____/|_____|_| /_/   \\_\\                                     #");
		System.out.println("#                                                                                        #");
		System.out.println("#                     SPARQL Event Processing Architecture                               #");
		System.out.println("#                                                                                        #");
		System.out.println("#                                                                                        #");
		System.out.println("# This program comes with ABSOLUTELY NO WARRANTY                                         #");
		System.out.println("# This is free software, and you are welcome to redistribute it under certain conditions #");
		System.out.println("# GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007                                    #");
		System.out.println("#                                                                                        #");
		System.out.println("#                                                                                        #");
		System.out.println("# @prefix git: <https://github.com/> .                                                   #");
		System.out.println("# @prefix dc: <http://purl.org/dc/elements/1.1/> .                                       #");
		System.out.println("#                                                                                        #");
		System.out.println("# git:arces-wot/sepa dc:title 'SEPA' ;                                                   #");
		System.out.println("# dc:creator git:lroffia ;                                                               #");
		System.out.println("# dc:contributor git:relu91 ;                                                            #");
		System.out.println("# dc:format <https://java.com> ;                                                         #");
		System.out.println("# dc:publisher <https://github.com> .                                                    #");
		System.out.println("##########################################################################################");
		System.out.println("");

		// Beans
		Beans.registerMBean("SEPA:type=" + this.getClass().getSimpleName(), this);
		MainBeans.setVersion(version);

		// Welcome message
		System.out.println("");
		System.out.println("*****************************************************************************************");
		System.out.println("*                        SEPA Broker Ver is up and running                              *");
		System.out.println("*                        Let Things Talk and Data Be Free!                              *");
		System.out.println("*****************************************************************************************");
		System.out.print("Version "+version);
			
		Logging.init();
		
		synchronized(sync) {
			sync.wait();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Attach CTRL+C hook
		Runtime.getRuntime().addShutdownHook(new ShutdownHook(new Main(args)));
	}

	public void shutdown() throws InterruptedException {
		System.out.println("Stopping...");

		synchronized(sync) {
			sync.notify();
		}

		System.out.println("Stopped...bye bye :-)");
	}

	@Override
	public String getUpTime() {
		return MainBeans.getUpTime();
	}

	@Override
	public String getVersion() {
		return MainBeans.getVersion();
	}
}
