package br.edu.ifbaiano.homines.api.DTO.overview;

public class ProbationaryStageDTO {

	private String probationaryStageAvaliation;
	private String nextAvaliation;
	private int avaliation;
	private boolean situationFinished;
	
	public String getProbationaryStageAvaliation() {
		return probationaryStageAvaliation;
	}
	public void setProbationaryStageAvaliation(String probationaryStageAvaliation) {
		this.probationaryStageAvaliation = probationaryStageAvaliation;
	}
	public String getNextAvaliation() {
		return nextAvaliation;
	}
	public void setNextAvaliation(String nextAvaliation) {
		this.nextAvaliation = nextAvaliation;
	}
	public int getAvaliation() {
		return avaliation;
	}
	public void setAvaliation(int avaliation) {
		this.avaliation = avaliation;
	}
	public boolean isSituationFinished() {
		return situationFinished;
	}
	public void setSituationFinished(boolean situationFinished) {
		this.situationFinished = situationFinished;
	}
	
}
