package problem1;


import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class of ReservationSystem
 */
public class ReservationSystem {

    /**
     * Main method to create a new instance of Theater and call the service implemented in ReservationService
     * @param args as String[]
     */
  public static void main(String[] args){
      Theater theater = new Theater();
      ReservationService service = new ReservationService(theater);
      while(true) {
          Scanner console = new Scanner(System.in);
          System.out.println("What would you like to do?");
          String respond = console.nextLine().toLowerCase();
          String[] respondList = respond.split(" ");
          if(respondList[0].equals("show") && respondList.length == 1) {
              service.show();
          }
          if(respondList[0].equals("done") && respondList.length == 1) {
              System.out.println("Have a nice day!");
              break;
          }
          String regex = "\\d+(\\.\\d+)?";
          if(respondList[0].equals("reserve") && respondList.length == 2 && Pattern.matches(regex, respondList[1])) {
              Integer row = null;
              int numberReserve = Integer.parseInt(respondList[1]);
              if (numberReserve > theater.getRows().get(1).size()) {
                  System.out.println("Sorry, we don’t have that many seats together for you.");
              } else {
                  System.out.println("What's your name?");
                  String name = console.next();
                  System.out.println("Do you need wheelchair accessible seats?");
                  String wheelchairOption = console.next().toLowerCase();
                  if (wheelchairOption.equals("yes")) {
                      row = service.reserve(new Person(name), numberReserve, true);
                  }
                  if (wheelchairOption.equals("no")) {
                      row = service.reserve(new Person(name), numberReserve, false);
                  }
                  if(row != null) {
                      System.out.println(
                          "I’ve reserved " + numberReserve + " seats for you at the " +
                              theater.getName() + " in row " + row + ", " + name + ".");
                  }
              }
          }
          System.out.println();
      }
  }
}
