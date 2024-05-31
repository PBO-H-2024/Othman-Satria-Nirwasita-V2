/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Othman Satria
 */
public abstract class Candidate {
    protected String name;
    protected String path;
    protected int writingScore;
    protected int codingScore;
    protected int interviewScore;
    protected double finalScore;
    protected String status;

    public Candidate(String name, String path, int writingScore, int codingScore, int interviewScore) {
        this.name = name;
        this.path = path;
        this.writingScore = writingScore;
        this.codingScore = codingScore;
        this.interviewScore = interviewScore;
    }

    public abstract void calculateFinalScore();

    public String getName() { return name; }
    public String getPath() { return path; }
    public int getWritingScore() { return writingScore; }
    public int getCodingScore() { return codingScore; }
    public int getInterviewScore() { return interviewScore; }
    public double getFinalScore() { return finalScore; }
    public String getStatus() { return status; }
    
    public void setName(String name) { this.name = name; }
    public void setPath(String path) { this.path = path; }
    public void setWritingScore(int writingScore) { this.writingScore = writingScore; }
    public void setCodingScore(int codingScore) { this.codingScore = codingScore; }
    public void setInterviewScore(int interviewScore) { this.interviewScore = interviewScore; }
    public void setStatus(String status) { this.status = status; }
}

