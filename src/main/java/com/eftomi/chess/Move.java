package com.eftomi.chess;

import com.eftomi.chess.coordinate.HumanCoordinate;

public class Move {
    private HumanCoordinate fromHumanCoordinate;
    private HumanCoordinate toHumanCoordinate;

    private HumanCoordinate createHumanCoordinate(String coordinates) {
        HumanCoordinate humanCoordinate = new HumanCoordinate();
        String[] list = coordinates.split("");
        humanCoordinate.setRow(Integer.parseInt(list[1]));
        humanCoordinate.setColumn(list[0].charAt(0));
        return humanCoordinate;
    }

    public HumanCoordinate getFromHumanCoordinate() {
        return fromHumanCoordinate;
    }

    public void setFromHumanCoordinate(String fromHumanCoordinate) {
        this.fromHumanCoordinate = createHumanCoordinate(fromHumanCoordinate);
    }


    public HumanCoordinate getToHumanCoordinate() {
        return toHumanCoordinate;
    }

    public void setToHumanCoordinate(String toHumanCoordinate) {
        this.toHumanCoordinate = createHumanCoordinate(toHumanCoordinate);
    }

}
