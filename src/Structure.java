public enum Structure {
  Nexus(5, 'N', "-1,-2.5;-2.5,-1;-2.5,1;-1,2.5;1,2.5;2.5,1;2.5,-1;1,-2.5:7,0,2;0,1,2;1,2,2;2,3,2;3,4,2;4,5,2;5,6,2;6,7,2"),
  Gateway(3, 'G', "-1.5,-1;-1.5,1;-1,1.5;1,1.5;1.5,1;1.5,-1;1,-1.5;-1,-1.5:7,0,2;0,1,2;1,2,2;2,3,2;3,4,2;4,5,2;5,6,2;6,7,2"),
  Pylon(2, 'P', "-1,0.5;-0.5,1;0.5,1;1,0.5;1,-0.5;0.5,-1;-0.5,-1;-1,-0.5:7,0,2;0,1,2;1,2,2;2,3,2;3,4,2;4,5,2;5,6,2;6,7,2");

  public final int size;
  private final char c;
  private final Polygon polygon;

  Structure(final int size, final char c, final String contour) {
    this.size = size;
    this.c = c;
    polygon = Polygon.parse(contour).add(new Point(size / 2.0, size / 2.0));
  }

  void fill(final char[][] output, final int x, final int y) {
    for (int i = 1; i < size - 1; i++) {
      for (int j = 1; j < size - 1; j++) {
        output[x + i][y + j] = ' ';
      }
    }
    output[x + 1][y + 1] = c;
    for (int i = 1; i < size - 1; i++) {
      output[x + i][y + 0] = '─';
      output[x + i][y + size - 1] = '─';
      output[x + 0][y + i] = '│';
      output[x + size - 1][y + i] = '│';
    }
    output[x + 0][y + 0] = '┌';
    output[x + 0][y + size - 1] = '└';
    output[x + size - 1][y + 0] = '┐';
    output[x + size - 1][y + size - 1] = '┘';
  }

  public Polygon getPolygon() {
    return polygon;
  }
}
