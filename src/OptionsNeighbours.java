import java.util.ArrayList;

public class OptionsNeighbours {

  public int num;
  public ArrayList<String> variant;
  public int predecessorBallCell;

  public OptionsNeighbours(int num, ArrayList<String> variant, int predecessorBallCell) {
    this.num = num;
    this.variant = variant;
    this.predecessorBallCell = predecessorBallCell;
  }
}
