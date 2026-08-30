public class Library {

    void displayBookInfo(Book book){
        System.out.println("\nTitle: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Publication Year: " + book.publicationYear);
    }

    public static void main(String[] args) {

        Book book1 = new Book("Tôi thấy hoa vàng trên cỏ xanh", "Nguyễn Nhật Ánh", 2000);
        Book book2 = new Book("Học cách làm giàu", "Johnny English", 2003);
        Book book3 = new Book("Nhập môn bất động sản", "Nguyễn Ngọc Sang", 2010);

        Library library = new Library();

        library.displayBookInfo(book1);
        library.displayBookInfo(book2);
        library.displayBookInfo(book3);

        
    }
}
