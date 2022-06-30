package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is Maven project");
        Employee employeeOne = new Employee("Jānis", "Programmētājs", 1000.32);
        System.out.println(employeeOne.toString());

        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(), faker.company().profession(), faker.number().randomDouble(2, 100, 2000));
        System.out.println(employeeTwo.toString());

        System.out.println(employeeOne.toString());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());

        System.out.println("creditCardExpiry: " + faker.business().creditCardExpiry());
        System.out.println("champion: " +faker.leagueOfLegends().champion());
        System.out.println("fruit: " + faker.food().fruit());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree.toString());

        //cikls
 //       for (int i = 0; i < 100; i++) {
 //           Employee employeeN = new Employee();
 //          System.out.println(employeeN.toString());
 //      }



    }
}
