/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Othman Satria
 */
public class WebDev extends Candidate {
    private final double writing = 0.4;
    private final double coding = 0.35;
    private final double interview= 0.25;

    public WebDev(String name, int writingScore, int codingScore, int interviewScore) {
        super(name, "Web Developer", writingScore, codingScore, interviewScore);
        calculateFinalScore();
    }

    @Override
    public void calculateFinalScore() {
        this.finalScore = (writingScore * writing) + (codingScore * coding) + (interviewScore * interview);
        this.status = finalScore >= 70 ? "ACCEPTED" : "NOT ACCEPTED";
    }
}

