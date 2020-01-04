package com.a.test;

public class GSONAPI {

	public static void main(String[] args) {
		// 在使用 GSON 之前，我們必須先取得 GSON 的 jar 檔，(或者在pom檔裡面)
		//直接上網搜尋下載，並加入專案之 libs 資料夾即可，下面我們直接以程式碼的方式，來說明 GSON 的使用方法。

		// Configures Gson to serialize Date objects according to the pattern provided. 
		Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonStr = "";
		 
		// Data for testing
		Book book1 = new Book("Java", 500, "John");
		Book book2 = new Book("Android", 600, "Allen");
		 
		// Object to JSON
		jsonStr = gson.toJson(book1);
		System.out.println("Object to JSON: " + jsonStr);
		 
		// JSON to Object (已知資料類別為 Book 時)
		System.out.println("JSON to Object: ");
		Book myBook = gson.fromJson(jsonStr, Book.class);
		myBook.show();
		 
		// get JsonObject's value from JSON (未知資料類別時)
		System.out.println("get JsonObject's value from JSON: ");
		JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
		String name = jsonObject.get("name").getAsString();
		double price = jsonObject.get("price").getAsDouble();
		String author = jsonObject.get("author").getAsString();
		new Book(name, price, author).show();
		System.out.println();
		
		

	}

}
