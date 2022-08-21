package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class of Theater tracking name of theater, rows of seats with wheel-chair option
 */
public class Theater {

  private static final int NUM_DIGIT_MAX = 9;
  private String name;
  private List<Row> rows;
  private List<Integer> wheelchairRows;

  /**
   * Constructor of Theater
   */
  public Theater() {
    this.name = "Paramount";
    this.rows = this.createTheater();
    this.wheelchairRows = this.wheelRows();
  }

  /**
   * Method to create seats for non-wheel-chair
   * @return listOfSeats as List<Seats>
   */
  public List<Seat> createSeats(){
    Seat seat1 = Seat.createSeat("A", false);
    Seat seat2 = Seat.createSeat("B", false);
    Seat seat3 = Seat.createSeat("C", false);
    Seat seat4 = Seat.createSeat("D", false);
    Seat seat5 = Seat.createSeat("E", false);
    Seat seat6 = Seat.createSeat("F", false);
    Seat seat7 = Seat.createSeat("G", false);
    Seat seat8 = Seat.createSeat("H", false);
    ArrayList<Seat> listOfSeats = new ArrayList<>(
        Arrays.asList(seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8));
    return listOfSeats;
  }

  /**
   * Method to create seats for wheel-chair
   * @return listOfWheelSeats as List<Seat>
   */
  public List<Seat> createWheelSeats(){
    Seat wheelSeat1 = Seat.createSeat("A", true);
    Seat wheelSeat2 = Seat.createSeat("B", true);
    Seat wheelSeat3 = Seat.createSeat("C", true);
    Seat wheelSeat4 = Seat.createSeat("D", true);
    Seat wheelSeat5 = Seat.createSeat("E", true);
    Seat wheelSeat6 = Seat.createSeat("F", true);
    Seat wheelSeat7 = Seat.createSeat("G", true);
    Seat wheelSeat8 = Seat.createSeat("H", true);
    ArrayList<Seat> listOfWheelSeats = new ArrayList<>(
        Arrays.asList(wheelSeat1, wheelSeat2, wheelSeat3, wheelSeat4,
            wheelSeat5, wheelSeat6, wheelSeat7, wheelSeat8));
    return listOfWheelSeats;
  }

  /**
   * Method to create theater with rows of seats
   * @return rows as List<Row><
   */
  private List<Row> createTheater(){
    Row row1 = Row.createRow(1, false);
    row1.addAll(this.createSeats());
    Row row2 = Row.createRow(2, false);
    row2.addAll(this.createSeats());
    Row row3 = Row.createRow(3, false);
    row3.addAll(this.createSeats());
    Row row4 = Row.createRow(4, false);
    row4.addAll(this.createSeats());
    Row row5 = Row.createRow(5, true);
    row5.addAll(this.createWheelSeats());
    Row row6 = Row.createRow(6, false);
    row6.addAll(this.createSeats());
    Row row7 = Row.createRow(7, false);
    row7.addAll(this.createSeats());
    Row row8 = Row.createRow(8, false);
    row8.addAll(this.createSeats());
    Row row9 = Row.createRow(9, true);
    row9.addAll(this.createWheelSeats());
    Row row10 = Row.createRow(10, false);
    row10.addAll(this.createSeats());
    Row row11 = Row.createRow(11, false);
    row11.addAll(this.createSeats());
    Row row12 = Row.createRow(12, false);
    row12.addAll(this.createSeats());
    Row row13 = Row.createRow(13, false);
    row13.addAll(this.createSeats());
    ArrayList<Row> rows = new ArrayList<>(Arrays.asList(row1, row2,
        row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13));
    return  rows;
  }

  /**
   * Method to create a row with a wheel-chair
   * @return wheelRows as List<Integer>
   */
  private List<Integer> wheelRows(){
    List<Row> allRows = this.createTheater();
    List<Integer> wheelRows = new ArrayList<>();
    for(Row row: allRows){
      if(row.getWheelchairOrNot()){
        wheelRows.add(row.getRowNumber());
      }
    }
    return wheelRows;
  }

  /**
   * Getter of rows
   * @return rows as List<Row>
   */
  public List<Row> getRows() {
    return rows;
  }

  /**
   * Getter of wheelchairRows
   * @return wheelchairRows as List<Integer>
   */
  public List<Integer> getWheelchairRows() {
    return wheelchairRows;
  }

  /**
   * Getter of name of theater
   * @return name as String
   */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    String theater = "";
    for (int i = 0; i < this.rows.size(); i++) {
      if(i >= NUM_DIGIT_MAX){
        theater += (i + 1) + " " + this.rows.get(i).toString() + "\n";
      } else {
        theater += (i + 1) + "  " + this.rows.get(i).toString() + "\n";
      }
    }
    return theater;
  }
}
