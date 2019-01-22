import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    final ArrayList<HasSize> combinations = new ArrayList<>();

    combinations.addAll(Arrays.asList(Unit.values()));

    final Structure[] values = Structure.values();
    for (int firstI = 0; firstI < values.length; firstI++) {
      final Structure first = values[firstI];
      for (int secondI = firstI; secondI < values.length; secondI++) {
        final Structure second = values[secondI];
        for (int i = 0; i < 2; i++) {
          for (int j = 0; j <= first.size; j++) {
            combinations.add(new Combination(first, second, first.size + i, j));
          }
        }
      }
    }

    combinations.sort(Comparator.comparingDouble(HasSize::getSize));
    List<List<HasSize>> partitions = partition(combinations);
    for (List<HasSize> partition : partitions) {
      if (partition.iterator().next() instanceof Unit) {
        for (List<HasSize> units : partition(partition, 10)) {
          System.out.println(String.join(", ", (Iterable<String>) units.stream().map(Object::toString)::iterator));
        }
        System.out.println();
      } else {
        for (List<HasSize> buildings : partition(partition, 10)) {
          System.out.print(joinLines(buildings.stream().map(Objects::toString).collect(Collectors.toList())));
        }

      }
    }
  }

  private static List<List<HasSize>> partition(final ArrayList<HasSize> combinations) {
    ArrayList<List<HasSize>> result = new ArrayList<>();
    Class<? extends HasSize> prev = null;
    ArrayList<HasSize> current = null;
    for (HasSize combination : combinations) {
      if (combination.getClass() != prev) {
        if (current != null) {
          result.add(current);
        }
        current = new ArrayList<>();
        prev = combination.getClass();
      }
      current.add(combination);
    }
    if (!current.isEmpty()) {
      result.add(current);
    }
    return result;
  }

  private static String joinLines(List<String> list) {
    List<List<String>> listList = list.stream()
        .map(s -> s.split("\n")).map(Arrays::asList)
        .collect(Collectors.toList());

    // list of (list of lines)
    final int columns = listList.size();
    final int rows = listList.stream().mapToInt(List::size).max().getAsInt();
    final List<Integer> columnWidths = listList.stream()
            .map(list2 -> list2.stream().mapToInt(String::length).max().getAsInt())
        .collect(Collectors.toList());

    final StringBuilder sb = new StringBuilder();
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        List<String> strings = listList.get(column);
        String s = strings.size() > row ? strings.get(row) : "";
        sb.append(s);
        int padding = columnWidths.get(column) - s.length();
        for (int k = 0; k < padding; k++) {
          sb.append(' ');
        }
        if (column == columns - 1) {
          sb.append("\n");
        } else {
          sb.append("  |  ");
        }
      }
    }
    sb.append("\n");
    return sb.toString();
  }

  private static <T> List<List<T>> partition(final List<T> list, final int count) {
    final Iterator<T> iterator = list.iterator();
    final List<List<T>> result = new ArrayList<>();
    List<T> current = new ArrayList<>();
    while (iterator.hasNext()) {
      current.add(iterator.next());
      if (current.size() >= count) {
        result.add(current);
        current = new ArrayList<>();
      }
    }
    if (current.size() > 0) {
      result.add(current);
    }
    return result;
  }


}
