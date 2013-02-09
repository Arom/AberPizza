package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.*;
import java.io.OutputStream;
import java.math.BigDecimal;

/**
 * 
 * The code is taken from
 * https://forums.oracle.com/forums/message.jspa?messageID=4664166#4664166
 * 
 */
public class XMLBigDecimal extends XMLEncoder {

	/**
	 * Code for XML output.
	 * 
	 * @param out
	 * 
	 */
	public XMLBigDecimal(OutputStream out) {

		super(out);
		this.setPersistenceDelegate(BigDecimal.class,
				new DefaultPersistenceDelegate() {
					protected Expression instantiate(Object oldInstance,
							Encoder out) {
						BigDecimal bd = (BigDecimal) oldInstance;
						return new Expression(oldInstance, oldInstance
								.getClass(), "new", new Object[] { bd
								.toString() });
					}

					protected boolean mutatesTo(Object oldInstance,
							Object newInstance) {
						return oldInstance.equals(newInstance);
					}
				});
	}

}