import java.util.ArrayList;
import java.util.List;

public class Options {
  public static void main(String[] args) {

    ArrayList<String> crops = new ArrayList<String>();
    crops.add("пшеница");
    crops.add("кукуруза");
    crops.add("овес");

    ArrayList<String> predecessors = new ArrayList<String>();
    predecessors.add(0, "пшеница");
    predecessors.add(1, "овес");
    predecessors.add(2, "кукуруза");
    predecessors.add(3, "кукуруза");
    predecessors.add(4, "пшеница");
    predecessors.add(5, "овес");
    predecessors.add(6, "кукуруза");
    predecessors.add(7, "овес");
    predecessors.add(8, "пшеница");


    int sizeCrops = 9;
    int arr[] = new int[sizeCrops];
    int x = 0;

    List<OptionsNeighbours> result = new ArrayList<>();
    outer:
    while (true) {
      int ballCell = 0;
      x++;
      System.out.print(x + ") ");
      ArrayList<String> optionCrops = new ArrayList<String>();
      for (int ndx : arr) {

        String currentCorp = crops.get(ndx);
        optionCrops.add(currentCorp);
        int indexOfCurrentCell = optionCrops.size() - 1;

        if (currentCorp.equals("кукуруза")) {
          if (predecessors.get(indexOfCurrentCell).equals("кукуруза") || predecessors.get(indexOfCurrentCell).equals("овес")) {
            ballCell = ballCell + 10;
          } else if (predecessors.get(indexOfCurrentCell).equals("пшеница")) {
            ballCell = ballCell + 5;
          }
        } else if (currentCorp.equals("пшеница")) {
          if (predecessors.get(indexOfCurrentCell).equals("кукуруза") || predecessors.get(indexOfCurrentCell).equals("пшеница")) {
            ballCell = ballCell + 10;
          } else if (predecessors.get(indexOfCurrentCell).equals("овес")) {
            ballCell = ballCell + 0;
          }
        } else if (currentCorp.equals("овес")) {
          if (predecessors.get(indexOfCurrentCell).equals("кукуруза") || predecessors.get(indexOfCurrentCell).equals("овес")) {
            ballCell = ballCell - 10;
          } else if (predecessors.get(indexOfCurrentCell).equals("пшеница")) {
            ballCell = ballCell + 5;
          }
        }

        System.out.print(currentCorp + " ");
      }

      System.out.print(" Балл: " + ballCell);
      System.out.println();
      OptionsNeighbours optionsNeighbours = new OptionsNeighbours(x, optionCrops, ballCell);
      result.add(optionsNeighbours);
      int i = sizeCrops - 1;
      while (arr[i] == crops.size() - 1) {
        arr[i] = 0;
        i--;
        if (i < 0) break outer;
      }
      arr[i]++;
    }
  }
}


