package kata6;

import kata6.HistogramDisplay;
import java.io.IOException;
import java.util.ArrayList;

public class KATA4V10 {

    public static void main(String[] args) throws IOException {
        System.out.println("Inicio");
        String nameFile = "C:\\Users\\usuario\\Desktop\\emails.txt";
        ArrayList <Person> arrayMail = MailList.readFile(nameFile);
    
        HistogramBuilder<Person> builder = new HistogramBuilder<Person>(arrayMail);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
                
        Histogram<Character> letter = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letter,"Caracter").execute();
        
        //Histogram<String> histogram = MailHistogramBuilder.build(arrayMail);
        //new HistogramDisplay(histogram).execute();
        System.out.println("Fin");
        
    }
    
}
