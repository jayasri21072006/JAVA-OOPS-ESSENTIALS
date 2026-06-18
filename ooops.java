class Admission {
    int phno;
    String name;

    public void display() {
        System.out.println("Phone: " + phno);
        System.out.println("Name: " + name);
    }
}

public class Main {
    public static void main(String[] args) {

        Admission admin1 = new Admission();

        admin1.phno = 568;
        admin1.name = "Jayasri";

        admin1.display();
    }
}


class Admission {
    int phno;
    String name;

    public void setval(int ph, String name) {
        this.phno = ph;
        this.name = name;
    }

    public void display() {
        System.out.println("Phone: " + phno);
        System.out.println("Name: " + name);
    }
}

public class Main {
    public static void main(String[] args) {

        Admission admin1 = new Admission();

        admin1.setval(2, "babye");

        admin1.display();
    }
}


Phone: 2
Name: babye

