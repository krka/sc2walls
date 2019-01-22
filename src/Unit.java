public enum Unit implements HasSize {
  // Source: (Basic) movement inner radius from map editor
  Probe(0.375),
  HighTemplar(0.375),
  DarkTemplar(0.375),
  Zealot(0.375),
  Sentry(0.5),
  Adept(0.375),
  Disruptor(0.5),
  Stalker(0.5),
  Immortal(0.5),
  Archon(0.75),
  Colossus(0.75),

  SCV(0.375),
  Mule(0.375),
  Marine(0.375),
  Reaper(0.375),
  Ghost(0.375),
  WidowMine(0.375),
  Marauder(0.375),
  Hellion(0.375),
  Viking(0.375),
  SiegeTank(0.875),
  Thor(1.0),

  Drone(0.375),
  Zergling(0.375),
  Baneling(0.375),
  InfestedTerran(0.375),
  Locust(0.375),
  Changeling(0.375),
  Broodling(0.375),
  Roach(0.625),
  Hydralisk(0.375),
  Ravager(0.5),
  Lurker(0.5),
  Infestor(0.5),
  SwarmHost(0.5),
  Queen(0.5),
  Ultralisk(0.75),
  ;

  private final double innerRadius;

  Unit(final double innerRadius) {
    this.innerRadius = innerRadius;
  }

  @Override
  public double getSize() {
    return innerRadius * 2.0;
  }
}
