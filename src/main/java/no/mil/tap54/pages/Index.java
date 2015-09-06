package no.mil.tap54.pages;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.HttpError;
import org.slf4j.Logger;

/**
 * Home page (prettify are used for code listings)
 */
@Import(module = { "prettify" }, stylesheet = { "prettify.css" })
public class Index
{
	@Inject
	private Logger logger;

	// Handle call with an unwanted context
	@Log
	Object onActivate(EventContext eventContext)
	{
		return eventContext.getCount() > 0 ? new HttpError(404, "Resource not found") : null;
	}

}
