import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {

  private static final Combination DIAGONAL_PYLONS = new Combination(Structure.Pylon, Structure.Pylon, 2, 2);
  private static final Combination DIAGONAL_PYLONS_OFFSET = new Combination(Structure.Pylon, Structure.Pylon, 2, 3);
  private static final Combination PYLONS_WITH_GAP = new Combination(Structure.Pylon, Structure.Pylon, 3, 0);
  private static final Combination PYLONS_WITH_GAP_2 = new Combination(Structure.Pylon, Structure.Pylon, 4, 0);

  @Test
  public void testProbe() {
    assertCanFit(Unit.Probe, PYLONS_WITH_GAP);
    assertCanFit(Unit.Probe, DIAGONAL_PYLONS);
  }

  @Test
  public void testRoach() {
    assertCanFit(Unit.Roach, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.Roach, DIAGONAL_PYLONS);
  }

  @Test
  public void testStalker() {
    assertCanFit(Unit.Stalker, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.Stalker, DIAGONAL_PYLONS);
  }

  @Test
  public void testQueen() {
    assertCanFit(Unit.Queen, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.Queen, DIAGONAL_PYLONS);
  }

  @Test
  public void testArchon() {
    assertCanNotFit(Unit.Archon, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.Archon, DIAGONAL_PYLONS);
    assertCanFit(Unit.Archon, DIAGONAL_PYLONS_OFFSET);
  }

  @Test
  public void testSiegeTank() {
    assertCanNotFit(Unit.SiegeTank, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.SiegeTank, DIAGONAL_PYLONS);
    assertCanNotFit(Unit.SiegeTank, DIAGONAL_PYLONS_OFFSET);
    assertCanFit(Unit.SiegeTank, PYLONS_WITH_GAP_2);
  }

  @Test
  public void testThor() {
    assertCanNotFit(Unit.Thor, PYLONS_WITH_GAP);
    assertCanNotFit(Unit.Thor, DIAGONAL_PYLONS);
    assertCanNotFit(Unit.Thor, DIAGONAL_PYLONS_OFFSET);
    assertCanFit(Unit.Thor, PYLONS_WITH_GAP_2);
  }

  private void assertCanFit(final Unit unit, final Combination combination) {
    assertTrue(unit.getSize() < combination.getSize());
  }

  private void assertCanNotFit(final Unit unit, final Combination combination) {
    assertTrue(unit.getSize() > combination.getSize());
  }

}