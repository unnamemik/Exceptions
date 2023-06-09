package seminar3.test;
import seminar3.controller.ContactManager;
import seminar3.data.Contact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;


public class ContactTest 
{
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String cyan = "\u001B[36m";

    public static String[] inputString() {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.println(cyan + "\nВведите контактные данные в формате: " + yellow + "Фамилия, Имя, Отчество, " +
                    "*дата в формате ддММгггг*, *десятизначный номер телефона*, *пол одним символом*:" + reset);
            try {
                inputStr = sc.nextLine();
                inputStr = inputStr.trim();
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод!" + reset);
            }
        }
        if (inputStr.isEmpty()){
            System.out.print(red + "Пустая строка! Введите символы:" + reset);
            inputString();
        }
        return inputStr.split("[,\\s]+");
    }

    public static String dateConverter(String date){
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        try {
            format.format(format.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public static String[] stringParser(String[] msg) {
        String[] strResult;
        try{
        String firstName = msg[0];
        String lastName = msg[1];
        String fatherName = msg[2];
        String date = dateConverter(msg[3]);
        if (date.length()!=8){
            System.out.println(red + "Ошибка в дате! " + date + reset);
            stringParser(inputString());
        }
            String strPhone = msg[4];
            if (strPhone.length()!=11) {
                System.out.println(red + "Ошибка в номере! " + strPhone + reset);
                stringParser(inputString());
                try {
                    Long phone = Long.valueOf(strPhone);
                } catch (RuntimeException e) {
                    System.out.println(red + "Ошибка! " + e + reset);
                    stringParser(inputString());
                }
            }
        String strSex = msg[5];
        char[] chArr = strSex.toCharArray();
        char sex =  chArr[0];
        }
        catch (RuntimeException e){
            System.out.println(red + "Ошибка! -----------------------------------------------------------\n" + e + reset);
        }
        return msg;
    }


    public static void main(String[] args) {
        ContactManager cm = new ContactManager();

        Contact c1 = new Contact(stringParser(inputString( )));
        Contact c2 = new Contact(stringParser(inputString()));
        Contact c3 = new Contact(stringParser(inputString()));
        Contact c4 = new Contact(stringParser(inputString()));

//        Данные для копипасты. )
//        Соколов, Андрей, Васильевич, 15062023, 89997775533, m
//        Антонова, Анна, Афанасьевна, 25022023, 89155456565, f
//        Антонова, Евгения, Васильевна, 17042023, 87655781245, f
//        Шульман, Екатерина, Михайловна, 12042023, 89655362544, f
//        Теркин, Василий, Петрович, 20052023, 89122144555, m

        System.out.println(yellow + "\nДобавление контакта___________________________________________________" + reset);
        int cId1 = cm.addContact(c1);
        int cId2 = cm.addContact(c2);
        int cId3 = cm.addContact(c3);
        int cId4 = cm.addContact(c4);
        List<Contact> result1 = cm.findContacts();
        for (Contact c : result1) {
            System.out.println(c);
        }

        System.out.println(yellow + "\nОбновление контакта___________________________________________________" + reset);
        Contact c5 = new Contact(stringParser(inputString()));
        cm.updateContact(cId1, c5);
        List<Contact> result2 = cm.findContacts();
        for (Contact c : result2) {
            System.out.println(c);
        }

        System.out.println(yellow + "\nУдаление контакта_____________________________________________________" + reset);
        cm.deleteContact(cId4);
        List<Contact> result3 = cm.findContacts();
        for (Contact c : result3) {
            System.out.println(c);
        }

        System.out.println(yellow + "\nНайти контакт_________________________________________________________" + reset);
        Contact contact = cm.getContact(cId2);
        System.out.println(contact);

        System.out.println(yellow + "\nЗапись контакта в файл________________________________________________" + reset);
        cm.writeContact(cId1);
        cm.writeContact(cId2);
        cm.writeContact(cId3);
    }
}
