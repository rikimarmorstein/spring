//package client;
//
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import app.core.entities.Library;
//
//public class RestTemplateDemo {
//
//	public static void main(String[] args) {
//		RestTemplate rt = new RestTemplate();
//		try {
////		String url = "http://localhost:8080/api/booknew?nameLibrary=grin";
////
////		Book book = Book.builder().author("gilds").title("gilonds").build();// new Book("gil", "gilon");
////		Book book1 = rt.postForObject(url, book, Book.class);
////		System.out.println(book1);
//		} catch (RestClientException e) {
//			System.out.println("Error: " + e.getMessage());
//		}
//		try {
//			String url1 = "http://localhost:8080/api/";
//
//			Library library = Library.builder().name("goldij").adress("gihhnot").build();
//			Library createLibrary1 = rt.postForObject(url1, library, Library.class);
////		Library library2 = new Library("kolomb", "ginot");
//
////		Library createLibrary2 = rt.postForObject(url, library2, Library.class);
//			System.out.println(createLibrary1);
////		System.out.println(createLibrary2);
//		} catch (RestClientException e) {
//			System.out.println("Error: " + e.getMessage());
//		}
//	}
//
//}
