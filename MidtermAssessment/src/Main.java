class Book{
    
    private String book_name;
    private long isbn_number;
    private String author_name;
    private String publisher;
    private float price;
    
    public Book(String book_name, long isbn_number){
        
        this.book_name = book_name;
        this.isbn_number = isbn_number;
    }
    
    public Book(String author_name, String publisher, float price){
        
        this.author_name = author_name;
        this.publisher = publisher;
        this.price = price;
    }
    
   // Getter 1
   public String getBookName() {
     return book_name;
   }

   // Setter 1
   public void setName(String newBookName) {
     this.book_name = newBookName;
   }
   
   // Getter 2
   public long getISBNNumber() {
     return isbn_number;
   }

   // Setter 2
   public void setISBNNumber(long newISBNNumber) {
     this.isbn_number = newISBNNumber;
   }
   
   // Getter 3
   public String getAuthorName() {
     return author_name;
   }

   // Setter 3
   public void setAuthorName(String newAuthorName) {
     this.author_name = newAuthorName;
   }
   
   // Getter 4
   public String getPublisher() {
     return publisher;
   }

   // Setter 4
   public void setPublisher(String newPublisher) {
     this.publisher = newPublisher;
   }
   
   // Getter 5
   public String getPrice() {
     return publisher;
   }

   // Setter 5
   public void setPrice(float newPrice) {
     this.price = newPrice;
   }
    
    public void updatePrice(float price){
        
        if(price < 200){
            // 5%
            price += price * 0.05;
        } else {
            // 3%
            price += price * 0.03;
        }
        
        this.price = price;
    }
    
    public void display(){
        
        System.out.println("Book Name: " + book_name);
        System.out.println("ISBN Number: " + isbn_number);
        System.out.println("Author Name: " + author_name);
        System.out.println("Publisher: " + publisher);
        System.out.println("Price: " + price);
        //System.out.println("----------------------------------------");
    }
}
public class Main {
    
    public static void main(String[] args) {
        
        Book[] ob = new Book[10];
        
        for(int i = 0; i < 10; i++){
            
            // Constructor overloading
            ob[i++] = new Book("Java - The Complete Reference", 9780071631778L);
            ob[i] = new Book("Herbert Schildt", "McGraw-Hill", 800);
        }
        
        for(int i = 0; i < 10; i++){
            
            // Setter method and getter method inside in the Book class
            ob[i].setAuthorName("Herbert Schildt");
            ob[i].setISBNNumber(9780071631778L + i + 1);
            ob[i].setName("Java - The Complete Reference");
            ob[i].setPublisher("McGraw-Hill");
            ob[i].setPrice(100*(i+1));
            // UpdatePrice method
            ob[i].updatePrice(100*(i+1));
        }
        
        for(int i = 0; i < 10; i++){
            System.out.println("----------------------------------------");
            System.out.println("Object " + (i + 1) + " out of 10");
            System.out.println("----------------------------------------");
            
            // Display method
            ob[i].display();
        }
    }
}
