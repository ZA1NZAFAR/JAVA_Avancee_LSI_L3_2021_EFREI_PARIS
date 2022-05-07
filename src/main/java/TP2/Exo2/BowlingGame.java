package TP2.Exo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BowlingGame {
    int index;
    List<BowlingFrame> frames;

    public BowlingGame() {
        frames = new ArrayList<BowlingFrame>();
    }


    public void enregisterFrame(BowlingFrame frame) {
        if (frames.size() >= 10)
            throw new IllegalStateException("Maximum de 10 frames atteint");
        if (frame instanceof BowlingFrameLast && frames.size() != 9)
            throw new IllegalArgumentException("Uniquement le dernier frame doit être terminale (BowlingFrameLast)");
        if (!(frame instanceof BowlingFrameLast) && frames.size() == 9)
            throw new IllegalArgumentException("Le dernier frame doit être terminale (BowlingFrameLast)");
        frames.add(frame);

    }

    public int getScoreTotale() {
        calculateBonuses();
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            score += frames.get(i).getScore();
        }
        return score;
    }

    public int getScorePourFrame(int frame) {
        return frames.get(frame).getScore();
    }

    public void calculateBonuses(){
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) instanceof BowlingFrameLast)
                break;
            if (frames.get(i).isStrike()) {
                if (!frames.get(i + 1).isStrike()) {
                    frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore() + frames.get(i + 1).getSecondThrowScore());
                } else {
                    frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore() + frames.get(i + 2).getFirstThrowScore());
                }
            }else if (frames.get(i).isSpare()) {
                frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore());
            }
        }
    }

}
