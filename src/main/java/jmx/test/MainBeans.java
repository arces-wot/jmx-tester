package jmx.test;
/* This class belongs to the JMX classes used for the remote monitoring of the engine
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


import java.time.Duration;
import java.util.Date;

public class MainBeans {
	private static Date startDate = new Date();

	private static String version;

	public static void setVersion(String v) {
		version = v;
	}

	public static String getVersion() {
		return version;
	}

	public static String getUpTime() {
		return startDate.toString() + " " + Duration.between(startDate.toInstant(), new Date().toInstant()).toString();
	}
}
