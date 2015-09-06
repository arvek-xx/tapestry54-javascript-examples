package no.mil.tap54.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

@Import(module = { "highcharts", "my-highcharts-code" })
public class Highcharts
{
	@Property
	@Persist
	private int tapestry;

	@Property
	@Persist
	private int angular;

	@Property
	@Persist
	private int highcharts;

	void setupRender()
	{
		tapestry = 500;
		angular = 250;
		highcharts = 250;
	}
}
