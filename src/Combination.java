public class Combination implements HasSize {
  private final Structure first;
  private final Structure second;
  private final int offsetX;
  private final int offsetY;

  private final double width;

  public Combination(final Structure first, final Structure second, final int offsetX, final int offsetY) {
    this.first = first;
    this.second = second;
    this.offsetX = offsetX;
    this.offsetY = offsetY;

    double firstX = first.radius;
    double firstY = first.radius;
    double secondX = offsetX + second.radius;
    double secondY = offsetY + second.radius;
    double dx = firstX - secondX;
    double dy = firstY - secondY;
    double distance = Math.sqrt(dx * dx + dy * dy);
    width = distance - first.radius - second.radius;
  }

  @Override
  public String toString() {
    int height = Math.max(first.size, offsetY + second.size);
    int width = offsetX + second.size;
    char[][] output = new char[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        output[i][j] = '.';
      }
    }
    first.fill(output, 0, 0);
    second.fill(output, offsetX, offsetY);
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++) {
        sb.append(output[i][j]);
      }
      sb.append('\n');
    }
    //sb.append("Size: ").append(this.width);
    //sb.append('\n');
    return sb.toString();
  }

  @Override
  public double getSize() {
    return width;
  }
}
