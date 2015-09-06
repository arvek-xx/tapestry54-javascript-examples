package no.mil.tap54.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import no.mil.tap54.domain.Phones;

@Path("/phones")
public class PhoneResource
{
	List<Phones> returnPhones = new ArrayList<Phones>();

	@GET
	@Produces({ "application/json" })
	public List<Phones> getPhones()
	{
		if (returnPhones == null || returnPhones.size() == 0)
		{
			returnPhones.add(new Phones(0,"motorola-xoom-with-wi-fi","images/motorola-xoom-with-wi-fi.0.jpg","Motorola XOOM\u2122 with Wi-Fi","The Next, Next Generation\r\n\r\nExperience the future with Motorola XOOM with Wi-Fi, the world's first tablet powered by Android 3.0 (Honeycomb)."));
			returnPhones.add(new Phones(1,"motorola-xoom","images/motorola-xoom.0.jpg","MOTOROLA XOOM\u2122","The Next, Next Generation\n\nExperience the future with MOTOROLA XOOM, the world's first tablet powered by Android 3.0 (Honeycomb)."));
			returnPhones.add(new Phones(2, "motorola-atrix-4g", "images/motorola-atrix-4g.0.jpg","MOTOROLA ATRIX\u2122 4G", "MOTOROLA ATRIX 4G the world's most powerful smartphone."));
			returnPhones.add(new Phones(3, "dell-venue", "images/dell-venue.0.jpg", "Dell Venue","The Dell Venue; Your Personal Express Lane to Everything"));
			returnPhones.add(new Phones(4,"nexus-s","images/nexus-s.0.jpg","Nexus S","Fast just got faster with Nexus S. A pure Google experience, Nexus S is the first phone to run Gingerbread (Android 2.3), the fastest version of Android yet."));
		}
		return returnPhones;
	}

	@GET
	@Produces({ "application/json" })
	@Path("{age}")
	public Phones getPhones(@PathParam("age") int age)
	{
		List<Phones> _phones = getPhones();
		Phones returnPhones = null;
		for (Iterator<Phones> iterator = _phones.iterator(); iterator.hasNext();)
		{
			Phones _phone = (Phones) iterator.next();
			if (_phone.getAge() == age)
			{
				returnPhones = _phone;
			}
		}

		if (returnPhones == null)
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return returnPhones;
	}
}
