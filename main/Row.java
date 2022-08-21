package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class of Row tracking the row number and wheel-chair accessibility
 */
public class Row extends ArrayList<Seat> {

  private Integer rowNumber;
  private Boolean wheelchairOrNot;

  /**
   * Constructor of Row
   * @param rowNumber - row number as Integer
   * @param wheelchairOrNot - Whether the row is for wheel-chair or not as Boolean
   */
  public Row(Integer rowNumber, Boolean wheelchairOrNot) {
    this.rowNumber = rowNumber;
    this.wheelchairOrNot = wheelchairOrNot;
  }

  /**
   * Method to createRow (Helper Function)
   * @param rowNumber - row number as Integer
   * @param wheelchairOrNot - Whether the row is for wheel-chair or not as Boolean
   * @return row as Row
   */
  public static Row createRow(Integer rowNumber, Boolean wheelchairOrNot){
    Row row = new Row(rowNumber, wheelchairOrNot);
    return row;
  }

  /**
   * Getter of row number
   * @return rowNumber as Integer
   */
  public Integer getRowNumber() {
    return rowNumber;
  }

  /**
   * Getter of wheelchairOrNot
   * @return wheelchairOrNot as Boolean
   */
  public Boolean getWheelchairOrNot() {
    return wheelchairOrNot;
  }

  @Override
  public String toString() {
    String row = "";
    for(int i = 0; i<this.size(); i++){
      row += this.get(i).toString();
    }
    return row;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return Objects.equals(rowNumber, seats.rowNumber) && Objects.equals(
        wheelchairOrNot, seats.wheelchairOrNot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNumber, wheelchairOrNot);
  }
}
