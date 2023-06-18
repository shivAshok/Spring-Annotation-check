package com.shiv_doggar.myfirstprojextyrr;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Bookcontroller {
     Map<Integer,Book> bookdata=new HashMap<>();
     @PostMapping("/add-new-book")
     public String addBook(@RequestBody Book book){
         bookdata.put(book.getId(),book);
         return "book created";
     }
  @GetMapping("/get-mybookmm")
     public Book getBook(@RequestParam Integer id){

         return bookdata.get(id);
     }

     @GetMapping("/get-allbooks")
    public List<Book>  getAllbook(){
        return new ArrayList<>(bookdata.values());
     }
     @GetMapping("/getbook-byname/{name}")
     public Book getbookByname(@PathVariable String name){
         for(int a:bookdata.keySet()){
             if(bookdata.get(a).getTitle().equals(name)){
                 return bookdata.get(a);
             }
         }
         return null;
     }
     @PutMapping("/update-book-page")
    public Book updateBookpage(@RequestParam Integer id,@RequestParam Integer pages){
         Book book=bookdata.get(id);
         book.setPages(pages);
         bookdata.put(id,book);
         return book;
     }
     @DeleteMapping("/delete-book/{id}")
    public String DeletebookbyId(@PathVariable Integer id){
         bookdata.remove(id);
         return "book deleted with id"+id;
     }
}
