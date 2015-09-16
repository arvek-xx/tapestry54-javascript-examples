package no.mil.tap54.pages;

import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;


public class ReactPlain
{
	JSONObject product1 = new JSONObject("category", "Sporting Goods", "price", "$49.99", "stocked", "true", "name", "Football");
	JSONObject product2 = new JSONObject("category", "Sporting Goods", "price", "$9.99", "stocked", "true", "name", "Baseball");
	JSONObject product3 = new JSONObject("category", "Sporting Goods", "price", "$29.99", "stocked", "true", "name", "Basketball");
	JSONObject product4 = new JSONObject("category", "Electronics", "price", "$99.99", "stocked", "true", "name", "iPod Touch");
	JSONObject product5 = new JSONObject("category", "Electronics", "price", "$399.99", "stocked", "false", "name", "iPhone 5");
	JSONObject product6 = new JSONObject("category", "Electronics", "price", "$199.99", "stocked", "true", "name", "Nexus 7");
	
	JSONArray products = new JSONArray(product1,product2,product3,product4,product5,product6);
	
	public JSONArray getMyProducts()
	{
		return products;
	}
	
	public void setupRender()
	{
		System.out.println(getMyProducts());
	}
	
}
