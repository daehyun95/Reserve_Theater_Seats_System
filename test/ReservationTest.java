package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
  private ReservationSystem testSystem;
  private ReservationService testService;
  private Row testRow;
  private Seat testSeat;
  private Person testPerson;
  private Theater testTheater;



  @BeforeEach
  void setUp() {
    testTheater = new Theater();
    testSeat = new Seat("A", Boolean.FALSE);
    testPerson = new Person("Mike Dean");
    testService = new ReservationService(testTheater);
    testSystem = new ReservationSystem();
  }

  @Test
  void testPerson() {
    assertEquals("Mike Dean", testPerson.getName());
    // testEquals_same
    assertTrue(testPerson.equals(testPerson));
    // testEquals_sameAddress
    Person copyName = new Person("Mike Dean");
    assertTrue(testPerson.equals(copyName));
    // testEquals_null
    assertFalse(testPerson.equals(null));
    // testEquals getClass() != o.getClass()
    assertFalse(testPerson.equals("None"));
    Person differentName = new Person("Mike");
    assertFalse(testPerson.equals(differentName));
    assertEquals(copyName.hashCode(), testPerson.hashCode());
    String expectedToString = "Person{" +
        "name='" + "Mike Dean" + '\'' +
        '}';
    assertEquals(expectedToString, testPerson.toString());
  }

  @Test
  void testTheater() {
    Row row1 = Row.createRow(1, false);
    row1.addAll(testTheater.createSeats());
    Row row2 = Row.createRow(2, false);
    row2.addAll(testTheater.createSeats());
    Row row3 = Row.createRow(3, false);
    row3.addAll(testTheater.createSeats());
    Row row4 = Row.createRow(4, false);
    row4.addAll(testTheater.createSeats());
    Row row5 = Row.createRow(5, true);
    row5.addAll(testTheater.createWheelSeats());
    Row row6 = Row.createRow(6, false);
    row6.addAll(testTheater.createSeats());
    Row row7 = Row.createRow(7, false);
    row7.addAll(testTheater.createSeats());
    Row row8 = Row.createRow(8, false);
    row8.addAll(testTheater.createSeats());
    Row row9 = Row.createRow(9, true);
    row9.addAll(testTheater.createWheelSeats());
    Row row10 = Row.createRow(10, false);
    row10.addAll(testTheater.createSeats());
    Row row11 = Row.createRow(11, false);
    row11.addAll(testTheater.createSeats());
    Row row12 = Row.createRow(12, false);
    row12.addAll(testTheater.createSeats());
    Row row13 = Row.createRow(13, false);
    row13.addAll(testTheater.createSeats());
    ArrayList<Row> testRows = new ArrayList<>(Arrays.asList(row1, row2,
        row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13));


    assertEquals("Paramount", testTheater.getName());
    assertEquals(testRows.toString() , testTheater.getRows().toString());
    String ExpectedToString = "1   _  _  _  _  _  _  _  _ " +"\n"
                              +"2   _  _  _  _  _  _  _  _ "+"\n"
                              +"3   _  _  _  _  _  _  _  _ "+"\n"
                              +"4   _  _  _  _  _  _  _  _ "+"\n"
                              +"5   =  =  =  =  =  =  =  = "+"\n"
                              +"6   _  _  _  _  _  _  _  _ "+"\n"
                              +"7   _  _  _  _  _  _  _  _ "+"\n"
                              +"8   _  _  _  _  _  _  _  _ "+"\n"
                              +"9   =  =  =  =  =  =  =  = "+"\n"
                              +"10  _  _  _  _  _  _  _  _ "+"\n"
                              +"11  _  _  _  _  _  _  _  _ "+"\n"
                              +"12  _  _  _  _  _  _  _  _ "+"\n"
                              +"13  _  _  _  _  _  _  _  _ " +"\n";
    assertEquals( ExpectedToString, testTheater.toString());
  }

  @Test
  void testSeat() {
    assertEquals("A", testSeat.getName());
    assertEquals(false, testSeat.getWheelchairOrNot());
    assertEquals(null, testSeat.getReservedFor());
    assertEquals(" _ ", testSeat.toString());
    testSeat.setReservedFor(testPerson);
    assertEquals(testPerson, testSeat.getReservedFor());
    assertEquals(" X ", testSeat.toString());
  }

  @Test
  void testRow() {
    testRow = new Row(5, Boolean.FALSE);
    assertEquals(5, testRow.getRowNumber());
    assertEquals(false, testRow.getWheelchairOrNot());
    Row copyRow = new Row(5, Boolean.FALSE);
    // testEquals_same
    assertTrue(testRow.equals(testRow));
    // testEquals_sameAddress
    assertTrue(testRow.equals(copyRow));
    // testEquals_null
    assertFalse(testRow.equals(null));
    // testEquals getClass() != o.getClass()
    assertFalse(testRow.equals("None"));
    Row differentRowNum = new Row(7, Boolean.FALSE);
    assertFalse(testRow.equals(differentRowNum));
    Row differentWheelchair = new Row(5, Boolean.TRUE);
    assertFalse(testRow.equals(differentWheelchair));
    assertEquals(copyRow.hashCode(), testRow.hashCode());
    String expectedToString = "";
    assertEquals(expectedToString, testRow.toString());
  }

  @Test
  void testService() {
    testService.show();
    assertEquals(7, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(5, testService.reserve(testPerson, 8, Boolean.TRUE));
    assertEquals(null, testService.reserve(testPerson, 12, Boolean.TRUE));
    assertEquals(8, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(6, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(10, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(4, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(11, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(3, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(12, testService.reserve(testPerson, 5, Boolean.FALSE));
    assertEquals(2, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(13, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(1, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(9, testService.reserve(testPerson, 8, Boolean.FALSE));
    assertEquals(null, testService.reserve(testPerson, 5, Boolean.FALSE));
    assertEquals(12, testService.reserve(testPerson, 3, Boolean.FALSE));
  }
}