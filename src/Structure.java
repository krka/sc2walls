public enum Structure {
  Nexus(4, 'N'),
  Gateway(3, 'G'),
  Pylon(2, 'P');

  public final int size;
  public final double radius;
  private final char c;

  Structure(final int size, final char c) {
    this.size = size;
    this.radius = size / 2.0;
    this.c = c;
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
}
