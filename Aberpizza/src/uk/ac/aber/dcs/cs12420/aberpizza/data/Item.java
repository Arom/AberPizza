package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * This is an interface class that is used by every item added into the till.
 */
public interface Item {

	public BigDecimal getPrice();

	public String getDescription();

	public void setPrice(BigDecimal price);

	public void setDescription(String description);
}
