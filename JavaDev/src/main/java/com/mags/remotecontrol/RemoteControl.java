package com.mags.remotecontrol;

import java.util.HashMap;
import javafx.util.Pair;
import java.lang.Math;

public class RemoteControl {

    private HashMap<String, Pair<Integer,Integer> >  characterPositions = new HashMap<>();

    //improved first initialise but left it in for viewing,
    //for readability created an array of arrays and iterated through
    public RemoteControl() {
        /* characterPositions.put("a", new Pair(0, 0));
        characterPositions.put("b", new Pair(0, 1));
        characterPositions.put("c", new Pair(0, 2));
        characterPositions.put("d", new Pair(0, 3));
        characterPositions.put("e", new Pair(0, 4));
        characterPositions.put("1", new Pair(0, 5));
        characterPositions.put("2", new Pair(0, 6));
        characterPositions.put("3", new Pair(0, 7));

        characterPositions.put("f", new Pair(1, 0));
        characterPositions.put("g", new Pair(1, 1));
        characterPositions.put("h", new Pair(1, 2));
        characterPositions.put("i", new Pair(1, 3));
        characterPositions.put("j", new Pair(1, 4));
        characterPositions.put("4", new Pair(1, 5));
        characterPositions.put("5", new Pair(1, 6));
        characterPositions.put("6", new Pair(1, 7));

        characterPositions.put("k", new Pair(2, 0));
        characterPositions.put("l", new Pair(2, 1));
        characterPositions.put("m", new Pair(2, 2));
        characterPositions.put("n", new Pair(2, 3));
        characterPositions.put("o", new Pair(2, 4));
        characterPositions.put("7", new Pair(2, 5));
        characterPositions.put("8", new Pair(2, 6));
        characterPositions.put("9", new Pair(2, 7));

        characterPositions.put("p", new Pair(3, 0));
        characterPositions.put("q", new Pair(3, 1));
        characterPositions.put("r", new Pair(3, 2));
        characterPositions.put("s", new Pair(3, 3));
        characterPositions.put("t", new Pair(3, 4));
        characterPositions.put(".", new Pair(3, 5));
        characterPositions.put("@", new Pair(3, 6));
        characterPositions.put("0", new Pair(3, 7));

        characterPositions.put("u", new Pair(4, 0));
        characterPositions.put("v", new Pair(4, 1));
        characterPositions.put("w", new Pair(4, 2));
        characterPositions.put("x", new Pair(4, 3));
        characterPositions.put("y", new Pair(4, 4));
        characterPositions.put("z", new Pair(4, 5));
        characterPositions.put("_", new Pair(4, 6));
        characterPositions.put("/", new Pair(4, 7));*/

        String[] row1 = new String[] { "a", "b", "c", "d", "e", "1", "2", "3"};
        String[] row2 = new String[] { "f", "g", "h", "i", "j", "4", "5", "6"};
        String[] row3 = new String[] { "k", "l", "m", "n", "o", "7", "8", "9"};
        String[] row4 = new String[] { "p", "q", "r", "s", "t", ".", "@", "0"};
        String[] row5 = new String[] { "u", "v", "w", "x", "y", "z", "_", "/"};

        String[][] matrix = new String[][] {row1, row2, row3, row4, row5};

        for(int i = 0; i < matrix.length; i++ ){
            for(int j = 0; j < row1.length; j++){
                characterPositions.put(matrix[i][j], new Pair(i,j));
            }

        }
    }

    public int numberOfMoves(String word) {

        Pair<Integer, Integer> startPosition = new Pair(0,0);
        int wordLength = word.length();
        int distance = 0;

        for (int i = 0; i< wordLength; i++)
        {
            String nextChar = word.substring(i, i+1);
            Pair<Integer, Integer> endPosition = characterPositions.get(nextChar);
            distance = distance + Math.abs(endPosition.getKey() - startPosition.getKey()) + Math.abs(( endPosition.getValue() - startPosition.getValue()));
            //increment distance for the use of OK
            distance++;
            startPosition = endPosition;
        }
        return distance;
    }
}
