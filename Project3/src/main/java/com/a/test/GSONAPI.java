package com.a.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


public class GSONAPI {
//參考資料:https://www.jianshu.com/p/e740196225a4
//參考資料:https://xnfood.com.tw/android-json-gson-2/
	
	public static void main(String[] args) {
		// 在使用 GSON 之前，我們必須先取得 GSON 的 jar 檔，(或者在pom檔裡面)
		//直接上網搜尋下載，並加入專案之 libs 資料夾即可，下面我們直接以程式碼的方式，來說明 GSON 的使用方法。

		// Configures Gson to serialize Date objects according to the pattern provided. 
//		Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Gson gson = new Gson();
		String jsonStr = "";
		 
		// Data for testing (bean method)
//		Book book1 = new Book("Java", 500, "John");
//		Book book2 = new Book("Android", 600, "Allen");
		 
		//array
		
		int [] a = {12,23,84,29,30};
		int [] b = {33,55,77,82,56};
		
		// Object to JSON  //json string
//		jsonStr = gson.toJson(book1);
		jsonStr = gson.toJson(a);
		System.out.println("Object to JSON: " + jsonStr);
		 
		// JSON to Object (已知資料類別為 Book 時) 
//		System.out.println("JSON to Object: ");
//		Book myBook = gson.fromJson(jsonStr, Book.class);
//		myBook.show();
		 
		// get JsonObject's value from JSON (未知資料類別時)
		System.out.println("get JsonObject's value from JSON: ");
//		JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
//		String name = jsonObject.get("name").getAsString();
//		double price = jsonObject.get("price").getAsDouble();
//		String author = jsonObject.get("author").getAsString();
//		new Book(name, price, author).show();
		System.out.println();
		
		

	}

}
