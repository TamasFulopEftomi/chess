package com.eftomi.chess.coordinate;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    Map<Character, Integer> columnCrossReference = new HashMap<>();

    public IndexCoordinate createIndexCoordinate(HumanCoordinate humanCoordinate) {
        IndexCoordinate indexCoordinate = new IndexCoordinate();
        indexCoordinate.setRow(humanCoordinate.getRow() - 1);
        createColumnCrossReference();
        indexCoordinate.setColumn(columnCrossReference.get(humanCoordinate.getColumn()));
        return indexCoordinate;
    }

    private void createColumnCrossReference() {
        columnCrossReference.put('A', 0);
        columnCrossReference.put('B', 1);
        columnCrossReference.put('C', 2);
        columnCrossReference.put('D', 3);
        columnCrossReference.put('E', 4);
        columnCrossReference.put('F', 5);
        columnCrossReference.put('G', 6);
        columnCrossReference.put('H', 7);
    }

}
