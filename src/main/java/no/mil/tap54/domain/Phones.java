package no.mil.tap54.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Domain-model class for storing Phone info. Used to make rest rest service together with 'PhoneResources'
 */
@XmlRootElement(name = "phones")
public class Phones
{
	int age;
	String id;
	String imageUrl;
	String name;
	String snippet;

	public Phones()
	{
	}

	public Phones(int age, String id, String imageUrl, String name, String snippet)
	{
		setAge(age);
		setId(id);
		setImageUrl(imageUrl);
		setName(name);
		setSnippet(snippet);
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSnippet()
	{
		return snippet;
	}

	public void setSnippet(String snippet)
	{
		this.snippet = snippet;
	}

}
