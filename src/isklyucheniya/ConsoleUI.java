package isklyucheniya;
//Форматы данных:
//фамилия, имя, отчество - строки
//дата _ рождения - строка формата dd.mm.yyyy
//номер _ телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI {
    Scanner scanner ;
    public ConsoleUI() {
        scanner=new Scanner(System.in);
    }

    public void start() throws ParseException {
        System.out.println("Приветствую тебя пользователь");
            System.out.println("Введите: Фамилия_Имя_Отчество_дата рождения_номер телефона_пол через пробелы");
            String formatDannih = "Форматы данных: \n" +
                    "дата _ рождения - dd.mm.yyyy \n" +
                    "номер _ телефона - целое беззнаковое число  \n" +
                    "пол - символ латиницей f или m. \n";
            System.out.println(formatDannih);
            String consoleString=scanner.nextLine();

            String[] cosoleMassiv = consoleString.split(" ");
            if (cosoleMassiv.length!=6)throw new ArrayIndexOutOfBoundsException("данных должно быть 6");//проверка на 6 данных

        for (int i = 0; i <=2 ; i++) {  // проверяем ФИО
            if (! isLetters(cosoleMassiv[i])) {
                throw new NotLettersException(cosoleMassiv[i]);
            }
            }



        try {
            SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy"); // Проверка даты
           Date  birghDay = formater.parse(cosoleMassiv[3]);
            System.out.println(birghDay);
        } catch (ParseException e) {
            throw new RuntimeException("введён неправильный формат даты");
        }
        try {     // Проверка телефона
            long phone=Long.parseLong(cosoleMassiv[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("не правильно введён телефон");
        }
         String gender=cosoleMassiv[5];
        if (!isGender(gender)) {
            throw new RuntimeException("пол должен быть либо 'm' либо 'f' .");
        }


        Person person=new Person(cosoleMassiv[0],cosoleMassiv[1],cosoleMassiv[2],cosoleMassiv[3],cosoleMassiv[4],cosoleMassiv[5]);

            String fileName=cosoleMassiv[0]+".txt";
            FileHandler fileHandler=new FileHandler();
            fileHandler.save(fileName,person);


        }
    public boolean isLetters(String name) {
        return name.matches("[a-zA-Zа-яА-Я-]+");
    }

    public boolean isGender(String s){
        if (s.equals("m")||s.equals("f")){
            return true;
        }else return false;
    }


}
