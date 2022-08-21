package problem1;

import java.util.List;

/**
 * Class of ReservationService, reserve seats by find best seats and show all the seats
 */
public class ReservationService {

  private static final Integer OUT_OF_ROW = 0;
  private Theater theater;

  /**
   * Constructor of ReservationService
   * @param theater - represented as Theater
   */
  public ReservationService(Theater theater) {
    this.theater = theater;
  }


  /**
   * Method to reserve the best seats if there is a bestRow in certain condition
   * @param person - person who want to reserve as Person
   * @param numberOfSeats - number of Seats to reserve as Integer
   * @param wheelchairOrNot - need wheel-chair option or not as Boolean
   * @return bestRow as Integer
   */
  public Integer reserve(Person person, Integer numberOfSeats, Boolean wheelchairOrNot){
    Integer bestRow = null;
    if (wheelchairOrNot) {
      bestRow = this.findRowForWheelchair(numberOfSeats);
    } else {
      bestRow = this.findOptimalRow(numberOfSeats);
    }
    if (bestRow == null) {
      System.out.println("Sorry, we don’t have that many seats together for you.");
    } else {
      Integer seatsReserved = (this.theater.createSeats().size() -
          this.numberOfSeatsUnreserved(bestRow));
      for (int i = seatsReserved; i < (numberOfSeats + seatsReserved); i++) {
        this.findRow(bestRow).get(i).setReservedFor(person);
      }
    }
    return bestRow;
  }

  /**
   * Method to find the bestSeats for non-wheel-chair option
   * If all the normal seats are reserved and only wheel-chair seats are left
   * then wheel-chair seats can be reserve
   * @param numberOfSeats - number of seats to reserve as Integer
   * @return best row as Integer
   */
  private Integer findOptimalRow(Integer numberOfSeats){
    Integer middlePointUp = this.theater.getRows().size() / 2 + 1;
    Integer middlePointDown = this.theater.getRows().size() / 2 + 1;
    while((middlePointUp<this.theater.getRows().size() + 1) && (middlePointDown> OUT_OF_ROW)) {
      if ((this.numberOfSeatsUnreserved(middlePointUp) >= numberOfSeats)
          && (!this.theater.getWheelchairRows().contains(middlePointUp))) {
        return middlePointUp;
      }
      if ((this.numberOfSeatsUnreserved(middlePointDown) >= numberOfSeats)
          && (!this.theater.getWheelchairRows().contains(middlePointDown))) {
        return middlePointDown;
      }
      middlePointUp++;
      middlePointDown--;
    }
    return this.findRowForWheelchair(numberOfSeats);
  }

  /**
   * Method to find the row for wheel-chair
   * @param numberOfSeats - number of seats to reserve as Integer
   * @return row for wheel-char as Integer
   * If there aren't seats left for wheel-chair, return null
   */
  public Integer findRowForWheelchair(Integer numberOfSeats){
    List<Integer> wheelRowNumbers = this.theater.getWheelchairRows();
    for(int i=0;i<wheelRowNumbers.size();i++){
      if(this.numberOfSeatsUnreserved(wheelRowNumbers.get(i)) >=
      numberOfSeats){
        return wheelRowNumbers.get(i);
      }
    }
    return null;
  }

  /**
   * Method to check number of unreserved seats in certain row
   * @param rowNumber - rowNumber to reserve as Integer
   * @return size of unreserved seats as Integer
   */
  private Integer numberOfSeatsUnreserved(Integer rowNumber){
    Integer size = 0;
    Row targetRow = this.findRow(rowNumber);
    for(Seat seat: targetRow){
      if(seat.getReservedFor() == null){
        size ++;
      }
    }
    return size;
  }

  /**
   * Method to find the target row
   * @param rowNumber - rowNumber to reserve as Integer
   * @return targetRow as Row
   */
  private Row findRow(Integer rowNumber){
    Row targetRow = null;
    for(Row row: this.theater.getRows()){
      if (row.getRowNumber() == rowNumber){
        targetRow = row;
      }
    }
    return targetRow;
  }

  /**
   * Method to display the current available seating in the Theater
   */
  public void show(){
    System.out.println(this.theater);
  }

}
