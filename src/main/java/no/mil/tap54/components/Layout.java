package no.mil.tap54.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

@Import(module = "bootstrap/collapse")
public class Layout
{
	@Inject
	private ComponentResources resources;

	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	@Inject
	@Symbol(SymbolConstants.APPLICATION_VERSION)
	private String appVersion;

	@Property
	private String pageName;

	public String getClassForPageName()
	{
		return resources.getPageName().equalsIgnoreCase(pageName) ? "active" : null;
	}

	public String[] getPageNames()
	{
		return new String[] { "Index", "NgTodo", "NgPhones", "Highcharts", "Jchart", "Raphael" };
	}

}
