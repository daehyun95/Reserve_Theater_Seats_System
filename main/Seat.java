package problem1;

/**
 * Class of Seat tracking name of seat, person who reserved, and wheel-chair accessibility
 */
public class Seat {

  private String name;
  private Person reservedFor;
  private Boolean wheelchairOrNot;

  /**
   * Constructor of Seat
   * @param name - name of the seat as String
   * @param wheelchairOrNot - wheel-chair accessibility as Boolean
   */
  public Seat(String name, Boolean wheelchairOrNot) {
    this.name = name;
    this.wheelchairOrNot = wheelchairOrNot;
    this.reservedFor = null;
  }

  /**
   * Getter of Seat name
   * @return name of Seat as String
   */
  public String getName() {
    return name;
  }

  /**
   * Getter of wheel-chair accessibility
   * @return getWheelchairOrNot as Boolean
   */
  public Boolean getWheelchairOrNot() {
    return wheelchairOrNot;
  }

  /**
   * Setter of person who reserved seat
   * @param reservedFor as Person
   */
  public void setReservedFor(Person reservedFor) {
    this.reservedFor = reservedFor;
  }

  /**
   * Getter of person who reserved seat
   * @return reservedFor as Person
   */
  public Person getReservedFor() {
    return reservedFor;
  }

  /**
   * Method to create seat (Helper function)
   * @param name - name of the seat as String
   * @param wheelchairOrNot - wheel-chair accessibility as Boolean
   * @return seat as Seat
   */
  public static Seat createSeat(String name, Boolean wheelchairOrNot){
    Seat seat = new Seat(name, wheelchairOrNot);
    return seat;
  }

  @Override
  public String toString() {
    if ((this.reservedFor == null) && (
        !this.wheelchairOrNot)) {
      return " _ ";
    } else if ((this.reservedFor == null) && (
        this.wheelchairOrNot)){
      return " = ";
    } else {
      return " X ";
    }
  }
}
