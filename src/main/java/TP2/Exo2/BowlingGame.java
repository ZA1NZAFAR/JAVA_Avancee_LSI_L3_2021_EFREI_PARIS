package TP2.Exo2;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    int index;
    List<BowlingFrame> frames;

    public BowlingGame() {
        frames = new ArrayList<>();
    }

    public int getScorePourFrame(int frame) {
        return frames.get(frame).getScore();
    }


    //avant d'inserer un nouveau frame, on verifie que le nombre de frame n'est pas atteint (10)
    //on verifie que le dernier frame est bien un frameLast (qui ne peut pas avoir de bonus)
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
        calculateBonuses(); //on calcule les bonus avant de calculer le score total
        int score = 0;
        for (BowlingFrame frame : frames) {
            score += frame.getScore();
        }
        return score;
    }

    public void calculateBonuses() {
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) instanceof BowlingFrameLast) // si c'est le dernier frame on ne fait rien
                break;
            if (frames.get(i).isStrike()) { // si c'est un strike, on ajoute le score de deux lancers suivants
                if (!frames.get(i + 1).isStrike()) { // si le lancer suivant n'est pas un strike, on ajoute le score du lancer suivant
                    frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore() + frames.get(i + 1).getSecondThrowScore());
                } else { // si le lancer suivant est un strike, on ajoute le score du frame suivant (qui est un strike) + le score du lancer suivant
                    frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore() + frames.get(i + 2).getFirstThrowScore());
                }
            } else if (frames.get(i).isSpare()) { // si c'est un spare, on ajoute le score du lancer suivant
                frames.get(i).setBonus(frames.get(i + 1).getFirstThrowScore());
            }
        }
    }

}
