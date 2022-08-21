package problem1;

import java.util.Objects;

/**
 * Class of Person tracking name
 */
public class Person {

  private String name;

  /**
   * Constructor of Person
   * @param name - name of person as String
   */
  public Person(String name) {
    this.name = name;
  }

  /**
   * Getter of person name
   * @return name as String
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        '}';
  }
}
