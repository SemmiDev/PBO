package app.uas;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Student student;

        Scanner inputString = new Scanner(System.in);
        Scanner inputInteger = new Scanner(System.in);
        Scanner inputDouble = new Scanner(System.in);

        String username,password, email, phoneNumber, fullName, identifier, major;
        int semester, alfa;
        double nilaiTugas, nilaiKeaktifan, nilaiUTS, nilaiUAS;

        System.out.print("Masukkan username: ");
        username = inputString.nextLine();

        System.out.print("Masukkan password: ");
        password = inputString.nextLine();

        System.out.print("Masukkan email: ");
        email = inputString.nextLine();

        System.out.print("Masukkan phone number: ");
        phoneNumber = inputString.nextLine();

        System.out.print("Masukkan full name: ");
        fullName = inputString.nextLine();

        System.out.print("Masukkan identfier: ");
        identifier = inputString.nextLine();

        System.out.print("Masukkan major: ");
        major = inputString.nextLine();

        System.out.print("Masukkan semester: ");
        semester = inputInteger.nextInt();

        System.out.print("Masukkan total alfa: ");
        alfa = inputInteger.nextInt();

        System.out.print("Masukkan nilai tugas: ");
        nilaiTugas = inputDouble.nextInt();

        System.out.print("Masukkan nilai keaktifan: ");
        nilaiKeaktifan = inputDouble.nextInt();

        System.out.print("Masukkan nilai UTS: ");
        nilaiUTS = inputDouble.nextInt();

        System.out.print("Masukkan nilai UAS: ");
        nilaiUAS = inputDouble.nextInt();

        student = new Student(UUID.randomUUID().toString(),
                username,
                password,
                email,
                phoneNumber,
                fullName,
                identifier,
                major,
                semester,
                alfa,
                nilaiTugas,
                nilaiKeaktifan,
                nilaiUTS,
                nilaiUAS);

        student.printDetails();
    }
}

class Student {
    private String ID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String fullName;
    private String identifier;
    private String major;
    private int semester;
    private int alfa;
    private double nilaiTugas;
    private double nilaiKeaktifan;
    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiAkhir;

    public Student(String ID,
                   String username,
                   String password,
                   String email,
                   String phoneNumber,
                   String fullName,
                   String identifier,
                   String major,
                   int alfa,
                   int semester,
                   double nilaiTugas,
                   double nilaiKeaktifan,
                   double nilaiUTS,
                   double nilaiUAS) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.identifier = identifier;
        this.major = major;
        this.semester = semester;
        this.alfa = alfa;
        this.nilaiTugas = nilaiTugas;
        this.nilaiKeaktifan = nilaiKeaktifan;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public void hitungNilaiAkhir() {
        if (this.alfa > 5) {
            this.nilaiAkhir = 0d;
        }

        this.nilaiAkhir =  (this.nilaiTugas * 0.2) + (this.nilaiKeaktifan * 0.1) + (this.nilaiUTS * 0.3) + (this.nilaiUAS * 0.4);
        this.nilaiAkhir -= (this.alfa * 5);
    }

    public float cekIPK() {
        if (this.nilaiAkhir >= 90.0d) {
            return 4.0f;
        }else if (this.nilaiAkhir >= 85.0d) {
            return 3.0f;
        }else if (this.nilaiAkhir >= 80.0d) {
            return 2.0f;
        }else {
            return 1.0f;
        }
    }


    public void printDetails() {
        hitungNilaiAkhir();

        String details = " ID = " + ID + "\n" +
                " username = " + username  + "\n" +
                " password = " + password  + "\n" +
                " email = " + email  + "\n" +
                " phone number = " + phoneNumber  + "\n" +
                " full name = " + fullName  + "\n" +
                " identifier = " + identifier  + "\n" +
                " major = " + major  + "\n" +
                " semester = " + semester + "\n" +
                " alfa = " + alfa + "\n" +
                " nilai tugas = " + nilaiTugas + "\n" +
                " nilai keaktifan = " + nilaiKeaktifan + "\n" +
                " nilai UTS = " + nilaiUTS + "\n" +
                " nilai UAS = " + nilaiUAS + "\n" +
                " nilai Akhir = " + nilaiAkhir + "\n" +
                " ipk=" + cekIPK();

        System.out.println("======================= DETAILS MAHASISWA ====================");
        System.out.println(details);
        System.out.println("==============================================================");
    }
}