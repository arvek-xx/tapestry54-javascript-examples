package no.mil.tap54.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.slf4j.Logger;

@Import(module = {"bootstrap/collapse", "bootstrap/dropdown"})
public class Layout
{
	@Inject
	private Logger logger;
	
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

	@Property
	private String ngPageName;

	@Property
	private String chartPageName;

	public String getClassForPageName()
	{
		if (isActiveNg() && isAngular())
		{
			return "active dropdown";
		} else if (!isActiveNg() && isAngular())
		{
			return "dropdown";
		} else if (isActiveChart() && isCharts())
		{
			return "active dropdown";
		} else if (!isActiveChart() && isCharts())
		{
			return "dropdown";
		} else
		{
			return resources.getPageName().equalsIgnoreCase(pageName) ? "active" : null;
		}
	}

	public String[] getPageNames()
	{
		return new String[] { "Index", "NgPhones2", "Highcharts", "Bootstrap", "Coffee", "React" };
	}
	
	public String[] getNgPageNames()
	{
		return new String[] { "NgPhones2", "NgPhones", "NgTodo" };
	}
	
	public String[] getChartPageNames()
	{
		return new String[] { "Highcharts", "Jchart", "Raphael" };
	}
	
	public boolean isAngular()
	{
		return pageName.equalsIgnoreCase("NgPhones2");
	}
	
	public boolean isCharts()
	{
		return pageName.equalsIgnoreCase("Highcharts");
	}
	
	// 
	private boolean isActiveNg()
	{
		String _activePage = resources.getPageName();
		logger.debug(_activePage);
		boolean _isActive = false;
		if (resources.getPageName().equalsIgnoreCase(pageName)) _isActive = true;
		
		if (_activePage.equalsIgnoreCase("NgPhones"))  _isActive = true;
		if (_activePage.equalsIgnoreCase("NgTodo"))  _isActive = true;
		return _isActive;
	}

	private boolean isActiveChart()
	{
		String _activePage = resources.getPageName();
		logger.debug(_activePage);
		boolean _isActive = false;
		if (resources.getPageName().equalsIgnoreCase(pageName)) _isActive = true;
		
		if (_activePage.equalsIgnoreCase("Jchart"))  _isActive = true;
		if (_activePage.equalsIgnoreCase("Raphael"))  _isActive = true;
		return _isActive;
	}

}
